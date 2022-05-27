package business.entities;

import business.GameManager;


import java.awt.image.BufferedImage;


public class Archer extends Ofensive {


    public Archer(String name, int posx, int posy, GameManager gameManager, boolean isUser, boolean stop, BufferedImage image) {
        super(name,posx, posy, gameManager, isUser, stop, image);
        this.setCost(Attributes.ARCHER_COST.getValue());
        this.setLife(Attributes.ARCHER_LIFE.getValue());
        this.setDamage(Attributes.ARCHER_DAMAGE.getValue());
        this.setRange(Attributes.ARCHER_ATTACK_RANGE.getValue());
        this.setAttackVelocity(Attributes.ARCHER_ATTACK_VELOCITY.getValue());
        this.setMovementVelocity(Attributes.ARCHER_MOVEMENT_VELOCITY.getValue());

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
        super.run();
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
