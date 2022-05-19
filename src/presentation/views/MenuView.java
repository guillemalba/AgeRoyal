package presentation.views;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

public class MenuView extends JPanel {
    public static final String BTN_LOGOUT = "BTN_LOGOUT";

    JButton jbSettings;
    JButton jbPlayGame;
    JButton jbRanking;
    JButton jbGameGraphics;
    JButton jbGameRecording;
    private MainView mainView;
    private CardLayout viewComponents;

    public MenuView(){
        configureMenuView();
    }

    private void configureMenuView() {
        JFrame jframe = new JFrame();

        /** Configurem la finestra **/
        jframe.setTitle("Main Menu");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        //jframe.setLocationRelativeTo(null);
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        /** Creem un background per afegir les coses **/
        JPanel background = new JPanel();
        background.setLayout(new BorderLayout());
        background.setBackground(Color.GRAY);

        /******************************************** HEADER *******************************************/
        /** Creem un altre BorderLayout per distribuir el header de la finestra**/
        JPanel jpNorth = new JPanel(new BorderLayout());
        jpNorth.setOpaque(false);

        /** Configurem el "SETTINGS" button **/
        jbSettings = new JButton("Settings");
        jbSettings.setBackground(Color.BLUE);
        jbSettings.setForeground(Color.WHITE);
        jbSettings.setActionCommand("BTN_LOGOUT");
        jpNorth.add(jbSettings, BorderLayout.WEST);

        /** Creem un GridLayout pel titol al centre **/
        JPanel jpBody = new JPanel(new GridBagLayout());
        JLabel viewTitle = new JLabel("AGE ROYALE", JLabel.CENTER);
        viewTitle.setFont(new Font("font", Font.BOLD, 70));
        viewTitle.setForeground(Color.WHITE);
        jpNorth.add(viewTitle, BorderLayout.CENTER);

        background.add(jpNorth, BorderLayout.NORTH);

        /******************************************** BODY *******************************************/

        Border border = BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(15, 15, 15, 15),
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.WHITE,3,true),
                        BorderFactory.createEmptyBorder(5,5,10,10)
                )

        );
        Dimension dimension = new Dimension(300,100);

        JPanel jpCenter = new JPanel(new GridLayout(4, 1));

        jbPlayGame = new JButton("Play Game");
        jbPlayGame.setForeground(Color.BLACK);
        jbPlayGame.setBackground(Color.WHITE);
        jbPlayGame.setActionCommand("play_game");
        jbPlayGame.setBorder(border);
        jbPlayGame.setPreferredSize(dimension);
        jpCenter.add(jbPlayGame);

        jbRanking = new JButton("Ranking");
        jbRanking.setForeground(Color.BLACK);
        jbRanking.setBackground(Color.WHITE);
        jbRanking.setActionCommand("ranking");
        jbRanking.setBorder(border);
        jbRanking.setPreferredSize(dimension);
        jpCenter.add(jbRanking);

        jbGameGraphics = new JButton("Game Graphics");
        jbGameGraphics.setForeground(Color.BLACK);
        jbGameGraphics.setBackground(Color.WHITE);
        jbGameGraphics.setActionCommand("game_graphics");
        jbGameGraphics.setBorder(border);
        jbGameGraphics.setPreferredSize(dimension);
        jpCenter.add(jbGameGraphics);

        jbGameRecording = new JButton("Game Recording");
        jbGameRecording.setForeground(Color.BLACK);
        jbGameRecording.setBackground(Color.WHITE);
        jbGameRecording.setActionCommand("game_recording");
        jbGameRecording.setBorder(border);
        jbGameRecording.setPreferredSize(dimension);
        jpCenter.add(jbGameRecording);

        jpBody.add(jpCenter);
        jpBody.setOpaque(false);
        background.add(jpBody, BorderLayout.CENTER);

        add(background);
        setVisible(true);
    }

    public void setMainView(MainView mainView) {
        this.mainView = mainView;
    }

    public void setViewComponents(CardLayout viewComponents) {
        this.viewComponents = viewComponents;
    }

    public void registerActionListener(ActionListener actionListener){
        jbSettings.addActionListener(actionListener);
        jbPlayGame.addActionListener(actionListener);
        jbGameRecording.addActionListener(actionListener);
    }

    public void showLogout() {
        viewComponents.show(this.mainView.getContentPane(), "logoutView");
    }
}
