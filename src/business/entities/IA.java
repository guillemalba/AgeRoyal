package business.entities;

import business.GameManager;

public class IA implements Runnable{
    private int time = 0;

    private GameManager gameManager;

    public IA(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @Override
    public void run() {
        while (true) {

            if (time == 4) {
                invokeOfensiveTroop();
                System.out.println("->intenta ofensiva");
                time = 0;
            }

            //invokeDefensiveTroop();
            /*System.out.println("////...intenta defensiva");*/

            try {
                long sleepTime = 1000;
                Thread.sleep(sleepTime);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            time++;
        }
    }


    public void invokeOfensiveTroop() {
        int maxX = 7;
        int maxY = 14;
        int newPosX;
        int newPosY;

        do{
            newPosX = (int) (Math.random() * maxX);
            newPosY = (int) (Math.random() * maxY) + 1;
        }while(gameManager.getBoard().getCellsMatrix()[newPosX][newPosY].getTroop() != null);

        /*if (hasMoney()) {
        }*/
            int rand = (int)(Math.random() * 2);
            System.out.println("x = " + newPosX + "   y = " + newPosY);
            if (rand == 0) {
                gameManager.addTroop(Ids.ARCHER, newPosX, newPosY);
            } else {
                gameManager.addTroop(Ids.GIANT, newPosX, newPosY);
            }

    }

    /*private boolean hasMoney() {

    }*/

    public void invokeDefensiveTroop() {

    }
}
