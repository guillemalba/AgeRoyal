package business;

import business.entities.*;
import persistence.GameDAO;
import java.util.LinkedList;

/**
 * Clase que gestiona toda la parte de reproducir la partida.
 */
public class RecordedGameManager {

    private GameDAO gameDAO;
    private LinkedList<TroopDeployed> listDeployedTroops = new LinkedList<>();
    private GameManager gameManager;
    private GameTimer gameTimer;
    private int time = 0;

    /**
     * Constructor del manager donde le pasamos el gameManager y la base de datos de juegos
     *
     * @param gameManager el manager que gestiona la partida
     * @param gameDAO la base de datos donde tenemos la informacion
     */
    public RecordedGameManager(GameDAO gameDAO,GameManager gameManager) {
        this.gameManager = gameManager;
        this.gameDAO = gameDAO;
    }

    /**
     * Esta clase nos permite descargar todas las tropas tiradas de la partida que queremos reproducir
     *
     * @param game nombre de la partida que quieres reproducir
     */
    public void reviewGame(String game) {
        if(listDeployedTroops != null) listDeployedTroops.removeAll(listDeployedTroops);
        listDeployedTroops = gameDAO.readAllTroopDeployed(game);

    }

    /**
     * Aqui es el metodo que inicia la partida, que hace los primeros pasos para reproducir la partida
     */

    public void initReproduction() {
        gameManager.initReproGame();
        gameManager.setRepro(true);
        gameTimer = new GameTimer(time, false, this);
        new Thread(gameTimer).start();

        reproGame();

    }


    /**
     * setter del tiempo de la partida
     *
     * @param time tiempo de la partida
     */
    public void setTime(int time) {
        this.time = time;
    }


    /**
     * funcion que recorre la lista de tropas tiradas y cuando coincide el tiempo con el tiempo actual de la partida
     * llama a la funcion de tirar las tropas con la informacion necesaria.
     */
    public void reproGame() {
        for (int i = 0; i < listDeployedTroops.size(); i++) {
            if (time == listDeployedTroops.get(i).getTimeDeployed()) {

                gameManager.addRecordedTroop(listDeployedTroops.get(i).getTroopId(), listDeployedTroops.get(i).getPosX(), listDeployedTroops.get(i).getPosY(), listDeployedTroops.get(i).isUser());
                listDeployedTroops.remove(i);

            }
        }
    }

    /**
     * Funcion que llama al controller para actualizar el mapa
     */
    public void updateViewMap(){
        gameManager.updateViewMap(true);
        if(gameManager.isPauseRepro())  gameTimer.setPause(false);

        if(gameManager.isStopRepro()) gameTimer.stop();
    }

    /**
     * Funcion que comprueba si el manager quiere volver a reprodicir la partida en pausa
     */
    public void tryResume(){
        if(!gameManager.isPauseRepro()) {

            gameTimer.setPause(true);
        }

    }
}


