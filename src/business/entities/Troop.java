package business.entities;

import business.GameManager;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Clase tropa que implementa Runnable para que tenga el comportamiento de un thread y cada una sea diferente
 */
public class Troop implements Runnable{

    private boolean isUser;
    private boolean stop;
    private int range;
    private String name;
    private float life;
    private int cost;
    private float damage;
    private int attackVelocity;
    private String type;
    private GameManager gameManager;
    private int posx;
    private int posy;
    private BufferedImage image;

    /**
     * Constructor de la tropa con sus atributos
     *
     * @param name de la tropa
     * @param posx del mapa
     * @param posy del mapa
     * @param gameManager para acceder a los metodos del manager
     * @param isUser para saber si es la IA o el usuario
     * @param stop para detener el thread
     * @param image a cargar en el mapa
     */
    public Troop(String name,int posx, int posy, GameManager gameManager, boolean isUser,boolean stop, BufferedImage image) {

        this.name = name;
        this.posx = posx;
        this.posy = posy;
        this.gameManager = gameManager;
        this.isUser = isUser;
        this.stop = stop;
        this.image = image;
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
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

    public long getAttackVelocity() {
        return attackVelocity;
    }

    public void setAttackVelocity(int attackVelocity) {
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

    public boolean isUser() {
        return isUser;
    }

    public void setUser(boolean user) {
        isUser = user;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    @Override
    public void run() {

    }


    /**
     * Metodo para mover una tropa en el mapa
     *
     * @param direction en la que se debe mover la tropa
     */
    public void move(String direction) {

        gameManager.getBoard().removeTroopBoard(this);
        int auxX = getPosx();
        int auxY = getPosy();

        synchronized (Troop.class) {
            switch (direction) {
                case "up":
                    auxX--;
                    break;
                case "up-left":
                    auxX--;
                    auxY--;
                    break;
                case "up-right":
                    auxX--;
                    auxY++;
                    break;
                case "down":
                    auxX++;
                    break;
                case "down-left":
                    auxX++;
                    auxY--;
                    break;
                case "down-right":
                    auxX++;
                    auxY++;
                    break;
                case "false":
                    break;
            }
        }

        setPosx(auxX);
        setPosy(auxY);
        gameManager.getBoard().setTroopBoard(this);
    }


    /**
     * Metodo que busca un enemigo cerca al que atacar
     *
     * @return devuelve null si no hay enemigo en rango o devuelve la Tropa a la que hay que atacar
     */
    public Troop enemyNear() {
        // desde la posicion de la tropa menos el rango de ataque hasta la posicion de la tropa mas el rango de ataque
        for (int i = this.posx - this.range; i <= this.posx + this.range; i++) {
            for (int j = this.posy - this.range; j <= this.posy + this.range; j++) {

                // nos aseguramos que el rango este siempre dentro del mapa
                if (i >= 0 && j >= 0 && i <= 14 && j <= 14) {

                    // si el getter de la tropa del tablero no es null, significa que hat algo
                    if (gameManager.getBoard().getCellsMatrix()[i][j].getTroop() != null){

                        // si la tropa del tablero es del usuario y la tropa actual es de la IA entra y devuelve la tropa
                        if (gameManager.getBoard().getCellsMatrix()[i][j].getTroop().isUser() && !this.isUser) {
                            Troop troop = gameManager.getBoard().getCellsMatrix()[i][j].getTroop();
                            return troop;

                        // sino, si la tropa del mapa no es del usuario y la actual si, entra tambien y devuelve la tropa
                        } else if (!(gameManager.getBoard().getCellsMatrix()[i][j].getTroop().isUser()) && this.isUser) {
                            Troop troop = gameManager.getBoard().getCellsMatrix()[i][j].getTroop();
                            return troop;
                        }
                    }
                }
            }
        }

        return null;
    }

    /**
     * Metodo para atacar la tropa en concreto que devuelve la funcion enemyNear()
     *
     * @param enemyTroop que hay que atacar.
     */
    public void atack(Troop enemyTroop){

        while(enemyTroop.getLife() > 0 && !stop && isRange(enemyTroop)){

            System.out.println("Soy"+ name + "voy a pegar a " +enemyTroop.getName());

            try {
                Thread.sleep(attackVelocity);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (Troop.class) {
                if(enemyTroop.getLife() > 0.0){

                    enemyTroop.setLife(enemyTroop.getLife() - getDamage());
                    if(enemyTroop.getLife() <= 0.0){

                        System.out.println(getName() + "Que soy " + isUser + " Mato a "+ enemyTroop.getName());
                        gameManager.moneyReward(isUser);

                        removeTroop(isUser);
                        enemyTroop.setStop(true);
                    }
                }
            }
        }
    }

    /**
     * Metodo para ver si una tropa esta en rango, este metodo se ha hecho porque hay casos en los que las tropas a las que se estan atacando se siguen moviendo mientras las disparan
     *
     * @param enemyTroop para ver si todavia esta en rango
     * @return boolean si es true, esta en rango, sino no
     */
    public boolean isRange(Troop enemyTroop){
        if(this.posx - enemyTroop.getPosx() <= this.range || this.posx - enemyTroop.getPosx() >= -this.range ){
            if(this.posy - enemyTroop.getPosy() <= this.range || this.posy - enemyTroop.getPosy() >= -this.range){
                return true;
            }
               return false;
        }
        return false;
    }

    /**
     * Metodo que elimina una tropa del contador de tropas de las graficas del mapa
     * @param isUser si es la IA o el usuario al que se le tiene que restar 1
     */
    public void removeTroop(boolean isUser){
        System.out.println("entro a matar la tropa");
        gameManager.removeTroop(isUser);
    }

    /**
     * Metodo que elimina la tropa del tablero
     *
     * @param troop a eliminar
     */
    public void dieTroop(Troop troop){
        gameManager.getBoard().removeTroopBoard(troop);
    }

    /**
     * Metodo que comprueba si la tropa puede moverse o no.
     * Funcionamiento:
     *      - si la tropa se encuentra en el lado izquierdo del tablero, que intente moverse a la derecha
     *      - si la tropa se encuentra en el lado derecho del tablero, que intente moverse a la izquierda
     *      - si se encuentra en el medio, que intente moverse hacia delante
     *
     *      - si la casilla a la que intenta moverse esta ocupada, intenta moverse hacia delante, delante izquierda o delante derecha
     *
     * @return un String con la direccion a la que se debe mover la tropa
     */
    public String canMove() {
        if (this.isUser) {
            if (getPosy() > 7 && getPosy() <= 15) {
                if (gameManager.getBoard().isEmpty(getPosx() - 1, getPosy() - 1)) {
                    return "up-left";
                } else if (gameManager.getBoard().isEmpty(getPosx() - 1, getPosy())) {
                    return "up";
                }
            } else if (getPosy() < 7 && getPosy() >= 0) {
                if (gameManager.getBoard().isEmpty(getPosx() - 1, getPosy() + 1)) {
                    return "up-right";
                } else if (gameManager.getBoard().isEmpty(getPosx() - 1, getPosy())) {
                    return "up";
                }
            } else {
                if (gameManager.getBoard().isEmpty(getPosx() - 1, getPosy())) {
                    return "up";
                } else if (gameManager.getBoard().isEmpty(getPosx() - 1, getPosy() - 1)) {
                    return "up-left";
                } else if (gameManager.getBoard().isEmpty(getPosx() - 1, getPosy() + 1)) {
                    return "up-right";
                }
            }
        } else {
            if (getPosy() > 7 && getPosy() <= 15) {
                if (gameManager.getBoard().isEmpty(getPosx() + 1, getPosy() - 1)) {
                    return "down-left";
                } else if (gameManager.getBoard().isEmpty(getPosx() + 1, getPosy())) {
                    return "down";
                }
            } else if (getPosy() < 7 && getPosy() >= 0) {
                if (gameManager.getBoard().isEmpty(getPosx() + 1, getPosy() + 1)) {
                    return "down-right";
                } else if (gameManager.getBoard().isEmpty(getPosx() + 1, getPosy())) {
                    return "down";
                }
            } else {
                if (gameManager.getBoard().isEmpty(getPosx() + 1, getPosy())) {
                    return "down";
                } else if (gameManager.getBoard().isEmpty(getPosx() + 1, getPosy() - 1)) {
                    return "down-left";
                } else if (gameManager.getBoard().isEmpty(getPosx() + 1, getPosy() + 1)) {
                    return "down-right";
                }
            }

        }
        return "false";
    }

    /**
     * Metodo que termina el juego
     *
     * @param isUser un boleano con el ganador de la partida, si es true, el usuario ha ganado
     */
    public void stopGame(boolean isUser, boolean somebodyWon){
        gameManager.stopGame(isUser, somebodyWon);
    }




}

