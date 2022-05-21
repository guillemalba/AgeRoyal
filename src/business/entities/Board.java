package business.entities;

import java.awt.*;

public class Board {
    private Cell[][] cellsMatrix;
    private int side = 15;
    private Cell cell;

    public Board() {
        this.cellsMatrix = new Cell[side][side];
        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                cellsMatrix[i][j] = new Cell(i, j, null);
            }
        }

    }

    public Cell[][] getCellsMatrix() {
        return cellsMatrix;
    }

    public boolean isEmpty(int i, int j){
        return cellsMatrix[i][j].getTroop() == null;
    }


    public Color getColorTroop(int i, int j){

        return cellsMatrix[i][j].getTroop().getColor();
    }



    public int getSide(){
        return side;
    }

    //necesitamos algo para saber donde poner la troop


    public void setTroopBoard(Troop troop){
        cellsMatrix[troop.getPosx()][troop.getPosy()].setTroop(troop);
    }

    public void removeTroopBoard(Troop troop){

        cellsMatrix[troop.getPosx()][troop.getPosy()].setTroop(null);
    }

    public boolean isOnTheEdge(int x, int y){
        if(x >=0 && x < side){
            if(y >= 0 && y < side) {
                return true;
            }
        }
        return false;
    }

    public void killTroop(int x,int y){
        cellsMatrix[x][y].getTroop().setStop(true);
    }



}
