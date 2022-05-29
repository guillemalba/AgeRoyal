package business.entities;



/**
 * Clase Board donde guardaremos un array de celdas
 */
public class Board {
    private Cell[][] cellsMatrix;
    private final int side = 15;

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
     * @param x posicion del mapa
     * @param y posicoin del mapa
     * @return true si esta vacia la celda
     */
    public synchronized boolean isEmpty(int x, int y){
        if (isInsideTheMap(x, y)) {
            return cellsMatrix[x][y].getTroop() == null;
        } else {
            return false;
        }
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

    /**
     * Metodo que comprueba si la posicion esta dentro del mapa o no
     *
     * @param x posicion
     * @param y posicion
     * @return true si esta en el mapa, false si no
     */
    public boolean isInsideTheMap(int x, int y){
        if(x >= 0 && x < side){
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

    //  TODO falta comentar
    public void stopTroop(int x, int y){
        cellsMatrix[x][y].getTroop().setPause(false);
    }
    public  void resumeTroop(int x, int y){
        cellsMatrix[x][y].getTroop().setPause(true);
    }



}
