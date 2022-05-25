package presentation.controllers;


import business.GameManager;
import business.entities.*;
import com.sun.tools.javac.Main;
import presentation.views.GameView;
import presentation.views.MainView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class GameViewController implements ActionListener, MouseListener {
    private GameView gameView;
    private MainView mainView;
    private GameManager gameManager;
    private Troop selectedT;
    private int x,y;
    private String tipo;

    public GameViewController (GameView gameView, MainView mainView, GameManager gameManager){
        this.gameView = gameView;
        this.mainView = mainView;
        this.gameManager = gameManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Settings":
                mainView.showSettings();
            break;
            case "Back":
                gameManager.stopGame();

            break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getComponent().getName().equals("offT1") || e.getComponent().getName().equals("offT2") || e.getComponent().getName().equals("defT1") || e.getComponent().getName().equals("defT2") ){
            switch(e.getComponent().getName()){
                case "offT1":
                    tipo = "archer";


                    break;

                case "offT2":
                    tipo = "giant";

                    break;

                case "defT1":
                    tipo = "canon";

                    break;

                case "defT2":
                    tipo = "tesla";

                    break;

                default:
                    System.out.println("hola");
                    break;
            }
        }else{
            int x = getPositionX(e.getComponent().getName());
            int y = getPositionY(e.getComponent().getName());
            if(x > 7) {
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
                }

            }else{
                System.out.println("Tira en tu mitad bro");
            }
        }


    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getComponent().getName().equals("offT1") || e.getComponent().getName().equals("offT2") || e.getComponent().getName().equals("defT1") || e.getComponent().getName().equals("defT2") ) {
            switch (e.getComponent().getName()) {
                case "offT1":

                    e.getComponent().setBackground(Color.GRAY);

                    break;

                case "offT2":

                    e.getComponent().setBackground(Color.GRAY);
                    break;

                case "defT1":

                    e.getComponent().setBackground(Color.GRAY);
                    break;

                case "defT2":

                    e.getComponent().setBackground(Color.GRAY);
                    break;

                default:
                    System.out.println("hola");
                    break;
            }

        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getComponent().getName().equals("offT1") || e.getComponent().getName().equals("offT2") || e.getComponent().getName().equals("defT1") || e.getComponent().getName().equals("defT2") ) {
            switch (e.getComponent().getName()) {
                case "offT1":

                    e.getComponent().setBackground(Color.YELLOW);

                    break;

                case "offT2":

                    e.getComponent().setBackground(Color.BLUE);
                    break;

                case "defT1":

                    e.getComponent().setBackground(Color.BLACK);
                    break;

                case "defT2":

                    e.getComponent().setBackground(Color.ORANGE);
                    break;

                default:
                    System.out.println("hola");
                    break;
            }

        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        /*if(e.getComponent().getName().equals("offT1") || e.getComponent().getName().equals("offT2") || e.getComponent().getName().equals("defT1") || e.getComponent().getName().equals("defT2")){
            e.getComponent().setBackground(Color.lightGray);
        } else {
            e.getComponent().setBackground(Color.GRAY);
        }*/
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

    private int getPositionX(String name){
        String[] positions = name.split(",");
        return Integer.parseInt(String.valueOf(positions[0]));
    }

    private int getPositionY(String name){
        String[] positions = name.split(",");
        return Integer.parseInt(String.valueOf(positions[1]));
    }

    public void addTroop(Board board,int moneyUser) {
        gameView.updateView(board,moneyUser);

    }


    public void finishGame(){
        mainView.showMenu();
    }
}
