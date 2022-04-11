package presentation.controllers;

import business.UserManager;
import business.entities.User;
import presentation.views.LoginView;
import presentation.views.MainView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController implements ActionListener {
    private UserManager userManager = new UserManager();
    private LoginView loginView;
    private MainView mainView;
    private CardLayout viewComponents;

    public LoginController(LoginView loginView, MainView mainView, CardLayout viewComponents) {
        this.loginView = loginView;
        this.mainView = mainView;
        this.viewComponents = viewComponents;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case LoginView.BTN_LOG:
                String userNameEmail;
                String password;
                userNameEmail = loginView.getInputUsernameEmail();
                password = String.valueOf(loginView.getInputPassword());
                User user = new User(userNameEmail, userNameEmail, password);
                if (userManager.login(user)) {
                    userManager.login(user);
                    System.out.println(user.getName() + " login successful");
                } else {
                    loginView.errorMessage();
                }
                loginView.setMainView(mainView);
                loginView.setComponents(viewComponents);
                loginView.showMenu();
            break;
            case LoginView.BTN_REG:
                loginView.setMainView(mainView);
                loginView.setComponents(viewComponents);
                loginView.showRegister();
            break;
        }
    }
}
