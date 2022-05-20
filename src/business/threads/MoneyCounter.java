package business.threads;

import business.GameManager;
import business.UserManager;

public class MoneyCounter implements Runnable {

    private boolean stop;
    private GameManager gameManager;

    public MoneyCounter(boolean stop, GameManager gameManager) {
        this.stop = stop;
        this.gameManager = gameManager;
    }

    @Override
    public void run() {
        try {
            while(!stop) {
                Thread.sleep(2000);
                gameManager.updateMoney();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stop(){
        stop = true;
    }
}
