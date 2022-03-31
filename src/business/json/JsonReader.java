package business.json;

import com.google.gson.Gson;
import java.io.FileReader;

public class JsonReader {
    private static ConfigData data = new ConfigData();

    /**
     * Mètode que llegeix la informació del json
     * @return informació del json en una classe Data
     */
    public static ConfigData llegeixJson() {
        try{
            Gson gson = new Gson();
            com.google.gson.stream.JsonReader reader;
            reader = new com.google.gson.stream.JsonReader(new FileReader("files/config.json"));
            data = gson.fromJson(reader, ConfigData.class);

        }catch(Exception e){
            System.out.println("No s'ha pogut llegir el fitxer JSON: " + e.getMessage());
        }
        return data;
    }
}
