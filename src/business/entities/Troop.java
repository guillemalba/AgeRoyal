package business.entities;

import business.GameManager;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

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
    private Color color;
    private BufferedImage image;




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

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
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



    public Troop enemyNear() {
        for (int i = this.posx - this.range; i <= this.posx + this.range; i++) {
            for (int j = this.posy - this.range; j <= this.posy + this.range; j++) {
                if (i >= 0 && j >= 0 && i <= 14 && j <= 14) {

                    if (gameManager.getBoard().getCellsMatrix()[i][j].getTroop() != null){
                        if (gameManager.getBoard().getCellsMatrix()[i][j].getTroop().isUser() && !this.isUser) {
                            Troop troop = gameManager.getBoard().getCellsMatrix()[i][j].getTroop();
                            /*System.out.println("["+this.posy+","+this.posx+"]" + " --> pos (" + troop.getPosx() + "," + troop.getPosy() + ")");*/ // TODO: elimina

                            return troop;

                        } else if (!(gameManager.getBoard().getCellsMatrix()[i][j].getTroop().isUser()) && this.isUser) {
                            Troop troop = gameManager.getBoard().getCellsMatrix()[i][j].getTroop();
                            /*System.out.println("["+this.posy+","+this.posx+"]" + " --> pos (" + troop.getPosx() + "," + troop.getPosy() + ")");*/ // TODO: elimina
                            return troop;
                        }
                    }
                }
            }
        }

        return null;
    }

    public void atack(Troop enemyTroop){


        while(enemyTroop.getLife() > 0 && !stop){

            //if(enemyTroop != enemyNear()) enemyTroop = enemyNear();

            System.out.println("Soy"+ name + "voy a pegar a " +enemyTroop.getName());

            try {
                Thread.sleep(attackVelocity);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (Troop.class) {
                if(enemyTroop.getLife() > 0.0){

                    enemyTroop.setLife(enemyTroop.getLife() - getDamage());
                    System.out.println(name+" "+" pega a "+enemyTroop.name+" le deja con " +enemyTroop.getLife());
                }
            }



        }
        if(!stop) {
            System.out.println(name + "Mata a " + enemyTroop.name);

            enemyTroop.setStop(true);

        }


    }

    public void dieTroop(Troop troop){
        gameManager.getBoard().removeTroopBoard(troop);
    }

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

    public void stopGame(boolean isUser){
        gameManager.stopGame(isUser,false);
    }




}

