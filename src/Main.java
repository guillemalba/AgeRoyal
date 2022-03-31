import business.json.ConfigData;
import business.json.JsonReader;

import javax.xml.namespace.QName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        System.out.println("First commit");
        ConfigData data;

        data = JsonReader.llegeixJson(); //funcion para leer el Json
        try (Connection connection = DriverManager.getConnection(data.getUrl(), data.getUser(), data.getPassword())) {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM player");
            while ((resultSet.next())){
                System.out.println(resultSet.getString("name")+ "\t" + resultSet.getString("mail"));
            }
        }  catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }
    
}






