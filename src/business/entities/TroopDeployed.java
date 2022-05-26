package business.entities;

public class TroopDeployed {
    private int troopId;
    private int timeDeployed;
    private int posX;
    private int posY;
    private boolean isUser;


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
