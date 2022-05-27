package business.entities;

/**
 * Clase del modelo del fichero de configuracion
 */
public class ConfigData {
    private int port;
    private String user;
    private String password;
    private String db;
    private String url;

    public ConfigData(){}

    public String getUser() {
        return user;
    }
    public String getPassword() {
        return password;
    }
    public String getUrl() {
        return url;
    }
}
