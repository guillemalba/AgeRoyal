package business.entities;

import business.GameManager;

public class TeslaTower extends Defensive{
    private boolean hide;


    public TeslaTower(String name,int posx, int posy, GameManager gameManager, boolean isUser,boolean stop) {
        super(name,posx, posy, gameManager, isUser,stop);
        this.hide = hide;
        this.setRange(2);//cuadrados a la redonda
        this.setName("TeslaTower");
        this.setLife(20);
        this.setCost(3);
        this.setDamage(5);
        this.setAttackVelocity(2000);
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
