package business.entities;

/**
 * Clase Celda donde se guardara la posicion x,y de la Board, tambien guardamos la tropa que pondremos en el mapa
 */
public class Cell {
    private int x;
    private int y;
    private Troop troop;

    /**
     * Constructor con la tropa y su posicion
     *
     * @param x de la posicion
     * @param y de la posicion
     * @param troop que se encuentra guardada en la celda
     */
    public Cell(int x, int y, Troop troop) {
        this.x = x;
        this.y = y;
        this.troop = troop;
    }

    /**
     * Getter para devolver la posicion x de la celda en el mapa
     *
     * @return la posicion
     */
    public int getX() {
        return x;
    }

    /**
     * Setter para asignar la posicion x de la celda en el mapa
     *
     * @param x de la posicion
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Getter para devolver la posicion y de la celda en el mapa
     *
     * @return la posicion
     */
    public int getY() {
        return y;
    }

    /**
     * Setter para asignar la posicion y de la celda en el mapa
     *
     * @param y de la posicion
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Getter que devuelve la instancia de la tropa que se encuentra en la celda
     *
     * @return
     */
    public Troop getTroop() {
        return troop;
    }

    /**
     * Setter de la tropa que queremos añadir en la celda
     *
     * @param troop a añadir
     */
    public void setTroop(Troop troop) {
        this.troop = troop;
    }

}
