package persistence;
import business.entities.Game;
import business.entities.TroopDeployed;
import persistence.json.ConfigData;
import persistence.json.JsonReader;

import java.sql.*;
import java.util.LinkedList;


public class GameSQLDAO implements GameDAO{
    private ConfigData data;

    public GameSQLDAO() {
        data = JsonReader.llegeixJson();
    }

    @Override
    public LinkedList<Game> readAllGames() {
        try {
            Connection connection = DriverManager.getConnection(data.getUrl(), data.getUser(), data.getPassword());
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from game");

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
}
