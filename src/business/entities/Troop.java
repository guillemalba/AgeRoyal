package business.entities;

import business.GameManager;
import business.threads.TroopMovement;

import java.awt.*;

public class Troop implements Runnable{

    private boolean isUser;
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


    public Troop(int posx, int posy, GameManager gameManager, boolean isUser) {

        this.posx = posx;
        this.posy = posy;
        this.gameManager = gameManager;
        this.isUser = isUser;
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

    public boolean isUser() {
        return isUser;
    }

    public void setUser(boolean user) {
        isUser = user;
    }

    @Override
    public void run() {

        if(enemyNear()) {
            //attack();
        }

    }


    public void tropMove(String name){
        movement.moveTroop(name);
    }





    public void move() {

        if(!isUser) {

            gameManager.getBoard().removeTroopBoard(this);
            int auxI = getPosx();
            int auxJ = getPosy();

            if (auxJ > 7 && auxJ <= 15) {
                auxJ--;
                auxI++;
            } else if (auxJ < 7 && auxJ >= 0) {
                auxJ++;
                auxI++;
            } else {
                auxI++;
            }
            /*
            *  else if (mapa[auxI+1][auxJ].equals("|")) {
                auxI++;
            } else if (mapa[auxI+1][auxJ--].equals("|")) {
                auxI++;
                auxJ--;
            } else if (mapa[auxI+1][auxJ++].equals("|")) {
                auxI++;
                auxJ--;
            }*/
            setPosy(auxJ);
            setPosx(auxI);
            gameManager.getBoard().setTroopBoard(this);
        }


    }



    public boolean enemyNear() {
        for (int i = this.posx - this.range; i < this.posx + this.range; i++) {
            /*System.out.println("next");*/
            for (int j = this.posy - this.range; j < this.posx + this.range; j++) {
                if (i >= 0 && j >= 0 && i <= 14 && j <= 14) {
                    /*System.out.println("i = " + i +" --> j = " + j);*/
                    if (gameManager.getBoard().getCellsMatrix()[i][j].getTroop() != null){
                        if (gameManager.getBoard().getCellsMatrix()[i][j].getTroop().isUser()) {
                            System.out.println("isHere");
                        }
                    }
                }
                /*Troop posibleEnemy = gameManager.getBoard().getCellsMatrix()[i][j].getTroop();*/
                /*if (gameManager.getBoard().getCellsMatrix()[i][j].getTroop() != null){
                    if (gameManager.getBoard().getCellsMatrix()[i][j].getTroop().isUser()) {

                    }
                }*/
            }
        }


        /*//mirar dreta(U) / esquerra(M)
        if(esPotAtacar(rang_accio, 0)) {
            return true;
            setRival(getPartidaManager().getTaulell().getFitxaCasella(getPosx() + rang_accio, getPosy()));
            //rival.setRival(this);

            //mirar esquerra
        } else if(esPotAtacar(-rang_accio, 0)){
            return true;
            setRival(getPartidaManager().getTaulell().getFitxaCasella(getPosX() - rang_accio, getPosY()));
            //rival.setRival(this);

            //mirar endavant
        } else if(esPotAtacar(0, rang_accio)){
            return true;
            setRival(getPartidaManager().getTaulell().getFitxaCasella(getPosX(), getPosY() + rang_accio));
            //rival.setRival(this);
        }*/

        return false;
    }



    public boolean canMove() {

        if(gameManager.getBoard().isOnTheEdge(getPosx()+1,getPosy()) && gameManager.getBoard().isEmpty(getPosx()+1,getPosy())) return true;

        return false;
    }

   /*

   public void attack() {
        int damage = getAtaque() / getRival().getDefensa();
        if (rival.getNom().equals("Base")){
            pm.baseAtacada(damage, usuari);
        } else {
            getRival().setVida(getRival().getVida() - (damage * 4));
        }
    }

    public boolean enemyNear() {
        boolean enemic = false;
        int rang_accio;

        if (this.usuari) {
            rang_accio = -this.rangAccio;
        } else {
            rang_accio = this.rangAccio;
        }

        //mirar dreta(U) / esquerra(M)
        if(esPotAtacar(rang_accio, 0)) {
            enemic = true;
            setRival(getPartidaManager().getTaulell().getFitxaCasella(getPosx() + rang_accio, getPosy()));
            //rival.setRival(this);

            //mirar esquerra
        } else if(esPotAtacar(-rang_accio, 0)){
            enemic = true;
            setRival(getPartidaManager().getTaulell().getFitxaCasella(getPosX() - rang_accio, getPosY()));
            //rival.setRival(this);

            //mirar endavant
        } else if(esPotAtacar(0, rang_accio)){
            enemic = true;
            setRival(getPartidaManager().getTaulell().getFitxaCasella(getPosX(), getPosY() + rang_accio));
            //rival.setRival(this);
        }

        return enemic;
    }


    private boolean checkBoardLimits(int rangAccioX, int rangAccioY){
        return getPartidaManager().getTaulell().inTheLimit(getPosX() + rangAccioX, getPosY() + rangAccioY);
    }


    private boolean cellIsEmpty(int rangAccioX, int rangAccioY){
        return getPartidaManager().getTaulell().getFitxaCasella(getPosX() + rangAccioX, getPosY() + rangAccioY) != null;
    }


    private boolean isEnemy(int rangAccioX, int rangAccioY){
        return getPartidaManager().getTaulell().getFitxaCasella(getPosX() + rangAccioX, getPosY() + rangAccioY).isUsuari() != usuari;
    }


    private boolean canAttack(int rangAccioX, int rangAccioY){
        if (comprovarLimit(rangAccioX, rangAccioY) && comprovarSiHiHaAlgu(rangAccioX, rangAccioY) && comprovarSiEsEnemic(rangAccioX, rangAccioY)){
            return true;
        }
        return false;
    }






    public String checkMove(int movel, int fila, int columna, String[][] mapa) {
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

