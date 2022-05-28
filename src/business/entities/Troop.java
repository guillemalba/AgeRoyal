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

    /**
     * Getter que devuelve si el thread esta parado o no
     * @return true si esta parado
     */
    public boolean isStop() {
        return stop;
    }

    /**
     * Setter para parar el thread
     * @param stop true si esta parado
     */
    public void setStop(boolean stop) {
        this.stop = stop;
    }

    /**
     * Getter para devolver el rango de ataque de la tropa
     * @param range de ataque
     */
    public void setRange(int range) {
        this.range = range;
    }

    /**
     * Getter para devolver el nombre de la tropa
     *
     * @return el nombre de la tropa
     */
    public String getName() {
        return name;
    }

    /**
     * Setter para asignar un nombre a la tropa
     *
     * @param name de la tropa
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter para devolver la vida de la tropa
     *
     * @return vida
     */
    public float getLife() {
        return life;
    }

    /**
     * Setter para asignar la vida de la tropa
     *
     * @param life de la tropa
     */
    public void setLife(float life) {
        this.life = life;
    }

    /**
     * Getter para devolver el coste de la tropa
     *
     * @return coste
     */
    public int getCost() {
        return cost;
    }

    /**
     * Setter para asignar un coste a la tropa
     *
     * @param cost de la tropa
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * Getter para devolver el daño de la tropa
     *
     * @return daño
     */
    public float getDamage() {
        return damage;
    }

    /**
     * Setter para asignar el daño de la tropa
     *
     * @param damage de la tropa
     */
    public void setDamage(float damage) {
        this.damage = damage;
    }

    /**
     * Getter para devolver el tiempo que tarda la tropa en realizar el ataque
     *
     * @return tiempo de ataque de la tropa
     */
    public long getAttackVelocity() {
        return attackVelocity;
    }

    /**
     * Setter para asignar el tiempo que tarda la tropa en realizar el ataque
     *
     * @param attackVelocity de la tropa
     */
    public void setAttackVelocity(int attackVelocity) {
        this.attackVelocity = attackVelocity;
    }

    /**
     * Getter para devolver el tipo de tropa que es
     *
     * @return el tipo
     */
    public String getType() {
        return type;
    }

    /**
     * Setter para asignar el tipo de tropa que es
     *
     * @param type de la tropa
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Getter para devolver la posicion x de la tropa en el mapa
     *
     * @return posicion x
     */
    public int getPosx() {
        return posx;
    }

    /**
     * Setter para asignar la posicion x de la tropa en el mapa
     *
     * @param posx de la tropa
     */
    public void setPosx(int posx) {
        this.posx = posx;
    }

    /**
     * Getter para devolver la posicion y de la tropa en el mapa
     *
     * @return posicion y
     */
    public int getPosy() {
        return posy;
    }

    /**
     * Setter para asignar la posicion y de la tropa en el mapa
     *
     * @param posy de la tropa
     */
    public void setPosy(int posy) {
        this.posy = posy;
    }

    /**
     * Getter para saber si la tropa es del usuario o de la IA
     *
     * @return true si pertenece al usuario, false si pertenece a la IA
     */
    public boolean isUser() {
        return isUser;
    }

    /**
     * Setter para asignar un boleano a la tropa y diferenciar si es del usuario o de la IA
     *
     * @param user true si pertenece al usuario, false si pertenece a la IA
     */
    public void setUser(boolean user) {
        isUser = user;
    }

    /**
     * Getter para devolver la imagen de la tropa
     *
     * @return la imagen
     */
    public BufferedImage getImage() {
        return image;
    }

    /**
     * Setter para asignar una imagen a la tropa
     *
     * @param image de la tropa
     */
    public void setImage(BufferedImage image) {
        this.image = image;
    }

    /**
     * Metodo run que iremos implementando en cada tropa especifica, debido a que todas las tropas tienen comportamientos distintos
     */
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
                        if(!gameManager.isRepro())gameManager.moneyReward(isUser);

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

