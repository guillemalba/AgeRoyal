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

    public int getTroopId() {
        return troopId;
    }

    public void setTroopId(int troopId) {
        this.troopId = troopId;
    }

    public int getTimeDeployed() {
        return timeDeployed;
    }

    public void setTimeDeployed(int timeDeployed) {
        this.timeDeployed = timeDeployed;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public boolean isUser() {
        return isUser;
    }

    public void setUser(boolean user) {
        isUser = user;
    }

}
