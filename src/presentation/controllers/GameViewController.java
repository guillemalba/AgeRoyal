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

        System.out.println("HEHEHEHE");
        JPanel jpanel = (JPanel) e.getSource();

        jpanel.setBackground(Color.BLUE);
        if (jpanel.getName().equals("offT2")) {
            System.out.println("Algo="+jpanel.getName());
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

    }
}
