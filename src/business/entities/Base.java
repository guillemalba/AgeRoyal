package business.entities;

import business.GameManager;

import java.awt.*;
import java.awt.image.BufferedImage;
import business.RecordedGameManager;

/**
 * Herencia de la clase Defensiva donde sobreescribimos los metodos y los implementamos con su constructor.
 */
public class Base extends Defensive{

    /**
     * Constructor para crear una nueva Base
     *
     * @param name de la base
     * @param posx del mapa
     * @param posy del mapa
     * @param gameManager para acceder a los metodos
     * @param isUser para saber si es la Base de la IA o del usuario
     * @param stop para parar el thread
     * @param image de la base para cargar en el mapa
     */
    public Base(String name, int posx, int posy, GameManager gameManager, boolean isUser, boolean stop, BufferedImage image) {
        super(name, posx, posy, gameManager, isUser, stop, image);
        this.setRange(Attributes.BASE_ATTACK_RANGE.getValue());
        this.setLife(Attributes.BASE_LIFE.getValue());
        this.setCost(Attributes.BASE_COST.getValue());
        this.setDamage(Attributes.BASE_DAMAGE.getValue());
        this.setAttackVelocity(Attributes.BASE_ATTACK_VELOCITY.getValue());
        this.setTimeLife(Attributes.BASE_TIME_LIFE.getValue());//seg
        this.setType("Structure");
    }

    @Override
    public synchronized void run() {

        while (getLife() > 0 && !isStop()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (enemyNear() != null && enemyNear().getLife() >= 0.0) {
                atack(enemyNear());
            }
        }
        if (getLife() <= 0) {
            System.out.println("Paro el juego");
            stopGame(!isUser(), true);
        } else {
            System.out.println("Paro el juego");
            stopGame(!isUser(), false);
        }
        dieTroop(this);
    }
}
