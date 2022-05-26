package business.entities;

import business.GameManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Defensive extends Troop {
    private int timeLife;


    public Defensive(String name, int posx, int posy, GameManager gamemanager, boolean isUser, boolean stop, BufferedImage image) {
        super(name,posx,posy,gamemanager, isUser, stop, image);
        this.timeLife = timeLife;
    }



    public int getTimeLife() {
        return timeLife;
    }

    public void setTimeLife(int timeLife) {
        this.timeLife = timeLife;
    }

    /*@Override
    public synchronized void run() {
        while (true) {
            try {
                Thread.sleep(((Archer)troop).getMovementVelocity());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //drawMap();
            moveTroop();
        }
    }*/
}
