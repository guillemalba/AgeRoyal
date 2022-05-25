package business.threads;

import business.GameManager;
import business.UserManager;
import business.entities.IA;
import business.entities.User;

public class MoneyCounter implements Runnable {

    private GameManager gameManager;
    private IA ia;
    private int money;
    private boolean stop;
    private User user;

    public MoneyCounter(GameManager gameManager, IA ia,User user) {
        this.gameManager = gameManager;
        this.ia = ia;
        this.user = user;
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
            user.setMoney(user.getMoney()+1);
            ia.setMoney(ia.getMoney() + 1);
        }
    }

    public void stop(){
        stop = true;
    }
}
