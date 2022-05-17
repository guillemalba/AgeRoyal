package business.entities;

public class Giant extends Ofensive{
private int posx;
private int posy;
    public Giant(int posx,int posy) {
        super(posx, posy);
        this.setRange(1);//cuadrados a la redonda posible 5
        this.setName("G");
        this.setLife(100);
        this.setCost(4);
        this.setDamage(5);
        this.setAttackVelocity(10000);
        this.setMovementVelocity(1000);
        this.setPrefObjective("Structure");
        this.posx = posx;
        this.posy = posy;
    }
}
