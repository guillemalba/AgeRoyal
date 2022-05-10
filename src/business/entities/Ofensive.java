package business.entities;

public class Ofensive extends Troop {
    private int movementVelocity;
    private String prefObjective;

    public Ofensive( int movementVelocity, String prefObjective) {
        super();
        this.movementVelocity = movementVelocity;
        this.prefObjective = prefObjective;
    }
    public Ofensive(){
        super();
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
