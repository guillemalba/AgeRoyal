package presentation.views;

import javax.swing.*;
import java.awt.*;

/**
 * Esta clase es la ventana central de nuestras vistas. Esta vista se centra sobre el funcionamiento de CardLayout para
 * poder mostrar todas las vistas (unas encima de las otras)
 */
public class MainView extends JFrame {
    static final int width = 600;
    static final int height = 720;

    private final JPanel jpView = new JPanel();

    private CardLayout viewComponents;
    private RegisterView registerView;
    private LoginView loginView;
    private LogoutView logoutView;
    private MenuView menuView;
    private GameView gameView;
    private RecordedGameMenuView recordedGameView;
    private RankingView rankingView;

    /**
     * En nuestro constructor declararemos todas las vistas que tenemos que en nuestro programa. A estas vistas les
     * asignaremos nombres para poder llamarlas de forma agil y sencilla.
     * @param viewComponents Son los componentes de tipo CardLayout
     * @param registerView Es la vista de registro de nuestro programa
     * @param loginView Es la vista de inicio de sesión de nuestro programa
     * @param logoutView Esta es la vista de salida y eliminación de usuarios
     * @param menuView Este es nuestro menu central
     * @param gameView Esta es la vista de nuestro juego
     * @param recordedGameView Esta es la vista que nos muestras
     * @param rankingView Esta vista es el ranking de nuestros jugadores
     */
    public MainView(CardLayout viewComponents, RegisterView registerView, LoginView loginView, LogoutView logoutView, MenuView menuView, GameView gameView, RecordedGameMenuView recordedGameView, RankingView rankingView){
         this.viewComponents = viewComponents;
         this.setLayout(viewComponents);
         this.configureWindow();
         this.configureMainView();
         this.registerView = registerView;
         this.add(registerView, "registerView");
         this.loginView = loginView;
         this.add(loginView, "loginView");
         this.logoutView = logoutView;
         this.add(logoutView, "logoutView");
         this.menuView = menuView;
         this.add(menuView, "menuView");
         this.gameView = gameView;
         this.add(gameView, "gameView");
         this.recordedGameView = recordedGameView;
         this.add(recordedGameView, "recordedGameView");
         this.rankingView = rankingView;
         this.add(rankingView, "rankingView");
    }

    /**
     * Este metodo generara la vista inicial con todos los parametros deseados
     */
    private void configureMainView() {
        jpView.setBackground(Color.GRAY);
        this.add(jpView);
        this.getContentPane().add(jpView, "main");
        this.getViewComponent().show(this.getContentPane(), "main");
    }

    private CardLayout getViewComponent() {
        return viewComponents;
    }

    /**
     * Este metodo generara el nombre de la ventana en si, con el nombre del programa y algun parametro mas
     */
    private void configureWindow() {
        setTitle("Age Royale");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setSize(width, height);
    }

    /**
     * Este metodo servira para iniciar la vista de nuestro codigo
     */
    public void start() {
        setVisible(true);
        this.getViewComponent().show(this.getContentPane(), "loginView");
    }

    /**
     * Este metodo nos mostrara la pantalla de juego
     */
    public void showGameView(){
        this.getViewComponent().show(this.getContentPane(), "gameView");
    }

    /**
     * Este metodo nos mostrara la pantalla de menu
     */
    public void showMenu(){
        this.getViewComponent().show(this.getContentPane(), "menuView");
    }

    /**
     * Este metodo nos mostrara la pantalla de juegos guardados
     */
    public void showRecordedGame() {
        this.getViewComponent().show(this.getContentPane(), "recordedGameView");
    }

    /**
     * Este metodo nos mostrara la pantalla de ranking
     */
    public void showRanking() {
        this.getViewComponent().show(this.getContentPane(), "rankingView");
    }

    /**
     * Este metodo nos mostrara la pantalla de registro
     */
    public void showRegister() {
        this.getViewComponent().show(this.getContentPane(), "registerView");
    }

    /**
     * Este metodo nos mostrara la pantalla de ajustes (logout)
     */
    public void showLogout() {
        this.getViewComponent().show(this.getContentPane(), "logoutView");
    }

    /**
     * Este metodo nos mostrara la pantalla de inicio de sesion
     */
    public void showLogin() {
        this.getViewComponent().show(this.getContentPane(), "loginView");
    }
}
