package business;



import business.entities.Base;
import business.entities.Board;
import business.entities.Troop;
import business.threads.GameTimer;
import business.entities.*;
import business.threads.MoneyCounter;
import presentation.controllers.GameViewController;

import java.util.LinkedList;

public class GameManager{
    private Base base2;
    private String mapa[][];
    private Board board;
    private Troop base1;
    private int time;
    private LinkedList<Troop> troops= new LinkedList();
    private MoneyCounter moneyCounterIA;

    private GameViewController gameController;

    public String[][] getMapa() {
        return mapa;
    }

    public GameManager() {

    }
    public void initGame(){
        board = new Board();
        GameTimer gameTimer = new GameTimer(1000, time, false, this);

        Archer archer = new Archer(7,0,this, false);
        //Archer archer2 = new Archer(2,12,this, false);
        Archer archer3 = new Archer(13,7,this, true);
        Base baseIA = new Base(0,7,this, false);
        Base baseUser = new Base(14,7,this, true);

        // thread para contar el dinero de la IA
        moneyCounterIA = new MoneyCounter(false, this);
        new Thread(moneyCounterIA).start();

        //new Thread(archer2).start();
        new Thread(archer3).start();
        new Thread(baseIA).start();
        new Thread(baseUser).start();
        new Thread(archer).start();
        //board.setTroopBoard(archer2);
        board.setTroopBoard(archer3);
        board.setTroopBoard(baseIA);
        board.setTroopBoard(baseUser);
        board.setTroopBoard(archer);
        gameController.addTroop(board);


        new Thread(gameTimer).start();

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
