package business.entities;

import business.GameManager;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Herencia de la clase Tropa donde sobreescribimos los metodos y los implementamos con su constructor.
 */
public class Defensive extends Troop {
    private int timeLife;

    /**
     * Constructor para crear una nueva tropa defensiva, que a diferencia de las ofensivas, estas no tienen movimiento pero tienen tiempo de vida
     *
     * @param name de la tropa
     * @param posx del mapa
     * @param posy del mapa
     * @param gamemanager para acceder a los metodos
     * @param isUser para saber si es de la IA o del usuario
     * @param stop para detener el thread
     * @param image a cargar en el mapa
     */
    public Defensive(String name, int posx, int posy, GameManager gamemanager, boolean isUser, boolean stop, BufferedImage image) {
        super(name,posx,posy,gamemanager, isUser, stop, image);

    }


    /**
     * Getter del tiempo de vida de la tropa defensiva
     *
     * @return el tiempo de vida
     */
    public int getTimeLife() {
        return timeLife;
    }

    /**
     * Setter del tiempo de la vida
     *
     * @param timeLife de la tropa
     */
    public void setTimeLife(int timeLife) {
        this.timeLife = timeLife;
    }

    @Override
    public synchronized void run() {

        while (!isStop() && getTimeLife()>0) {
            try {
                Thread.sleep(getAttackVelocity());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (enemyNear() != null && enemyNear().getLife() >= 0.0) {
                atack(enemyNear());
            }
            setTimeLife(getTimeLife()-(int)(getAttackVelocity()/1000));
        }

        if(getTimeLife()<=0){
            System.out.println(isUser());
            removeTroop(!isUser());
        }
        dieTroop(this);
    }

}
