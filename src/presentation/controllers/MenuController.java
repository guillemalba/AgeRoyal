package presentation.controllers;

import business.GameManager;
import business.UserManager;
import presentation.views.GameView;
import presentation.views.MainView;
import presentation.views.MenuView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController implements ActionListener {

    private MenuView menuView;
    private MainView mainView;
    private CardLayout viewComponents;
    private UserManager userManager;
    private GameManager gameManager;
    private RecordedGameMenuController recordedGameMenuController;
    private RankingController rankingController;

    public MenuController(MenuView menuView, MainView mainView, CardLayout viewComponents, UserManager userManager,GameManager gameManager, RecordedGameMenuController recordedGameMenuController, RankingController rankingController) {
        this.menuView = menuView;
        this.mainView = mainView;
        this.viewComponents = viewComponents;
        this.userManager = userManager;
        this.gameManager = gameManager;
        this.recordedGameMenuController = recordedGameMenuController;
        this.rankingController = rankingController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case MenuView.BTN_LOGOUT :
                menuView.setMainView(mainView);
                menuView.setViewComponents(viewComponents);
                mainView.showLogout();
            break;
            case "play_game":

                gameManager.initGame();
                mainView.showGameView();
                break;
            case "ranking":
                rankingController.updateRecorderUsers();
                mainView.showRanking();
                break;
            case "game_graphics":
                break;
            case "game_recording":
                recordedGameMenuController.updateRecordedGame();
                mainView.showRecordedGame();
                //menuView.setVisible(false);
                break;
        }
    }
}
