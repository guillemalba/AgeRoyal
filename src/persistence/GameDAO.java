package persistence;

import business.entities.Game;
import business.entities.TroopDeployed;

import java.util.LinkedList;

/**
 * Interficie con las funciones relacionadas con la partida
 */
public interface GameDAO {

    /**
     * Gets a list with all the Games
     *
     * @param username nombre del usuario
     * @return la lista
     */
    LinkedList<Game> readUserGames(String username);

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

    /**
     * Metodo que lee y guarda en una lista todas las tropas desplegadas en una partida
     *
     * @param game el nombre de la partida
     * @return la lista de partidas
     */
    LinkedList<TroopDeployed> readAllTroopDeployed(String game);

    /**
     * Elimina todas las partidas de un jugador
     *
     * @param username del jugador
     * @return true si se han eliminado correctamente, false si no
     */
    boolean deleteUserGames (String username);

    /**
     * Metodo que comprueba que el nombre de la partida sea unica
     *
     * @param gameName nombre de la partida
     */
    boolean gameNameIsUnique(String gameName);
}
