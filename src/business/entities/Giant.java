package business.entities;

public class Giant extends Ofensive{

    public Giant() {
        super();
        this.setRange(1);//cuadrados a la redonda posible 5
        this.setName("G");
        this.setLife(100);
        this.setCost(4);
        this.setDamage(5);
        this.setAttackVelocity(1);
        this.setMovementVelocity(1);
        this.setPrefObjective("Structure");
    }
}
