package presentation.controllers;

import business.GameManager;
import business.entities.Game;
import presentation.views.MainMenuView;
import presentation.views.MainView;
import presentation.views.RecordedGameMenuView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class RecordedGameMenuController implements ActionListener {
    private RecordedGameMenuView recordedGameMenuView;
    private MainView mainView;
    private GameManager gameManager;

    public RecordedGameMenuController(RecordedGameMenuView recordedGameMenuView, MainView mainView, GameManager gameManager) {
        this.recordedGameMenuView = recordedGameMenuView;
        this.mainView = mainView;
        this.gameManager = gameManager;
        updateRecordedGame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "settings":
                mainView.showSettings();
                break;
            case "back":
                mainView.showMenu();
                break;
        }
    }

    public void updateRecordedGame(){
        recordedGameMenuView.update(gameManager.updateGames());
    }
}
