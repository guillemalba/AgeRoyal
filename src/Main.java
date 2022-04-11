import business.UserManager;
import persistence.UserSQLDAO;
import presentation.controllers.LoginController;
import presentation.controllers.LogoutController;
import presentation.controllers.MenuController;
import presentation.controllers.RegisterController;
import presentation.views.*;

import java.awt.*;


public class Main {
    public static void main(String[] args) {

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







