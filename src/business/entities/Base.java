package business.entities;

import java.awt.*;

public class Base extends Defensive{
    private int posx;
    private int posy;


    public Base(int posx,int posy) {
        super(posx,posy);
        this.setRange(4);//cuadrados a la redonda posible 5
        this.setName("B");
        this.setLife(400);
        this.setCost(0);
        this.setDamage(6);
        this.setAttackVelocity(2000);
        this.setType("Structure");
        this.setTimeLife(10000);//seg
        this.setColor(Color.BLUE);
        this.posx = posx;
        this.posy = posy;
    }
}
