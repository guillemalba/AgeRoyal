package persistence;
import business.entities.Game;
import business.json.*;
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
            System.out.println(games.get(0).getName());
            return games;
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
        return null;
    }
}
