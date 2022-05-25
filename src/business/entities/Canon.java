package business.entities;

import business.GameManager;

import java.awt.*;

public class Canon extends Defensive {

    public Canon(String name,int posx, int posy, GameManager gameManager, boolean isUser,boolean stop,Color color) {
        super(name,posx,posy,gameManager, isUser,stop,color);
        this.setCost(Attributes.CANNON_COST.getValue());
        this.setLife(Attributes.CANNON_LIFE.getValue());
        this.setDamage(Attributes.CANNON_DAMAGE.getValue());
        this.setRange(Attributes.CANNON_ATTACK_RANGE.getValue());//cuadrados a la redonda
        this.setAttackVelocity(Attributes.CANNON_ATTACK_VELOCITY.getValue());
        this.setTimeLife(Attributes.CANNON_TIME_LIFE.getValue());//seg
        this.setType("Structure");
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
