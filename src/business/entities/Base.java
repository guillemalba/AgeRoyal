package business.entities;

import business.GameManager;

import java.awt.*;

public class Base extends Defensive{

    public Base(int posx, int posy, GameManager gameManager, boolean isUser) {
        super(posx,posy,gameManager, isUser);
        this.setRange(1);//cuadrados a la redonda posible 5
        this.setName("B");
        this.setLife(400);
        this.setCost(0);
        this.setDamage(6);
        this.setAttackVelocity(2000);
        this.setType("Structure");
        this.setTimeLife(10000);//seg
        this.setColor(Color.BLUE);
    }
}
