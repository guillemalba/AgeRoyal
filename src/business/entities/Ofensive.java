package business.entities;

import business.GameManager;

import java.awt.*;

public class Ofensive extends Troop {
    private int movementVelocity;
    private String prefObjective;





    public Ofensive(String name, int posx, int posy, GameManager gameManager, boolean isUser, boolean stop, Color color) {
        super(name,posx,posy,gameManager, isUser,stop,color);
    }



    public int getMovementVelocity() {
        return movementVelocity;
    }

    public void setMovementVelocity(int movementVelocity) {
        this.movementVelocity = movementVelocity;
    }

    public String getPrefObjective() {
        return prefObjective;
    }

    public void setPrefObjective(String prefObjective) {
        this.prefObjective = prefObjective;
    }



}
