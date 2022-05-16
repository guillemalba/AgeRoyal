package presentation.controllers;


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



    public GameViewController (GameView gameView, MainView mainView){
        this.gameView = gameView;
        this.mainView = mainView;
    }

    public GameViewController() {
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
        if(e.getComponent().getName().equals("offT1") || e.getComponent().getName().equals("offT2") || e.getComponent().getName().equals("defT1") || e.getComponent().getName().equals("defT2")){
            e.getComponent().setBackground(Color.lightGray);
        } else {
            e.getComponent().setBackground(Color.cyan);
            int x = getPositionX(e.getComponent().getName());
            int y = getPositionY(e.getComponent().getName());

            System.out.println("Position pressed: x -> "+x+" y -> "+y);
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
            e.getComponent().setBackground(Color.GRAY);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getComponent().getName().equals("offT1") || e.getComponent().getName().equals("defT1")){
            e.getComponent().setBackground(Color.green);
        }else if(e.getComponent().getName().equals("offT2") || e.getComponent().getName().equals("defT2")){
            e.getComponent().setBackground(Color.pink);
        }
        else {
            e.getComponent().setBackground(Color.WHITE);
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
}
