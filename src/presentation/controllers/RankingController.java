package presentation.controllers;

import business.UserManager;
import presentation.views.MainView;
import presentation.views.RankingView;
import presentation.views.RecordedGameMenuView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RankingController implements ActionListener {
    private RankingView rankingView;
    private MainView mainView;
    private UserManager userManager;

    public RankingController(RankingView rankingView, MainView mainView, UserManager userManager) {
        this.rankingView = rankingView;
        this.mainView = mainView;
        this.userManager = userManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "settings":
                mainView.showSettings();
                break;
            case "back":
                mainView.showMenu();
                break;
        }
    }

    public void updateRecorderUsers(){
        rankingView.update(userManager.updateUsers());
    }
}
