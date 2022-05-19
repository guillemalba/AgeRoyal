package presentation.controllers;

import presentation.views.MainMenuView;
import presentation.views.RecordedGameMenuView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuController implements ActionListener {
    private MainMenuView mainMenuView;

    public MainMenuController(MainMenuView mainMenuView) {
        this.mainMenuView = mainMenuView;
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "settings":
                mainMenuView.setVisible(false);
                break;
            case "play_game":
                break;
            case "raking":
                break;
            case "game_graphics":
                break;
            case "game_recording":
                break;
        }
    }
}
