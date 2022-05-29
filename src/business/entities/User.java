package business.entities;

import business.GameManager;

/**
 * Clase del usuario que juega la partida con sus atributos necesarios
 */
public class User {
    private String name;
    private String email;
    private String password;
    private int victories;
    private int totalGames;
    private float ratio;
    private int money = 5;
    private GameManager gameManager;
    private int numTroopAlive = 0;

    /**
     * Constructor para leer los usuarios del ranking en la DAO
     *
     * @param name del usuario
     * @param email del usuario
     * @param password del usuario
     * @param victories del usuario
     * @param totalGames del usuario
     * @param ratio del usuario
     */
    public User(String name, String email, String password, int victories, int totalGames, float ratio) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.victories = victories;
        this.totalGames = totalGames;
        this.ratio = ratio;
    }

    /**
     * Constructor para crear el usuario en el login y el register
     *
     * @param name del usuario
     * @param email del usuario
     * @param password del usuario
     */
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    /**
     * Constructor para el GameManager
     *
     * @param gameManager del juego
     */
    public User(GameManager gameManager) {
        this.gameManager = gameManager;
        this.money = 5;
    }

    /**
     * Getter para devolver el nombre del usuario
     *
     * @return nombre del usuario
     */
    public String getName() {
        return name;
    }

    /**
     * Setter para asignar el nombre del usuario
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter para devolver el email del usuario
     *
     * @return email del usuario
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter para asignar el email del usuario
     *
     * @param email del usuario
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter para devolver el password del usuario
     *
     * @return password del usuario
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter para asignar el password del usuario
     *
     * @param password del usuario
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter para devolver el numero de victorias del usuario
     *
     * @return victorias del usuario
     */
    public int getVictories() {
        return victories;
    }

    /**
     * Setter para asignar el numero de victorias del usuario
     *
     * @param victories del usuario
     */
    public void setVictories(int victories) {
        this.victories = victories;
    }

    /**
     * Getter para devolver el numero total de juegos del usuario
     *
     * @return total de juegos del usuario
     */
    public int getTotalGames() {
        return totalGames;
    }

    /**
     * Setter para asignar el numero de partidas del usuario
     *
     * @param totalGames del usuario
     */
    public void setTotalGames(int totalGames) {
        this.totalGames = totalGames;
    }

    /**
     * Getter para devolver el ratio del usuario
     *
     * @return ratio del usuario
     */
    public float getRatio() {
        return ratio;
    }

    /**
     * Setter para asignar el ratio del usuario
     *
     * @param ratio del jugador
     */
    public void setRatio(float ratio) {
        this.ratio = ratio;
    }

    /**
     * Getter para devolver el dinero del usuario en la partida
     *
     * @return dinero del usuario en la partida
     */
    public int getMoney() {
        return money;
    }

    /**
     * Setter para asignar el dinero de la partida del usuario
     *
     * @param money de la partida
     */
    public void setMoney(int money) {
        this.money = money;
    }

    /**
     * Getter para devolver el numero de tropas vivas del usuario en la partida
     *
     * @return numero de tropas vivas del usuario en la partida
     */
    public int getNumTroopAlive() {
        return numTroopAlive;
    }

    /**
     * Setter para asignar el numero de tropas vivas de la partida del usuario
     *
     * @param numTroopAlive de la partida
     */
    public void setNumTroopAlive(int numTroopAlive) {
        this.numTroopAlive = numTroopAlive;
    }
}