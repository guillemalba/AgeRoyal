package presentation.views;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Esta clase se empleara para crear el menu central de nuestro el codigo
 */
public class MenuView extends JPanel {
    private JButton jbSettings;
    private JButton jbPlayGame;
    private JButton jbRanking;
    private JButton jbGameGraphics;
    private JButton jbGameRecording;
    private MainView mainView;
    private CardLayout viewComponents;

    /**
     * Este metodo es el constructor de nuestra vista de menu, desde esta se podra acceder a cualquier otra vista.
     */
    public MenuView(){
        configureMenuView();
    }

    /**
     * Desde aqui añadiremos todos los componentes de nuestra vista.
     */
    private void configureMenuView() {

        setLayout(new BorderLayout());
        setSize(550, 720);


        /** Creem un background per afegir les coses **/
        JPanel background = new JPanel();
        background.setLayout(new BorderLayout());
        setSize(550, 720);
        background.setBackground(Color.WHITE);

        /******************************************** HEADER *******************************************/
        /** Creem un altre BorderLayout per distribuir el header de la finestra**/
        JPanel jpNorth = new JPanel(new BorderLayout());
        jpNorth.setOpaque(false);

        /** Configurem el "SETTINGS" button **/
        jbSettings = new JButton();
        jbSettings.setIcon(new ImageIcon(new ImageIcon("files/btn_settings.png").getImage().getScaledInstance(150, 75, Image.SCALE_DEFAULT)));
        jbSettings.setBorderPainted(false);
        jbSettings.setContentAreaFilled(false);
        jbSettings.setActionCommand("BTN_LOGOUT");
        jpNorth.add(jbSettings, BorderLayout.WEST);

        /** Creem un GridLayout pel titol al centre **/
        JPanel jpBody = new JPanel(new GridBagLayout());
        JLabel viewTitle = new JLabel("AGE ROYALE", JLabel.CENTER);
        viewTitle.setFont(new Font("font", Font.BOLD, 70));
        viewTitle.setForeground(Color.BLACK);
        jpNorth.add(viewTitle, BorderLayout.CENTER);

        background.add(jpNorth, BorderLayout.NORTH);

        JPanel jpCenter = new JPanel(new GridLayout(3, 1));

        addButton(jpCenter);

        jpBody.add(jpCenter);
        jpBody.setOpaque(false);
        background.add(jpBody, BorderLayout.CENTER);

        add(background);
        setVisible(true);
    }

    /**
     * Este metodo creara todos los botones que se necesitan para la vista relacionada con esta clase
     * @param jpCenter
     */
    private void addButton(JPanel jpCenter){

        Border border = BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(15, 15, 15, 15),
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.WHITE,3,true),
                        BorderFactory.createEmptyBorder(5,5,10,10)
                )

        );
        Dimension dimension = new Dimension(300,100);

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

        jbGameRecording = new JButton("Game Recording");
        jbGameRecording.setForeground(Color.BLACK);
        jbGameRecording.setBackground(Color.WHITE);
        jbGameRecording.setActionCommand("game_recording");
        jbGameRecording.setBorder(border);
        jbGameRecording.setPreferredSize(dimension);
        jpCenter.add(jbGameRecording);
    }

    /**
     * Este metodo sirve para asignar los controladores de cada boton de nuestra vita a alguna accion
     * @param actionListener listener
     */
    public void registerActionListener(ActionListener actionListener){
        jbSettings.addActionListener(actionListener);
        jbPlayGame.addActionListener(actionListener);
        jbRanking.addActionListener(actionListener);
        jbGameRecording.addActionListener(actionListener);
    }

    /**
     * setter para asignar la main view
     *
     * @param mainView vista principal
     */
    public void setMainView(MainView mainView) {
        this.mainView = mainView;
    }

    /**
     * Setter para asignar los componentes del card layout
     *
     * @param viewComponents card layout
     */
    public void setViewComponents(CardLayout viewComponents) {
        this.viewComponents = viewComponents;
    }
}
