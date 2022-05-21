package business.entities;

import business.GameManager;

import java.awt.*;


public class Archer extends Ofensive {


    public Archer(String name,int posx, int posy, GameManager gameManager, boolean isUser,boolean stop) {
        super(name,posx, posy, gameManager, isUser,stop);
        this.setRange(4);//cuadrados a la redonda posible 5
        this.setLife(12);
        this.setCost(2);
        this.setDamage(4);//quiza 2
        this.setAttackVelocity(2000);
        this.setMovementVelocity(3000);
        this.setPrefObjective("all");
        this.setColor(Color.RED);

    }


    @Override
    public int getMovementVelocity() {
        return super.getMovementVelocity();
    }

    @Override
    public void move() {
        super.move();
    }

    @Override
    public boolean canMove() {
        return super.canMove();
    }

    @Override
    public synchronized void run() {

        while(!isStop()) {
            try {
                Thread.sleep(getMovementVelocity());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (enemyNear() != null && enemyNear().getLife() >= 0.0) {

                atack(enemyNear());

            } else {

                if (canMove()) move();
                enemyNear();
            }


        }
        dieTroop(this);
    }

    @Override
    public Troop enemyNear() {
        return super.enemyNear();
    }

    @Override
    public void dieTroop(Troop troop) {
        super.dieTroop(troop);
    }
}
