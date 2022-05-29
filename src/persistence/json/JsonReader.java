package persistence.json;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Clase que lee el json del archivo de configuracion
 */
public class JsonReader {
    private static ConfigData data = new ConfigData();

    /**
     * Metodo que lee la informacion del json
     * @return info del json en una classe Data
     */
    public static ConfigData llegeixJson() {
        try{
            Gson gson = new Gson();
            com.google.gson.stream.JsonReader reader;
            reader = new com.google.gson.stream.JsonReader(new FileReader("files/config.json"));
            data = gson.fromJson(reader, ConfigData.class);

        }catch(FileNotFoundException e){
            System.out.println("No s'ha pogut llegir el fitxer JSON: " + e.getMessage());
        }
        return data;
    }
}
