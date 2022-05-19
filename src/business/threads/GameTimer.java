package business.threads;

import business.GameManager;

public class GameTimer implements Runnable{

    // The time in milliseconds to make the Thread wait.
    private final long sleepTime;
    // The number of times we want the Thread to print values.
    private int time;
    // bolean to stop the timer
    private boolean stop;
    private GameManager gameManager;

    public GameTimer(long sleepTime, int time, boolean stop, GameManager gameManager) {
        this.sleepTime = sleepTime;
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

            System.out.println("Time: " + time);
            gameManager.UpdateViewMap();

        }
        /*System.out.println("*** CountWorker FINISHED ***");*/

    }

    public void stop() {
        stop = true;
    }
}
