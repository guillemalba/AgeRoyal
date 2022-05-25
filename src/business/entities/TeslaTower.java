package business.entities;

import business.GameManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TeslaTower extends Defensive{
    private boolean hide;


    public TeslaTower(String name, int posx, int posy, GameManager gameManager, boolean isUser, boolean stop, Color color, BufferedImage image) {
        super(name,posx, posy, gameManager, isUser, stop, color, image);
        this.hide = hide;
        this.setName("TeslaTower");
        this.setCost(Attributes.TESLA_COST.getValue());
        this.setLife(Attributes.TESLA_LIFE.getValue());
        this.setDamage(Attributes.TESLA_DAMAGE.getValue());
        this.setRange(Attributes.TESLA_ATTACK_RANGE.getValue());//cuadrados a la redonda
        this.setAttackVelocity(Attributes.TESLA_ATTACK_VELOCITY.getValue());
        this.setTimeLife(Attributes.TESLA_TIME_LIFE.getValue());//seg
        this.setType("Structure");

    }


    


    public boolean isHide() {
        return hide;
    }

    public void setHide(boolean hide) {
        this.hide = hide;
    }

}
