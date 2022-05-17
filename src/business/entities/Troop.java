package business.entities;

import business.GameManager;
import business.threads.TroopMovement;

import java.awt.*;

public class Troop implements Runnable{

    private int range;
    private String name;
    private float life;
    private int cost;
    private float damage;
    private float attackVelocity;
    private String type;
    private GameManager gameManager;
    private String[][] mapa;
    private TroopMovement movement;
    private int posx;
    private int posy;
    private Color color;


    public Troop(int posx, int posy) {

        this.posx = posx;
        this.posy = posy;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLife() {
        return life;
    }

    public void setLife(float life) {
        this.life = life;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public float getDamage() {
        return damage;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    public float getAttackVelocity() {
        return attackVelocity;
    }

    public void setAttackVelocity(float attackVelocity) {
        this.attackVelocity = attackVelocity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public void run() {

    }


    public void tropMove(String name){
        movement.moveTroop(name);
    }





    /*public String checkMove(int movel, int fila, int columna, String[][] mapa) {
        boolean front = false;
        boolean fRight = false;
        boolean fLeft = false;
        int finalpos[];
        int i = 1;
        if (columna == 0) {
            while (i <= movel) {
                if (mapa[fila + i][columna].equals("|")) front = true;
                if (mapa[fila + i][columna + i].equals("|")) fRight = true;
                i++;
            }
        } else if (columna == 20) {
            while (i <= movel) {
                if (mapa[fila + i][columna].equals("|")) front = true;
                if (mapa[fila + i][columna - i].equals("|")) fLeft = true;
                i++;
            }
        } else {
            while (i <= movel) {
                if (mapa[fila + i][columna].equals("|")) front = true;
                if (mapa[fila + i][columna - i].equals("|")) fLeft = true;
                if (mapa[fila + i][columna + i].equals("|")) fRight = true;
                i++;
            }
        }
        if(front){
            return "front";
        }else if (fRight){
            return "fRight";
        }else if (fLeft){
            return "fLeft";
        }else return "cant";
    }*/

}

