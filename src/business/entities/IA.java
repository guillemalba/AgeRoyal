package business.entities;

import business.GameManager;

/**
 * Clase de la IA que simula la partida de la maquina
 */
public class IA implements Runnable{
    private int time = 0;
    private int money = 5;
    private int numTroopsAlive = 0;
    private int lifes = 0;
    private boolean stop = false;

    private GameManager gameManager;
    private int gameTime;

    /**
     * Constructor de la IA con el manager del juego y el timer de la partida
     *
     * @param gameManager del juego
     * @param gameTime de la partida
     */
    public IA(GameManager gameManager, int gameTime) {
        this.gameManager = gameManager;
        this.gameTime = gameTime;
    }

    @Override
    public void run() {
        while (!stop) {

            if (time == 4) {

                invokeOfensiveTroop();
                time = 0;
            }

            invokeDefensiveTroop();


            try {
                long sleepTime = 1000;
                Thread.sleep(sleepTime);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            /*System.out.println("IA --> " + gameManager.getTime());*/
            time++;
        }
    }

    /**
     * Metodo que intenta invocar una tropa ofensiva en el mapa
     */
    public void invokeOfensiveTroop() {
        int maxX = 7;
        int maxY = 14;
        int newPosX;
        int newPosY;

        boolean leave = false;
        while (!leave) {
            newPosX = (int) (Math.random() * maxX);
            newPosY = (int) (Math.random() * maxY) + 1;
            if (gameManager.getBoard().getCellsMatrix()[newPosX][newPosY].getTroop() == null) {
                int rand = (int)(Math.random() * 2);
                if (rand == 0) {
                    if (this.money >= Attributes.ARCHER_COST.getValue()) {
                        gameManager.addTroop(Attributes.ARCHER_ID, newPosX, newPosY, false, "ia_archer");

                    }
                } else {
                    if (this.money >= Attributes.GIANT_COST.getValue()) {
                        gameManager.addTroop(Attributes.GIANT_ID, newPosX, newPosY, false, "ia_giant");

                    }
                }

                leave = true;
            }
        }


    }

    /**
     * Metodo que intenta invocar una tropa defensiva en el mapa
     */
    public void invokeDefensiveTroop() {
        int maxX = 7;
        int maxY = 14;
        int newPosX;
        int newPosY;
        int enemyPosX = findNearestTroop();

        boolean leave = false;
        while (!leave) {
            if (enemyPosX == -1) {
                newPosX = (int) (Math.random() * maxX);
            } else if (enemyPosX != 0) {
                newPosX = (int) (Math.random() * enemyPosX -1);
            } else {
                newPosX = (int) (Math.random() * enemyPosX);
            }
            newPosY = (int) (Math.random() * maxY) + 1;
            if (gameManager.getBoard().getCellsMatrix()[newPosX][newPosY].getTroop() == null) {
                int rand = (int)(Math.random() * 2);
                if (rand == 0) {
                    if (this.money >= Attributes.CANNON_COST.getValue()) {
                        gameManager.addTroop(Attributes.CANNON_ID, newPosX, newPosY, false, "ia_cannon");

                    }
                } else {
                    if (this.money >= Attributes.TESLA_COST.getValue()) {
                        gameManager.addTroop(Attributes.TESLA_ID, newPosX, newPosY, false, "ia_tesla");

                    }
                }

                leave = true;
            }
        }

    }

    /**
     * Metodo que encuentra la tropa del usuario que este mas cerca a la base de la IA
     *
     * @return posicion x (vertical) de la tropa, devuelve -1 si no ha encontrado tropa
     */
    public int findNearestTroop() {

        int maxX = 7;
        int maxY = 14;

        for (int x = 0; x < maxX; x++) {
            for (int y = 0; y < maxY; y++) {
                Troop enemyTroop = gameManager.getBoard().getCellsMatrix()[x][y].getTroop();
                if (enemyTroop != null) {
                    if (enemyTroop.isUser()) {
                        return enemyTroop.getPosx();
                    }
                }
            }
        }

        return -1;
    }

    /**
     * Getter para devolver el dinero
     *
     * @return el dinero
     */
    public int getMoney() {
        return money;
    }

    /**
     * Setter para actualizar el dinero
     *
     * @param money a actualizar
     */
    public void setMoney(int money) {
        this.money = money;
    }

    /**
     * Getter para devolver el numero de tropas vivas que hay en el mapa
     *
     * @return numero de tropas vivas
     */
    public int getNumTroopsAlive() {
        return numTroopsAlive;
    }

    /**
     * Setter para actualizar el numero de tropas vivas en el mapa
     *
     * @param numTroopsAlive tropas vivas
     */
    public void setNumTroopsAlive(int numTroopsAlive) {
        this.numTroopsAlive = numTroopsAlive;
    }


    /**
     * Setter para detener el thread
     *
     * @param stop
     */
    public void setStop(boolean stop) {
        this.stop = stop;
    }
}
