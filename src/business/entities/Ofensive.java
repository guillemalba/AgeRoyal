package business.entities;

import business.GameManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Ofensive extends Troop {
    private int movementVelocity;
    private String prefObjective;





    public Ofensive(String name, int posx, int posy, GameManager gameManager, boolean isUser, boolean stop, BufferedImage image) {
        super(name,posx,posy,gameManager, isUser, stop, image);
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
