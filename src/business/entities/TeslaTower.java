package business.entities;

public class TeslaTower extends Defensive{
    private boolean hide;

    public TeslaTower(int range, String name, float life, int cost, float damage, float attackVelocity, String type, int timeLife, boolean hide) {
        super(range, name, life, cost, damage, attackVelocity, type, timeLife);
        this.hide = hide;
        this.setRange(2);//cuadrados a la redonda
        this.setName("TeslaTower");
        this.setLife(20);
        this.setCost(3);
        this.setDamage(5);
        this.setAttackVelocity(2);
        this.setType("Structure");
        this.setTimeLife(30);//seg
    }

    public TeslaTower() {
        this.setRange(2);//cuadrados a la redonda
        this.setName("TeslaTower");
        this.setLife(20);
        this.setCost(3);
        this.setDamage(5);
        this.setAttackVelocity(2);
        this.setType("Structure");
        this.setTimeLife(30);//seg
    }


    public boolean isHide() {
        return hide;
    }

    public void setHide(boolean hide) {
        this.hide = hide;
    }

}
