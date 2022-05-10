package business.entities;

public class Archer extends Ofensive{


    public Archer(int range, String name, float life, int cost, float damage, float attackVelocity, String type, int movementVelocity, String prefObjective) {
        super(range, name, life, cost, damage, attackVelocity, type, movementVelocity, prefObjective);
        this.setRange(1);//cuadrados a la redonda posible 5
        this.setName("ARcher");
        this.setLife(12);
        this.setCost(2);
        this.setDamage(3);//quiza 2
        this.setAttackVelocity(3);
        this.setMovementVelocity(3);
        this.setPrefObjective("all");
    }
}
