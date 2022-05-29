package presentation.controllers;

import business.UserManager;
import presentation.views.MainView;
import presentation.views.RankingView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Esta clase es la que controlara nuestra vista de ranking con sus botones
 */
public class RankingController implements ActionListener, MouseListener {
    private RankingView rankingView;
    private MainView mainView;
    private UserManager userManager;

    /**
     * Este es el constructor el cual introducira todos los objetos necesarios para su funcionamiento
     * @param rankingView es la vista que queremos controlar
     * @param mainView es la ventana inicial en la que se muestran nuestras vistas
     * @param userManager es el controlador de la base de datos de nuestros usuarios
     */
    public RankingController(RankingView rankingView, MainView mainView, UserManager userManager) {
        this.rankingView = rankingView;
        this.mainView = mainView;
        this.userManager = userManager;
    }

    /**
     * Este metodo muestra lo que tiene que hacer el codigo si se presiona un boton concreto
     * @param e event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case "settings":
                mainView.showLogout();
                break;
            case "back":
                mainView.showMenu();
                break;
        }
    }


    /**
     * Este metodo actualizara la informacion de los usuarios guardados en la vista
     */
    public void updateRecorderUsers(){
        rankingView.update(userManager.readSortedUsers());
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
