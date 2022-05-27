package business.entities;

import business.GameManager;

public class IA implements Runnable{
    private int time = 0;
    private int money = 5;
    private int numTroopsAlive = 0;
    private int lifes = 0;
    private boolean stop = false;


    private GameManager gameManager;
    private int gameTime;

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
                        gameManager.addTroop(Attributes.ARCHER_ID, newPosX, newPosY, gameTime, false, "ia_archer");

                    }
                } else {
                    if (this.money >= Attributes.GIANT_COST.getValue()) {
                        gameManager.addTroop(Attributes.GIANT_ID, newPosX, newPosY, gameTime, false, "ia_giant");

                    }
                }

                leave = true;
            }
        }


    }

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
                        gameManager.addTroop(Attributes.CANNON_ID, newPosX, newPosY, gameTime, false, "ia_cannon");

                    }
                } else {
                    if (this.money >= Attributes.TESLA_COST.getValue()) {
                        gameManager.addTroop(Attributes.TESLA_ID, newPosX, newPosY, gameTime, false, "ia_tesla");

                    }
                }

                leave = true;
            }
        }

    }

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

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getNumTroopsAlive() {
        return numTroopsAlive;
    }

    public void setNumTroopsAlive(int numTroopsAlive) {
        this.numTroopsAlive = numTroopsAlive;
    }

    public int getLifes() {
        return lifes;
    }

    public void setLifes(int lifes) {
        this.lifes = lifes;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }
}
