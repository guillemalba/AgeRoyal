package business.entities;

public class Troop {

    private int range;
    private String name;
    private float life;
    private int cost;
    private float damage;
    private float attackVelocity;
    private String type;

    public Troop(int range, String name, float life, int cost, float damage, float attackVelocity, String type) {
        this.range = range;
        this.name = name;
        this.life = life;
        this.cost = cost;
        this.damage = damage;
        this.attackVelocity = attackVelocity;
        this.type = type;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLife() {
        return life;
    }

    public void setLife(float life) {
        this.life = life;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public float getDamage() {
        return damage;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    public float getAttackVelocity() {
        return attackVelocity;
    }

    public void setAttackVelocity(float attackVelocity) {
        this.attackVelocity = attackVelocity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
