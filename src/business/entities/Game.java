package business.entities;


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

    /**
     * Getter para devolver una partida guardada
     *
     * @return el la partida
     */
    public Game getGame(){
        return new Game(this.name, this.date, this.win, this.player);
    }

    /**
     * Getter que devuelve el nombre de la partida
     *
     * @return nombre de la partida
     */
    public String getName() {
        return name;
    }

    /**
     * Setter para asignar un nombre a la partida jugada
     *
     * @param name de la partida
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter que devuelve la fecha de la partida
     *
     * @return la fecha
     */
    public String getDate() {
        return date;
    }


    /**
     * Getter que devuelve el ganador
     *
     * @return true si ha ganado el usuario, false si ha ganado la IA
     */
    public boolean getWin() {
        return win;
    }


    /**
     * Getter para devolver el nombre del jugador que ha realizado la partida
     *
     * @return el nombre del jugador
     */
    public String getPlayer() {
        return player;
    }

}
