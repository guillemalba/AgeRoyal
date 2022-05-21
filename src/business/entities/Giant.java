package business.entities;

import business.GameManager;

import java.awt.*;

public class Giant extends Ofensive{

    public Giant(String name, int posx, int posy, GameManager gameManager, boolean isUser,boolean stop) {
        super(name,posx, posy,gameManager, isUser,stop);
        this.setRange(1);//cuadrados a la redonda posible 5
        this.setLife(70);
        this.setCost(4);
        this.setDamage(5);
        this.setAttackVelocity(2000);
        this.setMovementVelocity(4000);
        this.setPrefObjective("Structure");
        this.setColor(Color.CYAN);
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

