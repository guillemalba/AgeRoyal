package presentation.controllers;

import business.GameManager;
import business.RecordedGameManager;

import presentation.views.MainView;
import presentation.views.RecordedGameMenuView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
 * Esta clase lo que ara sera controlar la vista de partidas guardadas con sus botones y las acciones que deben hacer
 */
public class RecordedGameMenuController implements ActionListener, MouseListener {
    private RecordedGameMenuView recordedGameMenuView;
    private MainView mainView;
    private GameManager gameManager;
    private RecordedGameManager recordedGameManager;
    private int ok;

    /**
     * Este sera el constructor de nuestro controlador que asigna todos parametros necesarios para su funcionamiento
     * @param recordedGameMenuView es la vista que queremos controlar
     * @param mainView la ventana que controla todas nuestras vistas
     * @param gameManager es el manager de la base de datos de nuestro game
     */
    public RecordedGameMenuController(RecordedGameMenuView recordedGameMenuView, MainView mainView, GameManager gameManager, RecordedGameManager recordedGameManager) {
        this.recordedGameMenuView = recordedGameMenuView;
        this.mainView = mainView;
        this.gameManager = gameManager;
        this.recordedGameManager = recordedGameManager;
        updateRecordedGame();
    }

    /**
     * Este metodo recibe los strings de nuestro inicio de sesion y su contraseña y comprobamos que su estado sea le correcto
     * @param e es el objecto asignado al boton presionado
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "settings":
                mainView.showLogout();
                //mainView.showSettings();
                break;
            case "back":
                mainView.showMenu();
                break;
        }
    }

    /**
     * Este metodo actualizara la informacion de las partidas guardadas en la base de datos
     */
    public void updateRecordedGame(){
        recordedGameMenuView.update(gameManager.readUserGames());
    }

    /**
     * Este metodo se activara cuando los paneles son presionados
     * @param e es el objecto asignado al panel presionado
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        ok = recordedGameMenuView.popUp();
        if(ok == 0){
            recordedGameManager.reviewGame(e.getComponent().getName());
            mainView.getGameView().setRepro(true);
            recordedGameManager.initReproduction();
            mainView.showGameView();

        }

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
