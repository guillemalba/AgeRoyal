package presentation.views;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

public class RecordedGameView extends JFrame {
    JButton jbSettings;
    JButton jbBack;

    public RecordedGameView() {
        /** Configurem la finestra **/
        setTitle("Recorded Game View");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        /** Creem el "background" per afegir les coses **/
        JPanel background = new JPanel(new BorderLayout());
        background.setLayout(new BorderLayout());
        background.setBackground(Color.GRAY);

        /**************************************** HEADER *********************************************/
        /**
         * Creem un altre BorderLayout per distribuir el header de la finestra**/
        JPanel jpNorth = new JPanel(new BorderLayout());
        jpNorth.setOpaque(false);

        /** Configurem el "SETTINGS" button **/
        jbSettings = new JButton("Settings");
        jbSettings.setBackground(Color.BLUE);
        jbSettings.setForeground(Color.WHITE);
        jbSettings.setActionCommand("settings");
        jpNorth.add(jbSettings, BorderLayout.WEST);

        background.add(jpNorth, BorderLayout.NORTH);

        /******************************************** BODY *******************************************/
        /**
         * Aquesta part de la vista és temporal. Properament es farà en funció de les partides gravades
         * TODO: preguntar si em de fer una classe per cada BOX o recording (game, puntuacio, data)
         */
        Dimension dimension = new Dimension(300,100);
        Border border = BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(15, 15, 15, 15),
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.WHITE,3,true),
                        BorderFactory.createEmptyBorder(5,5,10,10)
                )
        );

        JPanel jpCenter = new JPanel(new GridLayout(1,4));
        JButton TjbGame_1 = new JButton("Game 1");
        TjbGame_1.setBorder(border);
        TjbGame_1.setPreferredSize(dimension);
        jpCenter.add(TjbGame_1);

        JButton TjbGame_2 = new JButton("Game 2");
        TjbGame_2.setBorder(border);
        TjbGame_2.setPreferredSize(dimension);
        jpCenter.add(TjbGame_2);

        JButton TjbGame_3 = new JButton("Game 3");
        TjbGame_3.setBorder(border);
        TjbGame_3.setPreferredSize(dimension);
        jpCenter.add(TjbGame_3);

        JButton TjbGame_4 = new JButton("Game 4");
        TjbGame_4.setBorder(border);
        TjbGame_4.setPreferredSize(dimension);
        jpCenter.add(TjbGame_4);

        JPanel jpBody = new JPanel(new GridLayout());
        jpBody.add(jpCenter);
        jpBody.setOpaque(false);
        background.add(jpBody, BorderLayout.CENTER);

        /******************************************** FOOT *******************************************/
        /** Creem un altre BorderLayout per distribuir el foot de la finestra**/
        JPanel jpSouth = new JPanel(new BorderLayout());
        jpSouth.setOpaque(false);

        /** Configurem el "BACK" button **/
        jbBack = new JButton("Back");
        jbBack.setBackground(Color.GRAY);
        jbBack.setForeground(Color.WHITE);
        jbBack.setActionCommand("back");
        jpSouth.add(jbBack, BorderLayout.WEST);

        background.add(jpSouth, BorderLayout.SOUTH);

        add(background);
    }

    /** TODO: preguntar el nom d'aquesta funció **/
    public void recordedGameMenuController(ActionListener actionListener) {
        jbSettings.addActionListener(actionListener);
        jbBack.addActionListener(actionListener);
    }
}
