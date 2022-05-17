package business;



import business.entities.Base;
import business.entities.Board;
import business.entities.Troop;
import business.threads.GameTimer;
import business.entities.*;
import business.threads.TroopMovement;
import business.threads.UpdateMap;

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

    public String[][] getMapa() {
        return mapa;
    }

    public GameManager() {

        board = new Board();
        GameTimer gameTimer = new GameTimer(1000, time, false);
        Archer archer = new Archer(2,10);
        Base baseIA = new Base(0,10);
        Base baseUser = new Base(14,10);

        //new Thread(archer).start();
        //new Thread(baseIA).start();
       // new Thread(baseUser).start();
        board.setTroopBoard(archer);
        board.setTroopBoard(baseIA);
        board.setTroopBoard(baseUser);

        //new Thread(new Archer(13,10)).start();

        //UpdateMap updateMap = new UpdateMap(mapa);
        //new Thread(updateMap).start();

        //new Thread(gameTimer).start();
        //new Thread(archer).start();
        //new Thread(archer2).start();
        System.out.println("Me cago en dios");
    }

    public Board getBoard() {
        return board;
    }

    public synchronized void addTroop(){


    }



}
