package business.entities;

import business.GameManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Canon extends Defensive {

    public Canon(String name, int posx, int posy, GameManager gameManager, boolean isUser, boolean stop, BufferedImage image) {
        super(name, posx, posy, gameManager, isUser, stop, image);
        this.setCost(Attributes.CANNON_COST.getValue());
        this.setLife(Attributes.CANNON_LIFE.getValue());
        this.setDamage(Attributes.CANNON_DAMAGE.getValue());
        this.setRange(Attributes.CANNON_ATTACK_RANGE.getValue());//cuadrados a la redonda
        this.setAttackVelocity(Attributes.CANNON_ATTACK_VELOCITY.getValue());
        this.setTimeLife(Attributes.CANNON_TIME_LIFE.getValue());//seg
        this.setType("Structure");


    }

    @Override
    public synchronized void run() {
        super.run();
    }
}
