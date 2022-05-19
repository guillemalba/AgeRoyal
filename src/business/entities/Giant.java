package business.entities;

import business.GameManager;

public class Giant extends Ofensive{

    public Giant(int posx, int posy, GameManager gameManager) {
        super(posx, posy,gameManager);
        this.setRange(1);//cuadrados a la redonda posible 5
        this.setName("G");
        this.setLife(100);
        this.setCost(4);
        this.setDamage(5);
        this.setAttackVelocity(10000);
        this.setMovementVelocity(1000);
        this.setPrefObjective("Structure");
    }
}
