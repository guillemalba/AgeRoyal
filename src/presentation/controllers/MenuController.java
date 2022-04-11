package presentation.controllers;

import business.UserManager;
import presentation.views.MainView;
import presentation.views.MenuView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.cert.CertPathValidatorException;

public class MenuController implements ActionListener {

    public MenuView menuView;
    private MainView mainView;
    private CardLayout viewComponents;
    private UserManager userManager;

    public MenuController(MenuView menuView, MainView mainView, CardLayout viewComponents, UserManager userManager) {
        this.menuView = menuView;
        this.mainView = mainView;
        this.viewComponents = viewComponents;
        this.userManager = userManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case MenuView.BTN_LOGOUT :
                menuView.setMainView(mainView);
                menuView.setViewComponents(viewComponents);
                menuView.showLogout();
            break;
        }
    }
}
