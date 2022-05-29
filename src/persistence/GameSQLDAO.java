package persistence;
import business.entities.Game;
import business.entities.TroopDeployed;
import persistence.json.ConfigData;
import persistence.json.JsonReader;

import java.sql.*;
import java.util.LinkedList;

/**
 * Clase que implementa los metodos en SQL de la interficie GameDAO
 */
public class GameSQLDAO implements GameDAO{
    private ConfigData data;

    /**
     * Constructor que lee el fichero de configuracion para acceder a la base de datos
     */
    public GameSQLDAO() {
        data = JsonReader.llegeixJson();
    }

    @Override
    public LinkedList<Game> readUserGames(String username) {
        try {
            Connection connection = DriverManager.getConnection(data.getUrl(), data.getUser(), data.getPassword());
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from game where game.player = '" + username + "' order by data desc");

            LinkedList<Game> games = new LinkedList<>();
            while ((resultSet.next())) {
                Game game = new Game(
                        resultSet.getString("name"),
                        resultSet.getString("data"),
                        resultSet.getBoolean("win"),
                        resultSet.getString("player")
                );
                games.add(game);
            }
            return games;
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean saveGame(Game game) {
        try {
            Connection connection = DriverManager.getConnection(data.getUrl(), data.getUser(), data.getPassword());
            Statement statement = connection.createStatement();
            statement.execute("insert into game values('" + game.getName() + "','" + game.getDate() + "','" + game.getWin() + "','" + game.getPlayer() + "')");
            return true;
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean saveTroopsDeployed(TroopDeployed troopDeployed, String gameName) {
        try {
            Connection connection = DriverManager.getConnection(data.getUrl(), data.getUser(), data.getPassword());
            Statement statement = connection.createStatement();
            statement.execute("insert into TroopDeployed(time_deployed, posX, posY, troop, isUser, game) values('" + troopDeployed.getTimeDeployed() + "','" + troopDeployed.getPosX() + "','" + troopDeployed.getPosY() + "','" + troopDeployed.getTroopId() + "','" + troopDeployed.isUser() + "','" + gameName + "')");
            return true;
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public LinkedList<TroopDeployed> readAllTroopDeployed(String game2){
        try {
            Connection connection = DriverManager.getConnection(data.getUrl(), data.getUser(), data.getPassword());
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select troop,time_deployed,posX,posY,isuser from troopdeployed where game = '" + game2 + "' order by time_deployed asc");

            LinkedList<TroopDeployed> troopDeployeds = new LinkedList<>();
            while ((resultSet.next())) {
                TroopDeployed troopDeployed = new TroopDeployed(
                        resultSet.getInt("troop"),
                        resultSet.getInt("time_deployed"),
                        resultSet.getInt("posX"),
                        resultSet.getInt("posY"),
                        resultSet.getBoolean("isuser")
                );
                troopDeployeds.add(troopDeployed);
            }
            return troopDeployeds;
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean deleteUserGames(String username) {
        try {
            Connection connection = DriverManager.getConnection(data.getUrl(), data.getUser(), data.getPassword());
            Statement statement = connection.createStatement();
            statement.execute("delete from troopdeployed where troopdeployed.game in (select game.name from game)");
            statement.execute("delete from game where game.player = '" + username + "'");
            return true;
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean gameNameIsUnique(String gameName) {
        try {
            Connection connection = DriverManager.getConnection(data.getUrl(), data.getUser(), data.getPassword());
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select name from game where name = '" + gameName +"'");
            if (!resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
        return false;
    }
}
