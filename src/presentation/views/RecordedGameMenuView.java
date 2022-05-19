package presentation.views;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RecordedGameMenuView extends JPanel {
    JButton jbSettings;
    JButton jbBack;

    public RecordedGameMenuView() {
        JPanel background = new JPanel(new BorderLayout());
        background.setLayout(new BorderLayout());
        background.setBackground(Color.GRAY);

        /**************************************** HEADER *********************************************/
        JPanel jpNorth = new JPanel(new BorderLayout());
        jpNorth.setOpaque(false);

        jbSettings = new JButton("Settings");
        jbSettings.setBackground(Color.BLUE);
        jbSettings.setForeground(Color.WHITE);
        jbSettings.setActionCommand("settings");
        jpNorth.add(jbSettings, BorderLayout.WEST);

        background.add(jpNorth, BorderLayout.NORTH);

        /******************************************** BODY *******************************************/
        Dimension dimension = new Dimension(300,100);
        Border border = BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(15, 15, 15, 15),
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.WHITE,3,true),
                        BorderFactory.createEmptyBorder(5,5,10,10)
                )
        );

        JPanel jpCenter = new JPanel(new GridLayout(1,4));
        //TODO: Sacar el numero de Juegos grabados por usuario y la informacion de cada juego
        int score1 = 4;
        int score2 = 0;
        for(int i = 0; i < 4; i++){
            JPanel recorded = new JPanel();
            recorded.setLayout(new BoxLayout(recorded, BoxLayout.PAGE_AXIS));
            String name = "Hola";
            recorded.add(new JLabel("Name: "+name));
            recorded.add(new JLabel("["+(score1-i)+"-"+(score2+i)+"]"));
            if((score1-i) > (score2+i)){
                recorded.setBorder(BorderFactory.createLineBorder(Color.blue));
            }else if ((score1-i) == (score2+i)){
                recorded.setBorder(BorderFactory.createLineBorder(Color.black));
            }else {
                recorded.setBorder(BorderFactory.createLineBorder(Color.red));
            }
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDateTime now = LocalDateTime.now();
            recorded.add(new JLabel(dtf.format(now)));
            jpCenter.add(recorded);
        }

        JPanel jpBody = new JPanel(new GridLayout());
        jpBody.add(jpCenter);
        jpBody.setOpaque(false);
        background.add(jpBody, BorderLayout.CENTER);

        /******************************************** FOOT *******************************************/
        JPanel jpSouth = new JPanel(new BorderLayout());
        jpSouth.setOpaque(false);

        jbBack = new JButton("Back");
        jbBack.setBackground(Color.GRAY);
        jbBack.setForeground(Color.WHITE);
        jbBack.setActionCommand("back");
        jpSouth.add(jbBack, BorderLayout.WEST);

        background.add(jpSouth, BorderLayout.SOUTH);

        add(background);
    }

    public void recordedGameMenuController(ActionListener actionListener) {
        jbSettings.addActionListener(actionListener);
        jbBack.addActionListener(actionListener);
    }
}
