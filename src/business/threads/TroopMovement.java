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
    public synchronized void run() {
        while (true) {
            try {
                Thread.sleep(((Archer)troop).getMovementVelocity());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //drawMap();
            moveTroop();
        }
    }

    public synchronized void moveTroop() {
        int auxI = -1;
        int auxJ = -1;
        for(int i =0; i < mapa.length;i++){
            for(int j = 0; j < mapa.length;j++){
                if (mapa[i][j].equals(troop.getName())) {
                    auxI = i;
                    auxJ = j;
                }
            }
        }
        if (auxI != -1) {
            mapa[auxI][auxJ] = "|";
            if (auxJ > 10 && auxJ <= 20 && mapa[auxI+1][auxJ-1].equals("|")) {
                auxJ--;
                auxI++;
            } else if (auxJ < 10 && auxJ >= 0 && mapa[auxI+1][auxJ+1].equals("|")) {
                auxJ++;
                auxI++;
            } else if (mapa[auxI+1][auxJ].equals("|")) {
                auxI++;
            } else if (mapa[auxI+1][auxJ--].equals("|")) {
                auxI++;
                auxJ--;
            } else if (mapa[auxI+1][auxJ++].equals("|")) {
                auxI++;
                auxJ--;
            }
            mapa[auxI][auxJ] = troop.getName();
        }
    }

    public void cellIsEmpty() {

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
            mapa[auxI][auxJ] = "|";
            if (auxJ > 10 && auxJ <= 20) {
                auxJ--;
            }
            if (auxJ < 10 && auxJ >= 0) {
                auxJ++;
            }
            mapa[auxI+1][auxJ] = troop.getName();
        }

    }
}
