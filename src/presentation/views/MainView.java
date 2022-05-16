package presentation.views;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    static final int width = 1080;
    static final int height = 720;

    private final JPanel jpView = new JPanel();

    private CardLayout viewComponents;
    private RegisterView registerView;
    private LoginView loginView;
    private LogoutView logoutView;
    private MenuView menuView;
    private GameView gameView;

    public MainView(CardLayout viewComponents, RegisterView registerView, LoginView loginView, LogoutView logoutView, MenuView menuView, GameView gameView){
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
    }

    private void configureMainView() {
        jpView.setBackground(Color.GRAY);
        this.add(jpView);
        this.getContentPane().add(jpView, "main");
        this.getViewComponent().show(this.getContentPane(), "main");
    }

    private CardLayout getViewComponent() {
        return viewComponents;
    }

    private void configureWindow() {
        setTitle("Main View");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setSize(width, height);
    }

    public void start() {
        setVisible(true);
        this.getViewComponent().show(this.getContentPane(), "loginView");
    }

    public void showGameView(){
        this.getViewComponent().show(this.getContentPane(), "gameView");
    }

    public void showMenu(){
        this.getViewComponent().show(this.getContentPane(), "menuView");
    }

    public void showSettings() {
        this.getViewComponent().show(this.getContentPane(), "logoutView");
    }
}
