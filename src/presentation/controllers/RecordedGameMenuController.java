package presentation.controllers;

import presentation.views.MainMenuView;
import presentation.views.MainView;
import presentation.views.RecordedGameMenuView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecordedGameMenuController implements ActionListener {
    private RecordedGameMenuView recordedGameMenuView;
    private MainView mainView;

    public RecordedGameMenuController(RecordedGameMenuView recordedGameMenuView, MainView mainView) {
        this.recordedGameMenuView = recordedGameMenuView;
        this.mainView = mainView;
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
}
