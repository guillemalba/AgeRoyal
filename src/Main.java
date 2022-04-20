import business.UserManager;
import persistence.UserSQLDAO;
import presentation.controllers.*;
import presentation.views.*;

import java.awt.*;


public class Main {
    public static void main(String[] args) {
        MainMenuView mainMenuView = new MainMenuView();
        MainMenuController mainMenuController = new MainMenuController(mainMenuView);
        mainMenuView.mainController(mainMenuController);

        CardLayout viewComponents = new CardLayout();

        UserManager userManager = new UserManager();

        RegisterView registerView = new RegisterView();

        LoginView loginView = new LoginView();

        LogoutView logoutView = new LogoutView();

        MenuView menuView = new MenuView();

        MainView mainView = new MainView(viewComponents, registerView, loginView, logoutView, menuView);

        LoginController loginController = new LoginController(loginView, mainView, viewComponents, userManager);
        loginView.loginController(loginController);

        RegisterController registerController = new RegisterController(registerView, mainView, viewComponents,userManager);
        registerView.registerController(registerController);

        LogoutController logoutController = new LogoutController(logoutView, mainView, viewComponents,userManager);
        logoutView.registerController(logoutController);

        MenuController menuController = new MenuController(menuView, mainView, viewComponents,userManager);
        menuView.registerActionListener(menuController);

        mainView.start();
    }
    
}







