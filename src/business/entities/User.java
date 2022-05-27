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
    private int gameTime;
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
     * @param gameTime del juego
     */
    public User(GameManager gameManager, int gameTime) {
        this.gameManager = gameManager;
        this.gameTime = gameTime;
        this.money = 5;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getVictories() {
        return victories;
    }

    public void setVictories(int victories) {
        this.victories = victories;
    }

    public int getTotalGames() {
        return totalGames;
    }

    public void setTotalGames(int totalGames) {
        this.totalGames = totalGames;
    }

    public float getRatio() {
        return ratio;
    }

    public void setRatio(float ratio) {
        this.ratio = ratio;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getNumTroopAlive() {
        return numTroopAlive;
    }

    public void setNumTroopAlive(int numTroopAlive) {
        this.numTroopAlive = numTroopAlive;
    }
}