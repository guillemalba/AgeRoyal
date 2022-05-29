package business;

import business.entities.*;
import persistence.GameDAO;
import persistence.GameSQLDAO;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.LinkedList;

// TODO mario comenta la clase perro
public class RecordedGameManager {

    private GameDAO gameDAO;
    private LinkedList<TroopDeployed> listDeployedTroops = new LinkedList<>();
    private GameManager gameManager;
    private boolean isRepro = true;
    private GameTimer gameTimer;
    private int time = 0;




    public RecordedGameManager(GameDAO gameDAO,GameManager gameManager) {
        this.gameManager = gameManager;
        this.gameDAO = gameDAO;
    }

    public void reviewGame(String game) {
        if(listDeployedTroops != null) listDeployedTroops.removeAll(listDeployedTroops);
        listDeployedTroops = gameDAO.readAllTroopDeployed(game);

    }


    public void initReproduction() {
        gameManager.initReproGame();
        gameManager.setRepro(true);
        gameTimer = new GameTimer(time, false, this);
        new Thread(gameTimer).start();
        reproGame();

    }


    public boolean isRepro() {
        return isRepro;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void reproGame() {
        for (int i = 0; i < listDeployedTroops.size(); i++) {
            if (time == listDeployedTroops.get(i).getTimeDeployed()) {

                gameManager.addRecordedTroop(listDeployedTroops.get(i).getTroopId(), listDeployedTroops.get(i).getPosX(), listDeployedTroops.get(i).getPosY(), listDeployedTroops.get(i).isUser());
                listDeployedTroops.remove(i);

            }
        }
    }

    public void updateViewMap(){
        gameManager.updateViewMap(true);
        if(gameManager.isStopRepro()) gameTimer.stop();
    }
}


