package business;

import business.entities.Archer;
import business.entities.Base;
import business.entities.Troop;
import business.threads.GameTimer;
import business.threads.TroopMovement;
import business.threads.UpdateMap;

import java.awt.image.AffineTransformOp;
import java.io.IOException;
import java.util.Arrays;

public class GameManager{
    private Base base2;
    private String mapa[][];
    private Troop base1;
    private int time;

    public GameManager(int time) {
        mapa = new String[21][21];
        base1 = new Base();
        base2 = new Base();

        this.time = time;



        /*mapa[0][10] = base1.getName();
        mapa[0][10] = "B2";
        mapa[20][10] = base2.getName();
        mapa[20][10] = "B1";*/

        for(int m =0; m < mapa.length;m++){
            for(int n = 0; n < mapa.length;n++){
                mapa[m][n] = "|";
            }
        }

        mapa[20][10] = "B";
        mapa[0][10] = "B";
        mapa[0][0] = "A";
        mapa[0][20] = "A";

        GameTimer gameTimer = new GameTimer(1000, time);
        TroopMovement archer = new TroopMovement(new Archer(0, "all"), mapa);
        TroopMovement archer2 = new TroopMovement(new Archer(0, "all"), mapa);

        UpdateMap updateMap = new UpdateMap(mapa);
        new Thread(updateMap).start();

        //new Thread(gameTimer).start();
        new Thread(archer).start();
        new Thread(archer2).start();

    }


}
