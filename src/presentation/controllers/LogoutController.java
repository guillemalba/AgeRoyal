package presentation.controllers;

import business.UserManager;
import presentation.views.LoginView;
import presentation.views.LogoutView;
import presentation.views.MainView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogoutController implements ActionListener {
    private UserManager userManager;
    private LogoutView logoutView;
    private MainView mainView;
    private CardLayout viewComponents;

    public LogoutController(LogoutView logoutView, MainView mainView, CardLayout viewComponents, UserManager userManager) {
        this.logoutView = logoutView;
        this.mainView = mainView;
        this.viewComponents = viewComponents;
        this.userManager = userManager;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case LogoutView.BTN_LOGOUT:
                int option = logoutView.logout();
                if(option == 1) { //Quiero hacer logout
                    //TODO:Aqui vol fer logout
                    logoutView.setmainView(mainView);
                    logoutView.setComponents(viewComponents);
                    logoutView.showLogin();
                    userManager.setUser("");//Se puede poner asi? para vaciar la variable
                }
                if(option == 0){ //No quiero hacer logout
                    logoutView.setmainView(mainView);
                    logoutView.setComponents(viewComponents);
                    logoutView.showLogout();
                }
            break;

            case LogoutView.BTN_DEL:
                option = logoutView.delete();

                if(option == 1){ //Quiero hacer Delete
                    //TODO:Aqui vol fer delete
                    userManager.delete();
                    System.out.println("Se ha borrado bien");
                    logoutView.setmainView(mainView);
                    logoutView.setComponents(viewComponents);
                    logoutView.showLogin();//Aqui me manda al Menu
                    userManager.setUser("");//Se puede poner asi? para vaciar la variable
                }
                if(option == 0){//No quiero borrar la cuenta
                    logoutView.setmainView(mainView);
                    logoutView.setComponents(viewComponents);
                    logoutView.showLogout();//Aqui me esta mandando al menu en vez de al logout WTF?!?!?!
                }

            break;

            case LogoutView.BTN_BACK:
                logoutView.setmainView(mainView);
                logoutView.setComponents(viewComponents);
                logoutView.showMenu();
            break;

        }
    }
}
