package business.entities;

import java.awt.*;

public class Board {
    private Cell[][] board;
    private int side = 15;
    private Cell cell;

    public Board() {
        this.board = new Cell[side][side];
        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                board[i][j] = new Cell(i, j, null);
            }
        }

    }

    public Cell[][] getBoard() {
        return board;
    }

    public boolean isEmpty(int i, int j){
        return board[i][j].getTroop() == null;
    }


    public Color getColorTroop(int i, int j){

        return board[i][j].getTroop().getColor();
    }

    public int getSide(){
        return side;
    }

    //necesitamos algo para saber donde poner la troop


    public void setTroopBoard(Troop troop){
        board[troop.getPosx()][troop.getPosy()].setTroop(troop);
    }

    public void removeTroopBoard(Troop troop){

        board[troop.getPosx()][troop.getPosy()] = null;
    }

    public boolean isFinal(int x, int y){
        if(x >=0 && x < side){
            if(y >= 0 && y < side) {
                return true;
            }
        }
        return false;
    }

}
