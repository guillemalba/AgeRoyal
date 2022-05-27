package business.entities;

import java.util.Date;

/**
 * Clase donde guardaremos los atributos necesarios para guardar un juego en la base de datos
 */
public class Game {
    private String name;
    private String date;
    private Boolean win;
    private String player;

    /**
     * Constructor con sus atributos
     *
     * @param name del juego
     * @param date fecha de la partida
     * @param win boleano para saber si ha ganado el usuario o no
     * @param player el nombre del jugador
     */
    public Game(String name, String date, Boolean win, String player) {
        this.name = name;
        this.date = date;
        this.win = win;
        this.player = player;
    }

    public Game getGame(){
        return new Game(this.name, this.date, this.win, this.player);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getWin() {
        return win;
    }

    public void setWin(Boolean win) {
        this.win = win;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }
}
