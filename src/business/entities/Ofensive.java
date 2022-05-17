package business.entities;

public class Ofensive extends Troop {
    private int movementVelocity;
    private String prefObjective;




    public Ofensive(int posx,int posy) {
        super(posx,posy);
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
