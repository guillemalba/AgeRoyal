package business.entities;

import business.GameManager;


import java.awt.image.BufferedImage;

/**
 * Clase ofensiva que hereda de tropa y añade el atributo de velocidad de movimiento
 */
public class Ofensive extends Troop {
    private int movementVelocity;

    /**
     * Constructor para crear una nueva tropa ofensiva
     *
     * @param name de la tropa
     * @param posx en el mapa
     * @param posy en el mapa
     * @param gameManager para acceder a los metodos
     * @param isUser para saber si es del usuario o de la IA
     * @param stop para detener el thread
     * @param image de la tropa a mostrar en el mapa
     */
    public Ofensive(String name, int posx, int posy, GameManager gameManager, boolean isUser, boolean stop, BufferedImage image) {
        super(name,posx,posy,gameManager, isUser, stop, image);
    }

    /**
     * Getter que devuelve la velocidad de movimiento de las tropas ofensivas
     *
     * @return velocidad de movimiento
     */
    public int getMovementVelocity() {
        return movementVelocity;
    }

    /**
     * Setter para asignar una velocidad de movimiento a la tropa
     *
     * @param movementVelocity de la tropa
     */
    public void setMovementVelocity(int movementVelocity) {
        this.movementVelocity = movementVelocity;
    }

    @Override
    public void run() {

        while (!isStop()) {

            try {
                Thread.sleep(movementVelocity);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (getPause()) {
                if (enemyNear() != null && enemyNear().getLife() >= 0.0) {

                    atack(enemyNear());

                } else {
                    String move = canMove();
                    if (!move.equals("false")) move(move);
                }

            }

        }
        dieTroop(this);
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
    public Troop enemyNear() {
        return super.enemyNear();
    }

    @Override
    public void dieTroop(Troop troop) {
        super.dieTroop(troop);
    }


}
