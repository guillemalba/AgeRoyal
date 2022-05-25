package business.entities;

import business.GameManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Defensive extends Troop {
    private int timeLife;


    public Defensive(String name, int posx, int posy, GameManager gamemanager, boolean isUser, boolean stop, Color color, BufferedImage image) {
        super(name,posx,posy,gamemanager, isUser, stop, color, image);
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
