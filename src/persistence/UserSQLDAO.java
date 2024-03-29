package persistence;
import business.entities.User;
import persistence.json.ConfigData;
import persistence.json.JsonReader;

import java.sql.*;
import java.util.LinkedList;

/**
 * Clase que implementa los metodos en SQL de la interficie UserDAO
 */
public class UserSQLDAO implements UserDAO{
    private ConfigData data;

    /**
     * Constructor que lee el fichero de configuracion para acceder a la base de datos
     */
    public UserSQLDAO() {
        data = JsonReader.llegeixJson();
    }

    @Override
    public boolean createUser(User user) {
        try {
            Connection connection = DriverManager.getConnection(data.getUrl(), data.getUser(), data.getPassword());
            Statement statement = connection.createStatement();
            statement.execute("insert into player values('" + user.getName() + "','" + user.getEmail() + "','" + user.getPassword() + "',0,0,0)");
            return true;
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteUser(String username) {
        try {
            Connection connection = DriverManager.getConnection(data.getUrl(), data.getUser(), data.getPassword());
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from player");

            while ((resultSet.next())) {
                if(resultSet.getString("name").equals(username)){
                    statement.execute("delete from player where name ='" + username + "'");
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean checkLogin(User user) {
        try {
            Connection connection = DriverManager.getConnection(data.getUrl(), data.getUser(), data.getPassword());
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from player");

            while ((resultSet.next())) {
                if(resultSet.getString("name").equals(user.getName()) || resultSet.getString("mail").equals(user.getEmail())){
                    if(resultSet.getString("password").equals(user.getPassword())){
                        return true;
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public LinkedList<User> readAllUsers() {
        try {
            Connection connection = DriverManager.getConnection(data.getUrl(), data.getUser(), data.getPassword());
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from player");

            LinkedList<User> users = new LinkedList<>();
            while ((resultSet.next())) {
                User user = new User(
                        resultSet.getString("name"),
                        resultSet.getString("mail"),
                        resultSet.getString("password"),
                        resultSet.getInt("victorias"),
                        resultSet.getInt("totalGames"),
                        resultSet.getFloat("ratio")
                );
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public LinkedList<User> readAllOrderUsers() {
        try {
            Connection connection = DriverManager.getConnection(data.getUrl(), data.getUser(), data.getPassword());
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from player Order By ratio DESC");

            LinkedList<User> users = new LinkedList<>();
            while ((resultSet.next())) {
                User user = new User(
                        resultSet.getString("name"),
                        resultSet.getString("mail"),
                        resultSet.getString("password"),
                        resultSet.getInt("victorias"),
                        resultSet.getInt("totalGames"),
                        resultSet.getFloat("ratio")
                );
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User readUser(String username) {
        try {
            Connection connection = DriverManager.getConnection(data.getUrl(), data.getUser(), data.getPassword());
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from player where name = '" + username +"'");

            if (resultSet.next()) {
                return new User(
                        resultSet.getString("name"),
                        resultSet.getString("mail"),
                        resultSet.getString("password"),
                        resultSet.getInt("victorias"),
                        resultSet.getInt("totalGames"),
                        resultSet.getFloat("ratio")
                );
            } else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(User user) {
        try {
            Connection connection = DriverManager.getConnection(data.getUrl(), data.getUser(), data.getPassword());
            Statement statement = connection.createStatement();
            statement.executeUpdate("update player set victorias = '" + user.getVictories() + "', totalGames = '" + user.getTotalGames() + "', ratio = '" + user.getRatio() + "'where name = '" + user.getName() +"'");

            return true;

        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
        return false;
    }

}
