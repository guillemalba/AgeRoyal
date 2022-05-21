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

        Archer archer = new Archer("archer1Maquina",3,6,this, false,false);
        Archer archer2 = new Archer("archer2Maquina",0,14,this, false,false);
        Archer archer4 = new Archer("archer3Maquina",1,2,this, false,false);
        Archer archer3 = new Archer("Archer1Player",12,8,this, true,false);
        Archer archer5 = new Archer("Archer2Player",13,14,this, true,false);
        Base baseIA = new Base("BaseMAquina",0,7,this, false,false);
        Base baseUser = new Base("BasePlayer",14,7,this, true,false);
        Giant giant = new Giant("GigantePlayer",12,2,this,true,false);


        // thread para contar el dinero de la IA
        moneyCounterIA = new MoneyCounter(false, this);
        new Thread(moneyCounterIA).start();

        new Thread(giant).start();
        new Thread(archer2).start();
        new Thread(archer3).start();
        new Thread(archer4).start();
        new Thread(archer5).start();
        new Thread(baseUser).start();
        new Thread(baseIA).start();
        new Thread(archer).start();

        board.setTroopBoard(archer2);
        board.setTroopBoard(archer3);
        board.setTroopBoard(archer4);
        board.setTroopBoard(archer5);
        board.setTroopBoard(baseIA);
        board.setTroopBoard(baseUser);
        board.setTroopBoard(archer);
        board.setTroopBoard(giant);
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


}
