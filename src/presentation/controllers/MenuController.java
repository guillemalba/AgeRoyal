package presentation.controllers;

import business.GameManager;
import business.UserManager;
import presentation.views.GameView;
import presentation.views.MainView;
import presentation.views.MenuView;
import presentation.views.RecordedGameView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController implements ActionListener {

    public MenuView menuView;
    private MainView mainView;
    private CardLayout viewComponents;
    private UserManager userManager;
    private GameManager gameManager;

    public MenuController(MenuView menuView, MainView mainView, CardLayout viewComponents, UserManager userManager,GameManager gameManager) {
        this.menuView = menuView;
        this.mainView = mainView;
        this.viewComponents = viewComponents;
        this.userManager = userManager;
        this.gameManager = gameManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case MenuView.BTN_LOGOUT :
                menuView.setMainView(mainView);
                menuView.setViewComponents(viewComponents);
                menuView.showLogout();
            break;
            case "play_game":

                GameView gameView = new GameView(new GameViewController(),gameManager.getBoard());
                mainView.showGameView();

                break;
            case "raking":
                break;
            case "game_graphics":
                break;
            case "game_recording":
                menuView.setVisible(false);
                /*RecordedGameView recordedGameView = new RecordedGameView();
                RecordedGameMenuController recordedGameMenuController = new RecordedGameMenuController(recordedGameView, mainView, viewComponents, userManager);
                recordedGameView.recordedGameMenuController(recordedGameMenuController);*/
                break;
        }
    }
}
