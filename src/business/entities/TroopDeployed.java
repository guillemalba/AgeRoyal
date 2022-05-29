package business.entities;

/**
 * Clase con los atributos necesarios para guardar cada tropa que se ha desplegado en el mapa con la posicion y el segundo de la partida
 */
public class TroopDeployed {
    private int troopId;
    private int timeDeployed;
    private int posX;
    private int posY;
    private boolean isUser;

    /**
     * Constructor para crear una nueva tropa desplegada
     *
     * @param troopId id de la tropa (si es archer, giant, cannon, tesla)
     * @param timeDeployed tiempo de la partida en el que se ha desplegado la tropa
     * @param posX posicion de la tropa en el momento del despliegue
     * @param posY posicion de la tropa en el momento del despliegue
     * @param isUser si la tropa es de la IA o del usuario
     */
    public TroopDeployed(int troopId, int timeDeployed, int posX, int posY, boolean isUser) {
        this.troopId = troopId;
        this.timeDeployed = timeDeployed;
        this.posX = posX;
        this.posY = posY;
        this.isUser = isUser;
    }

    /**
     * Getter que devuelve el id de la tropa
     *
     * @return id
     */
    public int getTroopId() {
        return troopId;
    }


    /**
     * Getter que devuelve el tiempo de la partida en que se ha desplegado de la tropa
     *
     * @return tiempo de la partida
     */
    public int getTimeDeployed() {
        return timeDeployed;
    }


    /**
     * Getter que devuelve la posicion X de la tropa
     *
     * @return posicion X
     */
    public int getPosX() {
        return posX;
    }


    /**
     * Getter que devuelve la posicion Y de la tropa
     *
     * @return posicion Y
     */
    public int getPosY() {
        return posY;
    }


    /**
     * Getter que devuelve si la tropa es del usuario o de la IA
     *
     * @return true si es del usuario, false si es de la IA
     */
    public boolean isUser() {
        return isUser;
    }

    /**
     * Setter para asignar si la topa desplegada es del usuario o no
     *
     * @param user true si es del usuario, false si es de la IA
     */
    public void setUser(boolean user) {
        isUser = user;
    }

}
