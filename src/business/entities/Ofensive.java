package business.entities;

import business.GameManager;


import java.awt.image.BufferedImage;

public class Ofensive extends Troop {
    private int movementVelocity;


    public Ofensive(String name, int posx, int posy, GameManager gameManager, boolean isUser, boolean stop, BufferedImage image) {
        super(name,posx,posy,gameManager, isUser, stop, image);
    }

    public int getMovementVelocity() {
        return movementVelocity;
    }

    public void setMovementVelocity(int movementVelocity) {
        this.movementVelocity = movementVelocity;
    }


    @Override
    public void run() {

        while (!isStop()) {

            try {
                Thread.sleep(movementVelocity);
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
    public void move(String direction) {
        super.move(direction);
    }

    @Override
    public String canMove() {
        return super.canMove();
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
