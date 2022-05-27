package business.entities;

import business.GameManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Defensive extends Troop {
    private int timeLife;


    public Defensive(String name, int posx, int posy, GameManager gamemanager, boolean isUser, boolean stop, BufferedImage image) {
        super(name,posx,posy,gamemanager, isUser, stop, image);

    }


    @Override
    public synchronized void run() {

        while (!isStop() && getTimeLife()>0) {
            try {

                Thread.sleep(getAttackVelocity());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (enemyNear() != null && enemyNear().getLife() >= 0.0) {
                atack(enemyNear());
            }

            setTimeLife(getTimeLife()-(int)(getAttackVelocity()/1000));


        }

        if(getTimeLife()<=0){
            System.out.println(isUser());
            removeTroop(!isUser());
        }
        dieTroop(this);


    }

    public int getTimeLife() {
        return timeLife;
    }

    public void setTimeLife(int timeLife) {
        this.timeLife = timeLife;
    }


}
