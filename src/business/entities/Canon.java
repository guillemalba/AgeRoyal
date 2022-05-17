package business.entities;

public class Canon extends Defensive {
    private int posx;
    private int posy;
    public Canon(int posx,int posy) {
        super(posx,posy);
        this.setRange(2);//cuadrados a la redonda
        this.setName("Canon");
        this.setLife(30);
        this.setCost(3);
        this.setDamage(4);
        this.setAttackVelocity(2000);
        this.setType("Structure");
        this.setTimeLife(20);//seg
        this.posx = posx;
        this.posy = posy;
    }

}
