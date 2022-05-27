package business.threads;

import business.GameManager;

public class GameTimer implements Runnable{

    private final long sleepTime;
    private int time;
    private boolean stop;
    private GameManager gameManager;

    public GameTimer(int time, boolean stop, GameManager gameManager) {
        this.sleepTime = 1000;
        this.time = time;
        this.stop = stop;
        this.gameManager = gameManager;
    }

    @Override
    public void run() {

        time = 0;
        while (!stop) {
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time++;
            gameManager.setTime(time);
            System.out.println("Time: " + time);
            gameManager.updateViewMap();

        }
        /*System.out.println("*** CountWorker FINISHED ***");*/

    }

    public void stop() {
        stop = true;
    }


}
