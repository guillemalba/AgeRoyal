package business.threads;

public class GameTimer implements Runnable{

    // The time in milliseconds to make the Thread wait.
    private final long sleepTime;
    // The number of times we want the Thread to print values.
    private int time;

    public GameTimer(long sleepTime, int time) {
        this.sleepTime = sleepTime;
        this.time = time;
    }

    @Override
    public void run() {

        time = 0;
        while (true) {
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time++;
            System.out.println("Time: " + time);
        }
        /*System.out.println("*** CountWorker FINISHED ***");*/

    }
}
