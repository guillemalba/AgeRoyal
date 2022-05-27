package business;

import business.entities.Board;
import persistence.GameDAO;
import persistence.GameSQLDAO;

public class RecordedGameManager {

    private GameDAO gameDAO;
    private Board board;


    public RecordedGameManager(GameDAO gameDAO) {
        this.gameDAO = new GameSQLDAO();
    }

    public void initReproduction() {

    }
}
