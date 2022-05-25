package business.entities;

import business.GameManager;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Archer extends Ofensive {


    public Archer(String name, int posx, int posy, GameManager gameManager, boolean isUser, boolean stop, Color color, BufferedImage image) {
        super(name,posx, posy, gameManager, isUser, stop, color, image);
        this.setCost(Attributes.ARCHER_COST.getValue());
        this.setLife(Attributes.ARCHER_LIFE.getValue());
        this.setDamage(Attributes.ARCHER_DAMAGE.getValue());//quiza 2
        this.setRange(Attributes.ARCHER_ATTACK_RANGE.getValue());//cuadrados a la redonda posible 5
        this.setAttackVelocity(Attributes.ARCHER_ATTACK_VELOCITY.getValue());
        this.setMovementVelocity(Attributes.ARCHER_MOVEMENT_VELOCITY.getValue());
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
