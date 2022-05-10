package business.entities;

public class Canon extends Defensive {

    public Canon(int range, String name, float life, int cost, float damage, float attackVelocity, String type, int timeLife) {
        super(range, name, life, cost, damage, attackVelocity,type, timeLife);
        this.setRange(2);//cuadrados a la redonda
        this.setName("Canon");
        this.setLife(30);
        this.setCost(3);
        this.setDamage(4);
        this.setAttackVelocity(2);
        this.setType("Structure");
        this.setTimeLife(20);//seg
    }

}
