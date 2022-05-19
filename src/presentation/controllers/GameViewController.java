package presentation.controllers;


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

    private Troop selectedT;

    public GameViewController (GameView gameView, MainView mainView){
        this.gameView = gameView;
        this.mainView = mainView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Settings":
                mainView.showSettings();
            break;
            case "Back":
                mainView.showMenu();
            break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        switch(e.getComponent().getName()){
            case "offT1":
                e.getComponent().setBackground(Color.green);
                //selectedT = new Archer();//esto llama al manager
                break;

            case "offT2":
                e.getComponent().setBackground(Color.pink);
               // selectedT = new Giant();
                break;

            case "defT1":
                e.getComponent().setBackground(Color.red);
                //selectedT = new TeslaTower();
                break;

            case "defT2":
                e.getComponent().setBackground(Color.blue);
                //selectedT = new Canon();
                break;

            default:
                e.getComponent().setBackground(Color.cyan);
                int x = getPositionX(e.getComponent().getName());
                int y = getPositionY(e.getComponent().getName());
                if(selectedT == null){
                    System.out.println("Error, you have not selected a troop");
                }else{
                    System.out.println(selectedT.getClass().getSimpleName());
                    switch (selectedT.getClass().getSimpleName()){
                        case "Archer":
                            e.getComponent().setBackground(Color.green);
                            break;

                        case "Giant":
                            e.getComponent().setBackground(Color.pink);
                            break;

                        case "TeslaTower":
                            e.getComponent().setBackground(Color.red);
                            break;

                        case "Canon":
                            e.getComponent().setBackground(Color.blue);
                            break;
                    }
                    selectedT = null;
                }
                System.out.println("Position pressed: x -> "+x+" y -> "+y);
            break;
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
        if(e.getComponent().getName().equals("offT1") || e.getComponent().getName().equals("offT2") || e.getComponent().getName().equals("defT1") || e.getComponent().getName().equals("defT2")){
            //e.getComponent().setBackground(Color.lightGray);
        } else {
            //e.getComponent().setBackground(Color.GRAY);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        switch(e.getComponent().getName()){
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
        }
    }

    private int getPositionX(String name){
        String[] positions = name.split(",");
        return Integer.parseInt(String.valueOf(positions[0]));
    }

    private int getPositionY(String name){
        String[] positions = name.split(",");
        return Integer.parseInt(String.valueOf(positions[1]));
    }

    public void addTroop(Board board) {
        //gameView = new GameView();
        gameView.updateView(board);
    }
}
