package business.entities;

public class Base extends Defensive{
    public Base() {
        super();
        this.setRange(4);//cuadrados a la redonda posible 5
        this.setName("B");
        this.setLife(400);
        this.setCost(0);
        this.setDamage(6);
        this.setAttackVelocity(2);
        this.setType("Structure");
        this.setTimeLife(10000);//seg
    }
}
