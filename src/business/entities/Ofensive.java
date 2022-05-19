package business.entities;

import business.GameManager;

public class Ofensive extends Troop {
    private int movementVelocity;
    private String prefObjective;





    public Ofensive(int posx, int posy, GameManager gameManager) {
        super(posx,posy,gameManager);
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
