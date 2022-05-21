package business.entities;

import business.GameManager;

public class Canon extends Defensive {

    public Canon(String name,int posx, int posy, GameManager gameManager, boolean isUser,boolean stop) {
        super(name,posx,posy,gameManager, isUser,stop);
        this.setRange(2);//cuadrados a la redonda
        this.setName("Canon");
        this.setLife(30);
        this.setCost(3);
        this.setDamage(4);
        this.setAttackVelocity(2000);
        this.setType("Structure");
        this.setTimeLife(20);//seg

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
        stopGame();

    }

}
