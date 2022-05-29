package business.entities;

import business.GameManager;
import business.RecordedGameManager;

/**
 * Timer principal de la partida en curso, cada segundo suma 1
 */
public class GameTimer implements Runnable{

    private final long sleepTime;
    private int time;
    private boolean stop;
    private boolean pause;
    private GameManager gameManager;
    private RecordedGameManager recordedGameManager;
    private boolean repro;

    /**
     * Constructor para el timer del juego
     *
     * @param time tiempo
     * @param stop para detener el timer
     * @param gameManager manager del juego
     */
    public GameTimer(int time, boolean stop, GameManager gameManager) {
        this.sleepTime = 1000;
        this.time = time;
        this.stop = stop;
        this.gameManager = gameManager;
        this.repro = false;
        this.pause = true;

    }

    /**
     * Constructor del timer de la partida grabada
     *
     * @param time de la grabacion
     * @param stop para detener el timer
     * @param recordedGameManager manager de las partidas grabadas
     */
    public GameTimer(int time, boolean stop, RecordedGameManager recordedGameManager) {
        this.sleepTime = 1000;
        this.time = time;
        this.stop = stop;
        this.recordedGameManager = recordedGameManager;
        this.repro = true;
        this.pause = true;
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
            if (pause){
                time++;

                if (repro) {
                    recordedGameManager.setTime(time);
                    recordedGameManager.reproGame();
                    recordedGameManager.updateViewMap();
                } else {
                    gameManager.setTime(time);
                    gameManager.updateViewMap(false);
                }

                System.out.println("Time: " + time);


            }else{
                if(repro)recordedGameManager.tryResume();
            }
        }
    }

    /**
     * Setter para detener el timer
     */
    public void stop() {
        stop = true;
    }


    /**
     * Setter del Pause que nos pasa como queremos que este el pause
     *
     * @param pause de si queremos parar la partida
     */
    public void setPause(boolean pause) {
        this.pause = pause;
    }
}
