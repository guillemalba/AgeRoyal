package presentation.controllers;


import business.GameManager;
import business.entities.*;

import presentation.views.GameView;
import presentation.views.MainView;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Classe que controla toda la vista del juego
 */
public class GameViewController implements ActionListener, MouseListener {
    private GameView gameView;
    private MainView mainView;
    private GameManager gameManager;
    private boolean pause = true;

    private String tipo = "null";

    /**
     * Constructor con la vista del juego, la main view y el manager del juego
     *
     * @param gameView vista del juego
     * @param mainView vista principal
     * @param gameManager manager de la partida
     */
    public GameViewController (GameView gameView, MainView mainView, GameManager gameManager){
        this.gameView = gameView;
        this.mainView = mainView;
        this.gameManager = gameManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {

            case "Settings":
                if(!gameView.isRepro()) {
                    gameManager.stopGame(false, false);
                    mainView.showLogout();
                }
                if(gameView.isRepro()){
                    if(pause) {

                        gameManager.pauseRepro(pause);
                        pause = false;
                    }else{
                        gameManager.pauseRepro(pause);
                        pause = true;
                    }

                }
            break;
            case "Back":
                gameManager.stopGame(false,false);
                mainView.showMenu();
            break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(!gameView.isRepro()) {
            if (e.getComponent().getName().equals("offT1") || e.getComponent().getName().equals("offT2") || e.getComponent().getName().equals("defT1") || e.getComponent().getName().equals("defT2")) {
                switch (e.getComponent().getName()) {
                    case "offT1":

                        tipo = "archer";

                        gameView.putBorder(e.getComponent().getName());

                        break;

                    case "offT2":
                        tipo = "giant";
                        gameView.putBorder(e.getComponent().getName());

                        break;

                    case "defT1":
                        tipo = "canon";
                        gameView.putBorder(e.getComponent().getName());

                        break;

                    case "defT2":
                        tipo = "tesla";
                        gameView.putBorder(e.getComponent().getName());

                        break;

                    default:
                        tipo = "null";
                        System.out.println("hola");
                        break;
                }
            } else {
                int x = getPositionX(e.getComponent().getName());
                int y = getPositionY(e.getComponent().getName());
                if (x > 7) {
                    switch (tipo) {
                        case "archer":

                            gameManager.posTroop(Attributes.ARCHER_ID, x, y);

                            break;
                        case "giant":

                            gameManager.posTroop(Attributes.GIANT_ID, x, y);

                            break;
                        case "canon":

                            gameManager.posTroop(Attributes.CANNON_ID, x, y);

                            break;
                        case "tesla":
                            gameManager.posTroop(Attributes.TESLA_ID, x, y);

                            break;
                        default:
                            System.out.println("Default peta igual");
                            break;
                    }

                } else {
                    System.out.println("Tira en tu mitad bro");
                }
            }
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {


    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
        /*switch(e.getComponent().getName()){
            case "offT1":
                e.getComponent().setBackground(Color.green);
                //selectedT = new Archer();
                break;

            case "offT2":
                e.getComponent().setBackground(Color.pink);
                //selectedT = new Giant();
                break;

            case "defT1":
                e.getComponent().setBackground(Color.red);
                //selectedT = new TeslaTower();
                break;

            case "defT2":
                e.getComponent().setBackground(Color.blue);
               // selectedT = new Canon();
                break;

            default:
                if (selectedT == null) {
                    e.getComponent().setBackground(Color.WHITE);
                }
            break;
        }*/
    }

    /**
     * getter de la posicion X
     *
     * @param name asignado a la casilla, ejemplo... "3,5"
     * @return la posicion X
     */
    private int getPositionX(String name){
        String[] positions = name.split(",");
        return Integer.parseInt(String.valueOf(positions[0]));
    }

    /**
     * getter de la posicion Y
     *
     * @param name asignado a la casilla, ejemplo... "3,5"
     * @return la posicion Y
     */
    private int getPositionY(String name){
        String[] positions = name.split(",");
        return Integer.parseInt(String.valueOf(positions[1]));
    }

    /**
     * Metodo para actualizar una tropa en el mapa, el dinero del jugador y las vidas de la IA y el jugador
     *
     * @param board mapa
     * @param moneyUser dinero
     * @param vidasUser vidas user
     * @param vidasIA vidas IA
     */
    public void addTroop(Board board,int moneyUser,float vidasUser,float vidasIA,int tropasUser,int tropasIa) {
        SwingUtilities.invokeLater(()->gameView.updateView(board,moneyUser,vidasUser,vidasIA,tropasUser,tropasIa));
    }

    /**
     * Metodo que te pregunta por el nombre de la partida
     *
     * @return null si le ha dado a cancelar, sino, devuelve el nombre de la partida
     */
    public String askForGameName(boolean userWins){
        return gameView.popUpSaveGame(userWins);
    }

    /**
     * Metodo que muestra el menu principal o el menu de las partidas guardadas en funcion de si ha terminado una partida o una grabacion de partida
     *
     * @param isRepro si es true, muestra el menu de las partidas guardadas, sino el menu principal
     */
    public void finishGame(boolean isRepro){
        if (isRepro) mainView.showRecordedGame();
        if(!isRepro)mainView.showMenu();

    }
}
