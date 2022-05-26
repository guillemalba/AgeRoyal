package persistence;

import business.entities.Game;
import business.entities.TroopDeployed;

import java.util.LinkedList;

public interface GameDAO {
    /**
     * Gets a list with all the Games
     *
     * @return a list of Games
     */
    LinkedList<Game> readAllGames();

    boolean saveGame(Game game);

    boolean saveTroopsDeployed(TroopDeployed troopDeployed, String gameName);
}
