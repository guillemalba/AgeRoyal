package persistence;
import business.entities.User;
import business.json.*;
import java.sql.*;


public class UserSQLDAO implements UserDAO{
    private ConfigData data;

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
        System.out.println("No s'ha trobat el usuari"); // TODO: eliminar sout
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


    public void mostrar() {
        try {
            Connection connection = DriverManager.getConnection(data.getUrl(), data.getUser(), data.getPassword());
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from player");

            while ((resultSet.next())) {
                System.out.println(resultSet.getString("name") + "\t" + resultSet.getString("mail") + "\t" + resultSet.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }
}
