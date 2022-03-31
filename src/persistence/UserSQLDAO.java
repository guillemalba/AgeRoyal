package persistence;
import business.json.*;
import java.sql.*;


public class UserSQLDAO {
    public UserSQLDAO() {
    }

    ConfigData data = JsonReader.llegeixJson();

    public void register(String user, String pass, String mail) {
        try {
            Connection connection = DriverManager.getConnection(data.getUrl(), data.getUser(), data.getPassword());
            Statement statement = connection.createStatement();
            statement.execute("insert into player values('" + user + "','" + mail + "','" + pass + "',0,0,0)");
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
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

    public boolean login(String user,String pass) {
        boolean correcte = false;
        try {
            Connection connection = DriverManager.getConnection(data.getUrl(), data.getUser(), data.getPassword());
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from player");

            while ((resultSet.next())) {
                if(resultSet.getString("name").equals(user) || resultSet.getString("mail").equals(user)){
                    if(resultSet.getString("password").equals(pass)){
                        correcte = true;
                        return correcte;
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
        return correcte;
    }

    public void deleteAccount(String user){
        try {
            Connection connection = DriverManager.getConnection(data.getUrl(), data.getUser(), data.getPassword());
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from player");

            while ((resultSet.next())) {
                if(resultSet.getString("name").equals(user)){
                    statement.execute("delete from player where name ='" + user + "'");
                    System.out.println("The account has been successfully deleted");
                    return;
                }
            }
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
        System.out.println("No s ha trobat el usuari");
        return;
    }
}
