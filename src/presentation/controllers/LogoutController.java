package presentation.controllers;

import business.UserManager;
import presentation.views.LogoutView;
import presentation.views.MainView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Esta clase es el controlador de nuestra vista de eliminacion y cerrado de sesión
 */
public class LogoutController implements ActionListener {
    private UserManager userManager;
    private LogoutView logoutView;
    private MainView mainView;
    private CardLayout viewComponents;

    /**
     * Este es el constructor de nuestra clase al cual le pasaremos todos los objeto que necesitamos para que funcione
     * @param logoutView es la vista que queremos controlar
     * @param mainView es la ventana inicial de nuestra vista
     * @param viewComponents estos son los componentes de tipo cardlayout de nuestra ventana inicial
     * @param userManager este es el manager de nuestros usuarios
     */
    public LogoutController(LogoutView logoutView, MainView mainView, CardLayout viewComponents, UserManager userManager) {
        this.logoutView = logoutView;
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
        switch (e.getActionCommand()){
            case LogoutView.BTN_LOGOUT:
                int option = logoutView.logout();
                if(option == 1) { //Quiero hacer logout
                    logoutView.setmainView(mainView);
                    logoutView.setComponents(viewComponents);
                    mainView.showLogin();
                    userManager.setUser("");
                }
                if(option == 0){ //No quiero hacer logout
                    logoutView.setmainView(mainView);
                    logoutView.setComponents(viewComponents);
                    mainView.showLogout();
                }
            break;

            case LogoutView.BTN_DEL:
                option = logoutView.delete();

                if(option == 1){ //Quiero hacer Delete
                    //TODO:Aqui vol fer delete
                    userManager.deleteAllGames();
                    userManager.delete();
                    mainView.showMessage("Your user has been deleted");
                    logoutView.setmainView(mainView);
                    logoutView.setComponents(viewComponents);
                    mainView.showLogin();
                    userManager.setUser("");
                }
                if(option == 0){//No quiero borrar la cuenta
                    logoutView.setmainView(mainView);
                    logoutView.setComponents(viewComponents);
                    mainView.showLogout();
                }

            break;

            case LogoutView.BTN_BACK:
                logoutView.setmainView(mainView);
                logoutView.setComponents(viewComponents);
                mainView.showMenu();
            break;

        }
    }
}
