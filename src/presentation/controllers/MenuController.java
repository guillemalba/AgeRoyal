package presentation.controllers;

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

    public MenuController(MenuView menuView, MainView mainView, CardLayout viewComponents) {
        this.menuView = menuView;
        this.mainView = mainView;
        this.viewComponents = viewComponents;
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
