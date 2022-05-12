package business.threads;

import business.entities.Archer;
import business.entities.Troop;

import java.util.concurrent.ThreadLocalRandom;

public class TroopMovement implements Runnable {

    private Troop troop;
    private String[][] mapa;

    public TroopMovement(Troop troop, String[][] mapa) {
        this.troop = troop;
        this.mapa = mapa;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(((Archer)troop).getMovementVelocity());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            drawMap();
        }
    }

    public void drawMap() {
        int auxI = -1;
        int auxJ = -1;
        System.out.println();
        for(int i =0; i < mapa.length;i++){
            System.out.println();
            for(int j = 0; j < mapa.length;j++){
                System.out.print((mapa[i][j]));
                System.out.print(" ");
                if (mapa[i][j].equals(troop.getName())) {
                    auxI = i;
                    auxJ = j;
                }
            }
        }
        if (auxI != -1) {
            int randomNum = ThreadLocalRandom.current().nextInt(auxJ-1, auxJ+1 + 1);
            mapa[auxI][auxJ] = "|";
            mapa[auxI+1][randomNum] = troop.getName();
        }

    }
}
