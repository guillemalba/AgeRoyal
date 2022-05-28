package presentation.controllers;

import business.UserManager;
import business.entities.User;
import presentation.views.LoginView;
import presentation.views.MainView;
import javax.swing.JOptionPane;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Esta clase es el controlador de nuestra vista de inicio de sesión
 */
public class LoginController implements ActionListener {
    private UserManager userManager;
    private LoginView loginView;
    private MainView mainView;
    private CardLayout viewComponents;

    /**
     * Este es el constructor de nuestra clase al cual le pasaremos todos los objeto que necesitamos para que funcione
     * @param loginView es la vista que queremos controlar
     * @param mainView es la ventana inicial de nuestra vista
     * @param viewComponents estos son los componentes de tipo cardlayout de nuestra ventana inicial
     * @param userManager este es el manager de nuestros usuarios
     */
    public LoginController(LoginView loginView, MainView mainView, CardLayout viewComponents, UserManager userManager) {
        this.loginView = loginView;
        this.mainView = mainView;
        this.viewComponents = viewComponents;
        this.userManager = userManager;
    }

    /**
     * Este es el metodo en el que asignatremos lo que queremos que haga cada boton
     * @param e es el objeto asignado al boton presionado
     */
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
                    userManager.setUser(user.getName());//Registrar user en la ram


                } else {
                    /*loginView.errorMessage();*/
                }
                // TODO move into if condition
                loginView.resetInputInfo();
                loginView.setMainView(mainView);
                loginView.setComponents(viewComponents);
                mainView.showMenu();

            break;
            case LoginView.BTN_REG:
                loginView.resetInputInfo();
                loginView.setMainView(mainView);
                loginView.setComponents(viewComponents);
                mainView.showRegister();
            break;
        }
    }
}
