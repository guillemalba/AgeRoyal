package business.entities;

import business.GameManager;

import java.awt.image.BufferedImage;

public class Giant extends Ofensive{

    public Giant(String name, int posx, int posy, GameManager gameManager, boolean isUser, boolean stop, BufferedImage image) {
        super(name,posx, posy,gameManager, isUser, stop, image);
        this.setCost(Attributes.GIANT_COST.getValue());
        this.setLife(Attributes.GIANT_LIFE.getValue());
        this.setDamage(Attributes.GIANT_DAMAGE.getValue());
        this.setRange(Attributes.GIANT_ATTACK_RANGE.getValue());//cuadrados a la redonda posible 5
        this.setAttackVelocity(Attributes.GIANT_ATTACK_VELOCITY.getValue());
        this.setMovementVelocity(Attributes.GIANT_MOVEMENT_VELOCITY.getValue());
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

