package business.entities;

public class Ofensive extends Troop {
    private int movementVelocity;
    private String prefObjective;

    public Ofensive(int range, String name, float life, int cost, float damage, float attackVelocity, String type, int movementVelocity, String prefObjective) {
        super(range, name, life, cost, damage, attackVelocity, type);
        this.movementVelocity = movementVelocity;
        this.prefObjective = prefObjective;
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
