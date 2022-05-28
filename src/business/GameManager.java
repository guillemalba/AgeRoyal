package business;



import business.entities.Base;
import business.entities.Board;
import business.entities.Troop;
import business.entities.GameTimer;
import business.entities.*;
import business.entities.MoneyCounter;
import persistence.GameDAO;
import persistence.GameSQLDAO;
import presentation.controllers.GameViewController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GameManager{

    private int time = 0;

    private MoneyCounter moneyCounter;
    private GameTimer gameTimer;
    private Board board;

    private GameViewController gameController;
    private GameDAO gameDAO;
    private LinkedList<Game> games;
    private IA ia;
    private User user;
    private LinkedList<Troop> linkedList = new LinkedList<>();
    private LinkedList<TroopDeployed> listDeployedTroops = new LinkedList<>();
    private HashMap<String, BufferedImage> images = new HashMap<>();
    private UserManager userManager;
    private Base baseUser;
    private Base baseIA;
    private boolean isRepro;


    public GameManager(GameDAO gameSQLDAO,UserManager userManager) {
        this.gameDAO = gameSQLDAO;
        this.userManager = userManager;
    }

    public LinkedList<Game> updateGames() {
        if(games != null) games.removeAll(games);
        games = gameDAO.readAllGames();
        return games;
    }

    public boolean isRepro() {
        return isRepro;
    }

    public void setRepro(boolean repro) {
        isRepro = repro;
    }

    public void initGame(){
        board = new Board();

        readImages();

        baseIA = new Base("BaseMAquina",0,7,this, false,false, images.get("ia_base"));
        baseUser = new Base("BasePlayer",14,7,this, true,false, images.get("user_base"));
        new Thread(baseUser).start();
        new Thread(baseIA).start();
        board.setTroopBoard(baseIA);
        board.setTroopBoard(baseUser);


        // thread para la IA del juego
        ia = new IA(this, time);
        new Thread(ia).start();

        //Usuario de la partida
        user = new User(this,time);

        // thread para contar el dinero de la IA
        moneyCounter = new MoneyCounter(this); // TODO si hay tiempo hacerlo en el manager todo
        new Thread(moneyCounter).start();

        //Thread del tiempo
        gameTimer = new GameTimer(time, false, this);
        new Thread(gameTimer).start();
        updateViewMap(false);


    }

    public void initReproGame() {
        board = new Board();
        readImages();

        baseIA = new Base("BaseMAquina", 0, 7, this, false, false, images.get("ia_base"));
        baseUser = new Base("BasePlayer", 14, 7, this, true, false, images.get("user_base"));
        new Thread(baseUser).start();
        new Thread(baseIA).start();
        board.setTroopBoard(baseIA);
        board.setTroopBoard(baseUser);


        //Thread del tiempo

        updateViewMap(true);
    }

    public void sumMoney(){
        user.setMoney(user.getMoney()+1);
        ia.setMoney(ia.getMoney() + 1);
    }

    public void stopGame(boolean isUser, boolean somebodyWon){

        //Parar todos los threads
        for (int i = 0; i < board.getSide(); i++) {
            for (int j = 0; j < board.getSide(); j++) {
                if(!board.isEmpty(i,j)){
                    board.killTroop(i,j);

                }
            }
        }
        gameTimer.stop();
        moneyCounter.stop();
        ia.setStop(true);

        if (somebodyWon) {
            String gameName = gameController.saveGame();
            if (gameName != null) {
                String actualDate = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(LocalDateTime.now());
                if (gameDAO.saveGame(new Game(gameName, actualDate, !isUser, userManager.getUser()))){
                    for (int i = 0; i < listDeployedTroops.size(); i++) {
                        if (gameDAO.saveTroopsDeployed(listDeployedTroops.get(i), gameName)) {

                        }
                    }
                }
            }
            gameController.finishGame();
        }
    }

    public Board getBoard() {
        return board;
    }

    public int getTime() {
        return time;
    }

    public void registerController(GameViewController controller) {
        this.gameController = controller;
    }

    public void updateViewMap(boolean isRepro){

        if (isRepro){
            gameController.addTroop(board,0,baseUser.getLife(),baseIA.getLife());

        }else {
            gameController.addTroop(board, user.getMoney(), baseUser.getLife(), baseIA.getLife());
            System.out.println("user:" + user.getNumTroopAlive());
            System.out.println("ia: " + ia.getNumTroopsAlive());
        }

    }




    public synchronized void addTroop(Attributes troopId, int x, int y, boolean isUser, String key) {

        switch (troopId) {
            case ARCHER_ID -> linkedList.add(new Archer("archer100Maquina",x,y,this, isUser,false, images.get(key)));
            case CANNON_ID -> linkedList.add(new Canon("CanonPlayer",x,y,this,isUser,false, images.get(key)));
            case GIANT_ID -> linkedList.add(new Giant("GigantePlayer1",x,y,this,isUser,false, images.get(key)));
            case TESLA_ID -> linkedList.add(new TeslaTower("tesla100Maquina",x,y,this, isUser,false,images.get(key)));
        }

        if (linkedList.size() > 0) {
            Troop newTroop = linkedList.get(linkedList.size() - 1);
            listDeployedTroops.add(new TroopDeployed(troopId.getValue(), time, x, y, isUser));
            board.setTroopBoard(newTroop);
            new Thread(newTroop).start();

            if (!isRepro) {
                if (isUser) {
                    user.setMoney(user.getMoney() - newTroop.getCost());
                    user.setNumTroopAlive(user.getNumTroopAlive() + 1);


                } else {
                    ia.setMoney(ia.getMoney() - newTroop.getCost());
                    ia.setNumTroopsAlive(ia.getNumTroopsAlive() + 1);
                }
            }
        }
    }

    public void posTroop(Attributes tipo,int x, int y){
        if(board.isEmpty(x,y)) {
            switch (tipo) {

                case ARCHER_ID:
                    if (user.getMoney() >= Attributes.ARCHER_COST.getValue())
                        addTroop(tipo, x, y, true, "user_archer");
                    break;
                case CANNON_ID:
                    if (user.getMoney() >= Attributes.GIANT_COST.getValue())
                        addTroop(tipo, x, y, true, "user_cannon");
                    break;
                case GIANT_ID:
                    if (user.getMoney() >= Attributes.CANNON_COST.getValue())
                        addTroop(tipo, x, y, true, "user_giant");
                    break;
                case TESLA_ID:
                    if (user.getMoney() >= Attributes.TESLA_COST.getValue())
                        addTroop(tipo, x, y, true, "user_tesla");
                    break;
                default:
                    System.out.println("Bro eso esta caro");
                    break;
            }
        }
        else{
            System.out.println("Ja esta ocupada");
        }
    }

    public void addRecordedTroop(int troopID, int x, int y, boolean isUser){
        System.out.println("te pinto la tropa: " + troopID);
        switch (troopID) {

            case 0:
                if(isUser) {
                    addTroop(Attributes.ARCHER_ID, x, y, isUser, "user_archer");
                }else{
                    addTroop(Attributes.ARCHER_ID, x, y, isUser, "ia_archer");
                }


                break;
            case 2:
                if(isUser) {
                    addTroop(Attributes.CANNON_ID, x, y, isUser, "user_cannon");
                }else{
                    addTroop(Attributes.CANNON_ID, x, y, isUser, "ia_cannon");
                }
                break;
            case 1:
                if(isUser) {
                    addTroop(Attributes.GIANT_ID, x, y, isUser, "user_giant");
                }else{
                    addTroop(Attributes.GIANT_ID, x, y, isUser, "ia_giant");
                }
                break;
            case 3:
                if(isUser) {
                    addTroop(Attributes.TESLA_ID, x, y, isUser, "user_tesla");
                }else{
                    addTroop(Attributes.TESLA_ID, x, y, isUser, "ia_tesla");
                }


                break;
            default:
                System.out.println("Bro eso esta caro");
                break;
        }
    }




    public void setTime(int time) {
        this.time = time;
    }

    public void readImages () {

        try {
            images.put("ia_archer", ImageIO.read(new File("files/ia_archer.png")));
            images.put("ia_cannon", ImageIO.read(new File("files/ia_cannon.png")));
            images.put("ia_tesla", ImageIO.read(new File("files/ia_tesla.png")));
            images.put("ia_giant", ImageIO.read(new File("files/ia_giant.png")));
            images.put("ia_base", ImageIO.read(new File("files/ia_base.png")));

            images.put("user_archer", ImageIO.read(new File("files/user_archer.png")));
            images.put("user_cannon", ImageIO.read(new File("files/user_cannon.png")));
            images.put("user_tesla", ImageIO.read(new File("files/user_tesla.png")));
            images.put("user_giant", ImageIO.read(new File("files/user_giant.png")));
            images.put("user_base", ImageIO.read(new File("files/user_base.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void moneyReward(boolean isUser){
        System.out.println("le sumo la pasta");
         if(isUser) user.setMoney(user.getMoney()+3);
         if(!isUser) ia.setMoney(ia.getMoney()+3);


    }


    public void removeTroop(boolean isUser){
        if(!isRepro) {
            if (isUser) ia.setNumTroopsAlive(ia.getNumTroopsAlive() - 1);
            if (!isUser) user.setNumTroopAlive(user.getNumTroopAlive() - 1);
        }
    }
}
