package business.entities;

public class TeslaTower extends Defensive{
    private boolean hide;
    private int posx;
    private int posy;

    public TeslaTower(int posx,int posy) {
        super(posx,posy);
        this.hide = hide;
        this.setRange(2);//cuadrados a la redonda
        this.setName("TeslaTower");
        this.setLife(20);
        this.setCost(3);
        this.setDamage(5);
        this.setAttackVelocity(2000);
        this.setType("Structure");
        this.setTimeLife(30);//seg
        this.posx = posx;
        this.posy = posy;
    }


    


    public boolean isHide() {
        return hide;
    }

    public void setHide(boolean hide) {
        this.hide = hide;
    }

}
