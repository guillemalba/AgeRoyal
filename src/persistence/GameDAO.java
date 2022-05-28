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

    /**
     * Metodo para guardar un Juego en la base de datos
     *
     * @param game el juego a guardar
     * @return true si se ha podido guardar
     */
    boolean saveGame(Game game);

    /**
     * Metodo que guarda todas las tropas desplegadas con el nombre de la partida
     *
     * @param troopDeployed tropa desplegada
     * @param gameName nombre de la partida
     * @return true si se ha podido guardar
     */
    boolean saveTroopsDeployed(TroopDeployed troopDeployed, String gameName);

    LinkedList<TroopDeployed> readAllTroopDeployed(String game);
}
