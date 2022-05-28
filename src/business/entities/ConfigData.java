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

    /**
     * Getter que devuelve el nombre de usuario de la base de datos
     *
     * @return el nombre del usuario
     */
    public String getUser() {
        return user;
    }

    /**
     * Getter que devuelve la contraseña
     *
     * @return la contraseña
     */
    public String getPassword() {
        return password;
    }

    /**
     * Getter que devuelve la url de la base de datos
     *
     * @return
     */
    public String getUrl() {
        return url;
    }
}
