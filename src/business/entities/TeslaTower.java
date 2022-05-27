package business.entities;

import business.GameManager;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Herencia de la clase Defensiva donde sobreescribimos los metodos y los implementamos con su constructor.
 */
public class TeslaTower extends Defensive{

    /**
     * Constructor para añadir un nuevo Tesla
     *
     * @param name
     * @param posx
     * @param posy
     * @param gameManager
     * @param isUser
     * @param stop
     * @param image
     */
    public TeslaTower(String name, int posx, int posy, GameManager gameManager, boolean isUser, boolean stop, BufferedImage image) {
        super(name,posx, posy, gameManager, isUser, stop, image);
        this.setName("TeslaTower");
        this.setCost(Attributes.TESLA_COST.getValue());
        this.setLife(Attributes.TESLA_LIFE.getValue());
        this.setDamage(Attributes.TESLA_DAMAGE.getValue());
        this.setRange(Attributes.TESLA_ATTACK_RANGE.getValue());
        this.setAttackVelocity(Attributes.TESLA_ATTACK_VELOCITY.getValue());
        this.setTimeLife(Attributes.TESLA_TIME_LIFE.getValue());
        this.setType("Structure");

    }

    @Override
    public  void run() {
        super.run();
    }


}
