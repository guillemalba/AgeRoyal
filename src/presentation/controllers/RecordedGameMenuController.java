package presentation.controllers;

import presentation.views.MainMenuView;
import presentation.views.RecordedGameMenuView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecordedGameMenuController implements ActionListener {
    private RecordedGameMenuView recordedGameMenuView;

    public RecordedGameMenuController(RecordedGameMenuView recordedGameMenuView) {
        this.recordedGameMenuView = recordedGameMenuView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "settings":
                break;
            case "back":
                recordedGameMenuView.setVisible(false);
                MainMenuView mainMenuView = new MainMenuView();
                MainMenuController mainMenuController = new MainMenuController(mainMenuView);
                mainMenuView.mainMenuController(mainMenuController);
                break;
        }
    }
}
