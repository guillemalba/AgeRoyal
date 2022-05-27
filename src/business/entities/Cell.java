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
     * @param x
     * @param y
     * @param troop
     */
    public Cell(int x, int y, Troop troop) {
        this.x = x;
        this.y = y;
        this.troop = troop;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public Troop getTroop() {
        return troop;
    }

    public void setTroop(Troop troop) {
        this.troop = troop;
    }

    public void setY(int y) {
        this.y = y;
    }

}
