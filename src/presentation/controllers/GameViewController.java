package presentation.controllers;

import presentation.views.GameView;
import presentation.views.MainView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameViewController implements ActionListener {
    private GameView gameView;
    private MainView mainView;

    public GameViewController (GameView gameView){
        this.gameView = gameView;
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
