package business.entities;

public class Giant extends Ofensive{

    public Giant(int range, String name, float life, int cost, float damage, float attackVelocity, String type, int movementVelocity, String prefObjective) {
        super(range, name, life, cost, damage, attackVelocity, type, movementVelocity, prefObjective);
        this.setRange(1);//cuadrados a la redonda posible 5
        this.setName("Giant");
        this.setLife(100);
        this.setCost(4);
        this.setDamage(5);
        this.setAttackVelocity(1);
        this.setMovementVelocity(1);
        this.setPrefObjective("Structure");
    }
}
