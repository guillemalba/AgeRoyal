import business.GameManager;
import business.UserManager;
import presentation.controllers.*;
import presentation.views.*;

import java.awt.*;


public class Main {
    public static void main(String[] args) {

        /**
         *
         *
         * 1- New dels DAO
         * 2- New dels Manager
         * 3- New de les vistes
         * 4- New del Mainview, o Cardlayout
         * 5- New dels Controller
         * 6- Vincular controladors
         *
         */

        GameManager gameManager = new GameManager();





        CardLayout viewComponents = new CardLayout();

        UserManager userManager = new UserManager();


        RegisterView registerView = new RegisterView();

        LoginView loginView = new LoginView();

        LogoutView logoutView = new LogoutView();

        MenuView menuView = new MenuView();

        GameView gameView = new GameView();




        MainView mainView = new MainView(viewComponents, registerView, loginView, logoutView, menuView, gameView);

        LoginController loginController = new LoginController(loginView, mainView, viewComponents, userManager);
        loginView.loginController(loginController);

        RegisterController registerController = new RegisterController(registerView, mainView, viewComponents,userManager);
        registerView.registerController(registerController);

        LogoutController logoutController = new LogoutController(logoutView, mainView, viewComponents,userManager);
        logoutView.registerController(logoutController);

        MenuController menuController = new MenuController(menuView, mainView, viewComponents,userManager,gameManager);
        menuView.registerActionListener(menuController);

        GameViewController gameViewController = new GameViewController(gameView, mainView);
        gameView.registerController(gameViewController, gameViewController);



        gameManager.registerController(gameViewController);

        //new GameManager(3000);

        mainView.start();
    }
    
}







