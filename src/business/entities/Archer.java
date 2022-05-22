package business.entities;

import business.GameManager;

import java.awt.*;


public class Archer extends Ofensive {


    public Archer(String name,int posx, int posy, GameManager gameManager, boolean isUser,boolean stop,Color color) {
        super(name,posx, posy, gameManager, isUser,stop,color);
        this.setRange(3);//cuadrados a la redonda posible 5
        this.setLife(12);
        this.setCost(2);
        this.setDamage(4);//quiza 2
        this.setAttackVelocity(2000);
        this.setMovementVelocity(3000);
        this.setPrefObjective("all");


    }


    @Override
    public int getMovementVelocity() {
        return super.getMovementVelocity();
    }

    @Override
    public void move(String direction) {
        super.move(direction);
    }

    @Override
    public String canMove() {
        return super.canMove();
    }

    @Override
    public void run() {

        while(!isStop()) {

            try {
                Thread.sleep(getMovementVelocity());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (enemyNear() != null && enemyNear().getLife() >= 0.0) {

                atack(enemyNear());

            } else {
                String move = canMove();
                if (!move.equals("false")) move(move);
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
