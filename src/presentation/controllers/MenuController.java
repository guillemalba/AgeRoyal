package presentation.controllers;

import business.GameManager;
import business.UserManager;
import presentation.views.GameView;
import presentation.views.MainView;
import presentation.views.MenuView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Esta clase es el controlador de nuestra vista de menu
 */
public class MenuController implements ActionListener {

    private MenuView menuView;
    private MainView mainView;
    private CardLayout viewComponents;
    private UserManager userManager;
    private GameManager gameManager;
    private RecordedGameMenuController recordedGameMenuController;
    private RankingController rankingController;

    /**
     * Aqui tenemos su constructor, al cual le pasamos mucha informaion para poder mantener
     * actualizada la informacion de la pantalla en cualquier momento.
     * @param menuView es la vista que vamos a controlar
     * @param mainView es la ventana donde se centran todas nuestras vistas
     * @param viewComponents son los componentes de tipo cardLayout de nuestra vista
     * @param userManager es el manager de la base de datos de nuestros usuarios
     * @param gameManager es el manager de la base de datos de nuestras partidas
     * @param recordedGameMenuController es el controllardor de una de las vistas a las que deseamos acceder
     * @param rankingController es el controllardor de una de las vistas a las que deseamos acceder
     */
    public MenuController(MenuView menuView, MainView mainView, CardLayout viewComponents, UserManager userManager,GameManager gameManager, RecordedGameMenuController recordedGameMenuController, RankingController rankingController) {
        this.menuView = menuView;
        this.mainView = mainView;
        this.viewComponents = viewComponents;
        this.userManager = userManager;
        this.gameManager = gameManager;
        this.recordedGameMenuController = recordedGameMenuController;
        this.rankingController = rankingController;
    }

    /**
     * Este es el metodo en el que asignatremos lo que queremos que haga cada boton
     * @param e es el objeto asignado al boton presionado
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()){
            case MenuView.BTN_LOGOUT :
                menuView.setMainView(mainView);
                menuView.setViewComponents(viewComponents);
                mainView.showLogout();
                break;
            case "play_game":

                gameManager.initGame();
                mainView.showGameView();
                break;
            case "ranking":
                rankingController.updateRecorderUsers();
                mainView.showRanking();
                break;
            case "game_graphics":
                break;
            case "game_recording":
                recordedGameMenuController.updateRecordedGame();
                mainView.showRecordedGame();
                //menuView.setVisible(false);
                break;
        }
    }
}
