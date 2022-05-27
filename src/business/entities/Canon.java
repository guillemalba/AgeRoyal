package business.entities;

import business.GameManager;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Herencia de la clase Defensiva donde sobreescribimos los metodos y los implementamos con su constructor.
 */
public class Canon extends Defensive {

    /**
     * Constructor para añadir un nuevo cañon
     *
     * @param name del cannon
     * @param posx en el mapa
     * @param posy en el mapa
     * @param gameManager // todo esto pa que?
     * @param isUser para saber si es de la IA o del usuario
     * @param stop para detener el thread
     * @param image para cargar en el mapa
     */
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
    public void run() {
        super.run();
    }
}
