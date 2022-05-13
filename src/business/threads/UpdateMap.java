package business.threads;

public class UpdateMap implements Runnable{

    private String[][] mapa;

    public UpdateMap(String[][] mapa) {
        this.mapa = mapa;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            drawMap();
        }
    }

    public void drawMap() {
        System.out.println();
        for(int i =0; i < mapa.length;i++){
            System.out.println();
            for(int j = 0; j < mapa.length;j++){
                System.out.print((mapa[i][j]));
                System.out.print(" ");
            }
        }
    }
}
