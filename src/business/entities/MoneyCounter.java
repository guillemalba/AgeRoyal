package business.entities;

import business.GameManager;
import business.UserManager;
import business.entities.IA;
import business.entities.User;

/**
 * Clase que va sumando el dinero del jugador y la IA
 */
public class MoneyCounter implements Runnable {

    private GameManager gameManager;
    private boolean stop;

    /**
     * Constructor del contador con el manager del juego
     *
     * @param gameManager de la partida
     */
    public MoneyCounter(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @Override
    public void run() {
        while(!stop) {
            try {
                Thread.sleep(2000);
                /*gameManager.updateMoney();*/
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            gameManager.sumMoney();
        }
    }

    /**
     * Metodo para detener el contador
     */
    public void stop(){
        stop = true;
    }
}
