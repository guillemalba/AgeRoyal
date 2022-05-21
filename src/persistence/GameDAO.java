package persistence;

import business.entities.Game;

import java.util.LinkedList;

public interface GameDAO {
    /**
     * Gets a list with all the Games
     *
     * @return a list of Games
     */
    LinkedList<Game> readAllGames();
}
