package business.entities;

import java.util.Date;

public class Game {
    private String name;
    private String date;
    private Boolean win;
    private String player;

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
