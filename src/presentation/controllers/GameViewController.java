package presentation.controllers;


import com.sun.tools.javac.Main;
import presentation.views.GameView;
import presentation.views.MainView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameViewController implements ActionListener {
    private GameView gameView;
    private MainView mainView;


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
}
