package persistence;
import business.json.*;
import java.sql.*;

public class UserSQLDAO  {
    public UserSQLDAO() {
    }

    ConfigData data = JsonReader.llegeixJson();
    public void register(String user, String pass,String mail) {
        try {
            Connection connection = DriverManager.getConnection(data.getUrl(), data.getUser(), data.getPassword());
            Statement statement = connection.createStatement();
            statement.execute("insert into player values('"+user+"','"+pass+"','"+mail+"',0,0,0)");
        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }

    public void mostrar(){
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
