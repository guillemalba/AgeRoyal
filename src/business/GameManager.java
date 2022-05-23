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
    private Base base2;
    private Board board;
    private Troop base1;
    private int time;
    private LinkedList<Troop> troops= new LinkedList();
    private MoneyCounter moneyCounterIA;
    private GameTimer gameTimer;

    private GameViewController gameController;
    private GameDAO gameDAO;
    private LinkedList<Game> games;
    private IA ia;
    private LinkedList<Troop> linkedList = new LinkedList<>();

    public GameManager() {
        gameDAO = new GameSQLDAO();
    }

    public LinkedList<Game> updateGames() {
        if(games != null) games.removeAll(games);
        games = gameDAO.readAllGames();
        return games;
    }

    public void initGame(){
        board = new Board();
        gameTimer = new GameTimer(1000, time, false, this);

        Archer archer = new Archer("archer1Maquina",3,6,this, false,false, Color.YELLOW);
        Archer archer2 = new Archer("archer2Maquina",0,14,this, false,false,Color.YELLOW);
        Archer archer4 = new Archer("archer3Maquina",1,2,this, false,false,Color.YELLOW);
        Archer archer3 = new Archer("Archer1Player",12,8,this, true,false,Color.ORANGE);
        Archer archer5 = new Archer("Archer2Player",13,14,this, true,false,Color.ORANGE);
        Archer archer6 = new Archer("Arche3Player",12,1,this, true,false,Color.ORANGE);
        Base baseIA = new Base("BaseMAquina",0,7,this, false,false,Color.ORANGE);
        Base baseUser = new Base("BasePlayer",14,7,this, true,false,Color.ORANGE);
        Giant giant1 = new Giant("GigantePlayer1",12,2,this,true,false,Color.BLUE);
        Giant giant2 = new Giant("GiganteMaquina1",4,3,this,false,false,Color.CYAN);
        Giant giant3 = new Giant("GigantePlayer2",12,11,this,true,false,Color.BLUE);
        Giant giant4 = new Giant("GiganteMaquina2",4,13,this,false,false,Color.CYAN);
        Canon canon1 = new Canon("CanonPlayer",11,6,this,true,false,Color.ORANGE);
        Canon canon2 = new Canon("CanonMaquina",3,5,this,false,false,Color.ORANGE);

        // thread para contar el dinero de la IA
        moneyCounterIA = new MoneyCounter(false, this);
        new Thread(moneyCounterIA).start();

        /*ia = new IA(this);
        new Thread(ia).start();*/



        new Thread(giant1).start();
        new Thread(giant2).start();
        new Thread(giant3).start();
        new Thread(giant4).start();
        new Thread(archer).start();
        new Thread(archer2).start();
        new Thread(archer3).start();
        new Thread(archer4).start();
        new Thread(archer5).start();
        new Thread(archer6).start();
        new Thread(baseUser).start();
        new Thread(baseIA).start();
        new Thread(canon1).start();
        new Thread(canon2).start();

        board.setTroopBoard(archer2);
        board.setTroopBoard(archer3);
        board.setTroopBoard(archer4);
        board.setTroopBoard(archer5);
        board.setTroopBoard(archer6);
        board.setTroopBoard(baseIA);
        board.setTroopBoard(baseUser);
        board.setTroopBoard(archer);
        board.setTroopBoard(giant1);
        board.setTroopBoard(giant2);
        board.setTroopBoard(giant3);
        board.setTroopBoard(giant4);
        board.setTroopBoard(canon1);
        board.setTroopBoard(canon2);
        gameController.addTroop(board);


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
        gameController.addTroop(board);
    }

    public void updateMoney() {
        gameController.updateMoney();
    }


    public void addTroop(Ids id, int x, int y) {
        switch (id) {
            case ARCHER -> linkedList.add(new Archer("archer100Maquina",x,y,this, false,false, Color.YELLOW));
            case CANNON -> linkedList.add(new Canon("CanonPlayer",x,y,this,false,false,Color.ORANGE));
            case GIANT -> linkedList.add(new Giant("GigantePlayer1",x,y,this,false,false,Color.BLUE));
            /*case TESLA -> linkedList.add(new TeslaTower("tesla100Maquina",x,y,this, false,false, Color.YELLOW));*/
        }

        board.setTroopBoard(linkedList.get(linkedList.size()-1));
        new Thread(linkedList.get(linkedList.size()-1)).start();

    }
}
