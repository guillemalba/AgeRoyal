package business.entities;

import business.GameManager;

import java.awt.*;
import java.awt.image.BufferedImage;

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
     * @param gameManager // todo por que manager?
     * @param isUser para saber si es la Base de la IA o del usuario
     * @param stop para parar el thread
     * @param image de la base para cargar en el mapa
     */
    public Base(String name, int posx, int posy, GameManager gameManager, boolean isUser, boolean stop, BufferedImage image) {
        super(name, posx, posy, gameManager, isUser, stop, image);
        this.setRange(4);//cuadrados a la redonda posible 5
        this.setLife(50);
        this.setCost(0);
        this.setDamage(4);
        this.setAttackVelocity(10000);
        this.setType("Structure");
        this.setTimeLife(10000);//seg
        this.setColor(Color.BLUE);
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
        dieTroop(this);
        stopGame(isUser());

    }

}
