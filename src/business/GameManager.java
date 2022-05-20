package business;



import business.entities.Base;
import business.entities.Board;
import business.entities.Troop;
import business.threads.GameTimer;
import business.entities.*;
import business.threads.TroopMovement;
import business.threads.UpdateMap;
import presentation.controllers.GameViewController;
import presentation.views.GameView;

import java.awt.image.AffineTransformOp;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

public class GameManager{
    private Base base2;
    private String mapa[][];
    private Board board;
    private Troop base1;
    private int time;
    private LinkedList<Troop> troops= new LinkedList();

    private GameViewController gameController;

    public String[][] getMapa() {
        return mapa;
    }

    public GameManager() {

    }
    public void initGame(){
        board = new Board();
        GameTimer gameTimer = new GameTimer(1000, time, false, this);

        Archer archer = new Archer(2,2,this, false);
        Archer archer2 = new Archer(2,12,this, false);
        Archer archer3 = new Archer(10,7,this, true);
        Base baseIA = new Base(0,7,this, false);
        Base baseUser = new Base(14,7,this, true);

        new Thread(archer).start();
        new Thread(archer2).start();
        new Thread(archer3).start();
        new Thread(baseIA).start();
        new Thread(baseUser).start();
        board.setTroopBoard(archer);
        board.setTroopBoard(archer2);
        board.setTroopBoard(archer3);
        board.setTroopBoard(baseIA);
        board.setTroopBoard(baseUser);
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

    public synchronized void addTroop(){

    }



}
