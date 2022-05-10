package business.entities;

public class Defensive extends Troop {
    private int timeLife;


    public Defensive(int range, String name, float life, int cost, float damage, float attackVelocity, String type, int timeLife) {
        super(range, name, life, cost, damage, attackVelocity, type);
        this.timeLife = timeLife;
    }

    public Defensive(){
        super();
    }

    public int getTimeLife() {
        return timeLife;
    }

    public void setTimeLife(int timeLife) {
        this.timeLife = timeLife;
    }
}
