package business.entities;

import business.GameManager;

import java.awt.*;

public class Canon extends Defensive {

    public Canon(String name,int posx, int posy, GameManager gameManager, boolean isUser,boolean stop,Color color) {
        super(name,posx,posy,gameManager, isUser,stop,color);
        this.setRange(3);//cuadrados a la redonda
        this.setLife(30);
        this.setCost(3);
        this.setDamage(4);
        this.setAttackVelocity(3000);
        this.setType("Structure");
        this.setTimeLife(20);//seg
        this.setColor(Color.BLACK);

    }

    @Override
    public synchronized void run() {


        while (getLife() > 0) {
            try {

                Thread.sleep(getAttackVelocity());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (enemyNear() != null && enemyNear().getLife() >= 0.0) {
                atack(enemyNear());
            }

        }
        dieTroop(this);
        //stopGame();

    }

}
