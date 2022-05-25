package business.threads;

import business.GameManager;
import business.UserManager;
import business.entities.IA;

public class MoneyCounter implements Runnable {

    private GameManager gameManager;
    private IA ia;
    private int money;
    private boolean stop;

    public MoneyCounter(GameManager gameManager, IA ia) {
        this.gameManager = gameManager;
        this.ia = ia;
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
            money++;
            ia.setMoney(ia.getMoney() + 1);
        }
    }

    public void stop(){
        stop = true;
    }
}
