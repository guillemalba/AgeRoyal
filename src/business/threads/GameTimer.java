package business.threads;

public class GameTimer implements Runnable{

    // The time in milliseconds to make the Thread wait.
    private final long sleepTime;
    // The number of times we want the Thread to print values.
    private int time;
    // bolean to stop the timer
    private boolean stop;

    public GameTimer(long sleepTime, int time, boolean stop) {
        this.sleepTime = sleepTime;
        this.time = time;
        this.stop = stop;
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
        }
        /*System.out.println("*** CountWorker FINISHED ***");*/

    }

    public void stop() {
        stop = true;
    }
}
