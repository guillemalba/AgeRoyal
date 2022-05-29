package business.entities;

import business.GameManager;
import business.UserManager;
import business.entities.IA;
import business.entities.User;

public class MoneyCounter implements Runnable {

    private GameManager gameManager;
    private boolean stop;

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

    public void stop(){
        stop = true;
    }
}
