package business.entities;

import business.GameManager;

import java.awt.*;

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




    public Troop(String name,int posx, int posy, GameManager gameManager, boolean isUser,boolean stop) {

        this.name = name;
        this.posx = posx;
        this.posy = posy;
        this.gameManager = gameManager;
        this.isUser = isUser;
        this.stop = stop;
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

    @Override
    public void run() {

    }



    public void move(String direction) {

        gameManager.getBoard().removeTroopBoard(this);
        int auxX = getPosx();
        int auxY = getPosy();

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

        return null;
    }

    public void atack(Troop enemyTroop){

        while(enemyNear().getLife() > 0 && !stop){

            try {
                Thread.sleep(attackVelocity);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(enemyTroop.getLife() > 0.0){
                enemyTroop.setLife(enemyTroop.getLife() - getDamage());
                System.out.println(name+" "+" pega a "+enemyTroop.name+" le deja con " +enemyTroop.getLife());
            }else{
                System.out.println(name + "Mata a "+enemyTroop.name);
                enemyTroop.setStop(true);
            }

        }

        System.out.println("Soy "+ name+ " salgo de matar a "+ enemyTroop.name);

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

    public void stopGame(){
        gameManager.stopGame();
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
    public void atack(){
        enemyTroop = enemyNear();
        while(enemyNear() != null){
            System.out.println("te meto cerdo");
            while(enemyTroop.getLife()-getDamage() >= 0){
                enemyTroop.setLife(enemyTroop.getLife() - getDamage());
            }

        }
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

