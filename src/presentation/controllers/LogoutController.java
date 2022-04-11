package presentation.controllers;

import business.UserManager;
import presentation.views.LoginView;
import presentation.views.LogoutView;
import presentation.views.MainView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogoutController implements ActionListener {
    UserManager userManager = new UserManager();
    private LogoutView logoutView;
    private MainView mainView;
    private CardLayout viewComponents;

    public LogoutController(LogoutView logoutView, MainView mainView, CardLayout viewComponents) {
        this.logoutView = logoutView;
        this.mainView = mainView;
        this.viewComponents = viewComponents;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case LogoutView.BTN_LOGOUT:

            break;

            case LogoutView.BTN_BACK:
                logoutView.setmainView(mainView);
                logoutView.setComponents(viewComponents);
                logoutView.showLogin();
            break;

        }
    }
}
