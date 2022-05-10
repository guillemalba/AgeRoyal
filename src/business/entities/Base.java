package business.entities;

public class Base extends Defensive{
    public Base(int range, String name, float life, int cost, float damage, float attackVelocity, String type, int timeLife) {
        super(range, name, life, cost, damage, attackVelocity, type, timeLife);
        this.setRange(4);//cuadrados a la redonda posible 5
        this.setName("Base");
        this.setLife(400);
        this.setCost(0);
        this.setDamage(6);
        this.setAttackVelocity(2);
        this.setType("Structure");
        this.setTimeLife(10000);//seg
    }
}
