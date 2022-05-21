package business.entities;

import business.GameManager;

import java.awt.*;


public class Archer extends Ofensive {

    public Archer(int posx,int posy, GameManager gameManager, boolean isUser) {
        super(posx,posy,gameManager, isUser);
        this.setRange(1);//cuadrados a la redonda posible 5
        this.setName("A");
        this.setLife(12);
        this.setCost(2);
        this.setDamage(3);//quiza 2
        this.setAttackVelocity(3000);
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
        while (true) {
            try {

                Thread.sleep(getMovementVelocity());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(canMove()) move();
            enemyNear();
            System.out.println(getPosx());

        }
    }

    @Override
    public boolean enemyNear() {
        return super.enemyNear();
    }
}
