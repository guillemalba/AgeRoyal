package business;



import business.entities.Base;
import business.entities.Board;
import business.entities.Troop;
import business.threads.GameTimer;
import business.entities.*;
import business.threads.MoneyCounter;
import persistence.GameDAO;
import persistence.GameSQLDAO;
import presentation.controllers.GameViewController;

import java.awt.*;
import java.util.LinkedList;

public class GameManager{

    private int time = 0;

    private MoneyCounter moneyCounter;
    private GameTimer gameTimer;
    private Board board;
    private LinkedList<Troop> troops= new LinkedList();

    private GameViewController gameController;
    private GameDAO gameDAO;
    private LinkedList<Game> games;
    private IA ia;
    private User user;
    private LinkedList<Troop> linkedList = new LinkedList<>();


    public GameManager(UserManager userManager) {
        gameDAO = new GameSQLDAO();
    }

    public LinkedList<Game> updateGames() {
        if(games != null) games.removeAll(games);
        games = gameDAO.readAllGames();
        return games;
    }

    public void initGame(){
        board = new Board();



        Base baseIA = new Base("BaseMAquina",0,7,this, false,false,Color.ORANGE);
        Base baseUser = new Base("BasePlayer",14,7,this, true,false,Color.ORANGE);
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
        moneyCounter = new MoneyCounter(this,ia,user);
        new Thread(moneyCounter).start();



        //Thread del tiempo
        gameTimer = new GameTimer(time, false, this);
        new Thread(gameTimer).start();

    }

    public void stopGame(){

        //guardar partida



        //Parar todos los threads
        for (int i = 0; i < board.getSide(); i++) {
            for (int j = 0; j < board.getSide(); j++) {
                if(!board.isEmpty(i,j)){
                    board.killTroop(i,j);

                }
            }
        }

        //Poner aquie lo de guardar partida
        gameTimer.stop();
        gameController.finishGame();

    }

    public Board getBoard() {
        return board;
    }

    public void registerController(GameViewController controller) {
        this.gameController = controller;
    }

    public void UpdateViewMap(){
        gameController.addTroop(board,user.getMoney());

    }




    public synchronized void addTroop(Attributes troopId, int x, int y, int timeAdded, boolean isUser) {
        switch (troopId) {
            case ARCHER_ID -> linkedList.add(new Archer("archer100Maquina",x,y,this, isUser,false, Color.YELLOW));
            case CANNON_ID -> linkedList.add(new Canon("CanonPlayer",x,y,this,isUser,false,Color.ORANGE));
            case GIANT_ID -> linkedList.add(new Giant("GigantePlayer1",x,y,this,isUser,false,Color.BLUE));
            /*case TESLA -> linkedList.add(new TeslaTower("tesla100Maquina",x,y,this, false,false, Color.YELLOW));*/
        }

        Troop newTroop = linkedList.get(linkedList.size()-1);

        board.setTroopBoard(newTroop);
        new Thread(newTroop).start();

        if (isUser) {
            user.setMoney(user.getMoney()-newTroop.getCost());


        } else {
            ia.setMoney(ia.getMoney() - newTroop.getCost());
            ia.setNumTroopsAlive(ia.getNumTroopsAlive() + 1);
        }


    }
    public void posTroop(Attributes tipo,int x, int y){
        switch (tipo) {
            case ARCHER_ID: if(user.getMoney()>=Attributes.ARCHER_COST.getValue()) addTroop(tipo,x,y,time,true) ;
            case CANNON_ID : if(user.getMoney()>=Attributes.GIANT_COST.getValue()) addTroop(tipo,x,y,time,true) ;
            case GIANT_ID : if(user.getMoney()>=Attributes.CANNON_COST.getValue()) addTroop(tipo,x,y,time,true) ;
            /*case TESLA : if(user.getMoney()>=Attributes.TESLA_COST.getValue()) addTroop(tipo,x,y,time,true);*/
            default : System.out.println("Bro eso esta caro");
        }
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

}
