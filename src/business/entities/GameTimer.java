package business.entities;

import business.GameManager;
import business.RecordedGameManager;

public class GameTimer implements Runnable{

    private final long sleepTime;
    private int time;
    private boolean stop;
    private GameManager gameManager;
    private RecordedGameManager recordedGameManager;
    private boolean repro;


    public GameTimer(int time, boolean stop, GameManager gameManager) {
        this.sleepTime = 1000;
        this.time = time;
        this.stop = stop;
        this.gameManager = gameManager;
        this.repro = false;

    }
    public GameTimer(int time, boolean stop, RecordedGameManager recordedGameManager) {
        this.sleepTime = 1000;
        this.time = time;
        this.stop = stop;
        this.recordedGameManager = recordedGameManager;
        this.repro = true;
    }


    @Override
    public void run() {

        time = 0;
        while (!stop ) {
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time++;

            if(repro){
                recordedGameManager.setTime(time);
                recordedGameManager.reproGame();
            }else{
                gameManager.setTime(time);
            }

            System.out.println("Time: " + time);

            if(repro)recordedGameManager.updateViewMap();
            if(!repro) gameManager.updateViewMap(false);


        }


    }

    public void stop() {
        stop = true;
    }


}
