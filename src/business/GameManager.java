package business;



import business.entities.Base;
import business.entities.Board;
import business.entities.Troop;
import business.entities.GameTimer;
import business.entities.*;
import business.entities.MoneyCounter;
import persistence.GameDAO;
import presentation.controllers.GameViewController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Clase que controla lo relacionado con la partida que se esta reproduciendo al momento, se encarga de guardar la partida, etc...
 */
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
    private boolean stopRepro;
    private boolean pauseRepro;

    /**
     * Constructor del juego
     *
     * @param gameSQLDAO la interficie del juego para llamar a las funciones de la DAO
     * @param userManager manager del jugador
     */
    public GameManager(GameDAO gameSQLDAO, UserManager userManager) {
        this.gameDAO = gameSQLDAO;
        this.userManager = userManager;
    }

    /**
     * Metodo que devuelve una lista de los juegos guardados del jugador
     *
     * @return lista de juegos
     */
    public LinkedList<Game> readUserGames() {
        if(games != null) games.removeAll(games);
        games = gameDAO.readUserGames(userManager.getUser());
        return games;
    }

    /**
     * Comprueba si la partida se esta jugando o es una grabacion
     *
     * @return true si se esta jugando
     */
    public boolean isRepro() {
        return isRepro;
    }

    /**
     * Setter para asignar si la partida es a tiempo real o grabada
     *
     * @param repro true si se esta jugando
     */
    public void setRepro(boolean repro) {
        isRepro = repro;
    }

    /**
     * Metodo que inicia una partida a tiempo real de un jugador contra la maquina
     */
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
        moneyCounter = new MoneyCounter(this);
        new Thread(moneyCounter).start();

        //Thread del tiempo
        gameTimer = new GameTimer(time, false, this);
        new Thread(gameTimer).start();

        updateViewMap(false);


    }

    /**
     * Metodo que inicia la grabacion de una partida seleccionada de la base de datos
     */
    public void initReproGame() {
        stopRepro = false;
        board = new Board();
        readImages();

        baseIA = new Base("BaseMAquina", 0, 7, this, false, false, images.get("ia_base"));
        baseUser = new Base("BasePlayer", 14, 7, this, true, false, images.get("user_base"));
        new Thread(baseUser).start();
        new Thread(baseIA).start();
        board.setTroopBoard(baseIA);
        board.setTroopBoard(baseUser);


        updateViewMap(true);
    }

    /**
     * Metodo que suma el dinero pasivamente de la IA i del usuario
     */
    public void sumMoney(){
        user.setMoney(user.getMoney()+1);
        ia.setMoney(ia.getMoney() + 1);
    }

    /**
     * Metodo que termina el juego, implica terminar los threads, vaciar el mapa, preguntar al usuario si la quiere guardar, y actuaizar las estadisticas del usuario
     *
     * @param userWins boolean para saber si el usuario ha ganado o no
     * @param somebodyWon boolean para saber si ha habido ganador o ha abandonado la partida
     */
    public void stopGame(boolean userWins, boolean somebodyWon){

        //Parar todos los threads
        for (int i = 0; i < board.getSide(); i++) {
            for (int j = 0; j < board.getSide(); j++) {
                if(!board.isEmpty(i,j)){
                    board.killTroop(i,j);

                }
            }
        }

        if (isRepro) {
            stopRepro = true;
            gameController.finishGame(isRepro);
        } else {
            gameTimer.stop();
            moneyCounter.stop();
            ia.setStop(true);


        if (somebodyWon) {
            String gameName;
            do {
                gameName = gameController.askForGameName(userWins);
            } while (!gameDAO.gameNameIsUnique(gameName));


                if (gameName != null) {
                    if (gameDAO.saveGame(new Game(gameName, new SimpleDateFormat("yyyy-MM-dd").format(new Date()), userWins, userManager.getUser()))) {
                        for (int i = 0; i < listDeployedTroops.size(); i++) {
                            if (gameDAO.saveTroopsDeployed(listDeployedTroops.get(i), gameName)) {

                            }
                        }
                    }
                }

                User user = userManager.readUser();
                user.setTotalGames(user.getTotalGames() + 1);
                if (userWins) {
                    user.setVictories(user.getVictories() + 1);
                }
                user.setRatio((float) user.getVictories() / (float) user.getTotalGames() * 10);
                userManager.updateUser(user);

                gameController.finishGame(isRepro);
            }
        }
    }

    /**
     * Getter para devolver el tablero
     *
     * @return el tablero con todas las celdas y tropas
     */
    public Board getBoard() {
        return board;
    }


    /**
     * Metodo para saber si se ha parado la grabacion
     *
     * @return true si es verdad, false si no
     */
    public boolean isStopRepro() {
        return stopRepro;
    }


    /**
     * Setter para asignar el controlador de la partida
     *
     * @param controller controlador
     */
    public void registerController(GameViewController controller) {
        this.gameController = controller;
    }

    /**
     * Metodo para actualizar el mapa de la partida
     *
     * @param isRepro boolean para saber si es una partida grabada o es una partida a tiempo real
     */
    public void updateViewMap(boolean isRepro){

        if (isRepro){
            gameController.addTroop(board,0,baseUser.getLife(),baseIA.getLife(),user.getNumTroopAlive(),ia.getNumTroopsAlive());

        }else {
            gameController.addTroop(board, user.getMoney(), baseUser.getLife(), baseIA.getLife(),user.getNumTroopAlive(),ia.getNumTroopsAlive());
            System.out.println("user:" + user.getNumTroopAlive());
            System.out.println("ia: " + ia.getNumTroopsAlive());
        }

    }

    /**
     * Metodo que añade una tropa en una linked list, tambien añade una tropa desplegada a otra linked list con la posicion inicial de la tropa,
     * el segundo en que ha sido desplegada, el id de la tropa y un boolean para saber si es de usuario o de la IA
     *
     * @param troopId id (arquera, gigante, canon, tesla)
     * @param x posicion
     * @param y posicion
     * @param isUser si es del usuario o de la IA
     * @param key id de la imagen de la tropa
     */
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

    /**
     * Metodo que intenta añadir una tropa de los listeners del mouse del usuario al mapa
     *
     * @param tipo de tropa
     * @param x posicion
     * @param y posicion
     */
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

                    break;
            }
        }
        else{
            System.out.println("Ja esta ocupada");
        }
    }

    /**
     * Esta funcion hace un switch case que nos viene del RecordedManager para añadir las tropas en el board
     * separa en funcion del tipo de tropa que quiere pintar.
     *
     * @param troopID el id de la tropa
     * @param x posicion x
     * @param y posicion y
     * @param isUser si es del usuatrio
     */
    public void addRecordedTroop(int troopID, int x, int y, boolean isUser){

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

                break;
        }
    }

    /**
     * Setter del tiempo de la partida
     *
     * @param time de la partida
     */
    public void setTime(int time) {
        this.time = time;
    }

    /**
     * Metodo que lee las imagenes de las tropas
     */
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

    /**
     * Metodo que suma dinero a la IA y al usuario tras matar una tropa
     *
     * @param isUser si es IA o usuario
     */
    public void moneyReward(boolean isUser){

         if(isUser) user.setMoney(user.getMoney()+3);
         if(!isUser) ia.setMoney(ia.getMoney()+3);


    }

    /**
     * Metodo que elimina una tropa del contador de tropas vivas en el mapa
     *
     * @param isUser si es del usuario o de la IA
     */
    public void removeTroop(boolean isUser){
        if(!isRepro) {
            if (isUser) ia.setNumTroopsAlive(ia.getNumTroopsAlive() - 1);
            if (!isUser) user.setNumTroopAlive(user.getNumTroopAlive() - 1);
        }
    }

    public void pauseRepro(boolean pause){
        pauseRepro = pause;

        if(pause) {
            for (int i = 0; i < board.getSide(); i++) {
                for (int j = 0; j < board.getSide(); j++) {
                    if (!board.isEmpty(i, j)) {
                        board.stopTroop(i, j);

                    }
                }
            }
        }
        if(!pause){

            for (int i = 0; i < board.getSide(); i++) {
                for (int j = 0; j < board.getSide(); j++) {
                    if (!board.isEmpty(i, j)) {
                        board.resumeTroop(i, j);

                    }
                }
            }

        }

    }


    /**
     * Getter para saber si el juego esta en pausa
     *
     * @return true si el juego esta en pausa
     */
    public boolean isPauseRepro() {
        return pauseRepro;
    }


}
