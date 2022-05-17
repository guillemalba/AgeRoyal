package business.entities;

import java.awt.*;

public class Archer extends Ofensive {

    private int posx;
    private int posy;



    public Archer(int posx,int posy) {
        super(posx,posy);
        this.setRange(1);//cuadrados a la redonda posible 5
        this.setName("A");
        this.setLife(12);
        this.setCost(2);
        this.setDamage(3);//quiza 2
        this.setAttackVelocity(3000);
        this.setMovementVelocity(3000);
        this.setPrefObjective("all");
        this.posx = posx;
        this.posy = posy;
        this.setColor(Color.RED);
    }



    @Override
    public int getMovementVelocity() {
        return super.getMovementVelocity();
    }

    @Override
    public synchronized void run() {
        while (true) {
            try {

                Thread.sleep(getMovementVelocity());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //drawMap();
            //tropMove("A");
        }
    }
}
