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

        Archer archer = new Archer(2,7,this);
        Base baseIA = new Base(0,7,this);
        Base baseUser = new Base(14,7,this);

        new Thread(archer).start();
        new Thread(baseIA).start();
        new Thread(baseUser).start();
        board.setTroopBoard(archer);
        board.setTroopBoard(baseIA);
        board.setTroopBoard(baseUser);
        gameController.addTroop(board);

        //new Thread(new Archer(13,10)).start();

        //UpdateMap updateMap = new UpdateMap(mapa);
        //new Thread(updateMap).start();

        new Thread(gameTimer).start();
        //new Thread(archer).start();
        //new Thread(archer2).start();
        System.out.println("Me cago en dios");
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
