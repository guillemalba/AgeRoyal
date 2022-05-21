package business.entities;

import business.GameManager;

public class Defensive extends Troop {
    private int timeLife;


    public Defensive(String name,int posx, int posy, GameManager gamemanager, boolean isUser,boolean stop) {
        super(name,posx,posy,gamemanager, isUser,stop);
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
