package business.entities;

import business.GameManager;

public class Canon extends Defensive {

    public Canon(int posx, int posy, GameManager gameManager, boolean isUser) {
        super(posx,posy,gameManager, isUser);
        this.setRange(2);//cuadrados a la redonda
        this.setName("Canon");
        this.setLife(30);
        this.setCost(3);
        this.setDamage(4);
        this.setAttackVelocity(2000);
        this.setType("Structure");
        this.setTimeLife(20);//seg

    }

}
