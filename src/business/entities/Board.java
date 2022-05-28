package business.entities;

import java.awt.*;

/**
 * Clase Board donde guardaremos un array de celdas
 */
public class Board {
    private Cell[][] cellsMatrix;
    private int side = 15;
    private Cell cell;

    /**
     * Constructor para inicializar la matriz de celdas
     */
    public Board() {
        this.cellsMatrix = new Cell[side][side];
        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                cellsMatrix[i][j] = new Cell(i, j, null);
            }
        }

    }

    /**
     * Devuelve el array de celdas
     * @return array de Cells
     */
    public Cell[][] getCellsMatrix() {
        return cellsMatrix.clone();
    }

    /**
     * Metodo para detectar si hay una tropa en el tablero
     * @param i posicion del mapa
     * @param j posicoin del mapa
     * @return true si esta vacia la celda
     */
    public synchronized boolean isEmpty(int i, int j){
        return cellsMatrix[i][j].getTroop() == null;
    }

    /**
     * Metodo que devuelve el tamaño del tablero
     *
     * @return tamaño del tablero
     */
    public int getSide(){
        return side;
    }

    /**
     * Metodo para añadir una tropa en el tablero
     * @param troop
     */
    public void setTroopBoard(Troop troop){
        cellsMatrix[troop.getPosx()][troop.getPosy()].setTroop(troop);
    }

    /**
     * Metodo para eliminar la tropa del tablero
     * @param troop a eliminar
     */
    public void removeTroopBoard(Troop troop){
        cellsMatrix[troop.getPosx()][troop.getPosy()].setTroop(null);
    }

    // todo si al final no se usa borra esto
    public boolean isOnTheEdge(int x, int y){
        if(x >=0 && x < side){
            if(y >= 0 && y < side) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para detener el thread
     * @param x posicion del mapa
     * @param y posicion del mapa
     */
    public void killTroop(int x,int y){
        cellsMatrix[x][y].getTroop().setStop(true);
    }



}
