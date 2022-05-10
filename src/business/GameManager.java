package business;

import business.entities.Base;
import business.entities.Troop;

import java.awt.image.AffineTransformOp;
import java.io.IOException;
import java.util.Arrays;

public class GameManager{
    private Base base2;
    private String mapa[][];
    private Troop base1;

    public GameManager() {
        mapa = new String[21][21];
        base1 = new Base();
        base2 = new Base();
        mapa[0][11] = base1.getName();
        mapa[20][11] = base2.getName();
        
        

        for(int i =0; i < mapa.length;i++){
            System.out.println();
            for(int j = 0; j < mapa.length;j++){
                System.out.print((mapa[i][j]));
                System.out.print(" ");
            }
        }


    }


}
