package presentation.views;

import business.entities.Game;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.LinkedList;

public class RecordedGameMenuView extends JPanel {
    private JButton jbSettings;
    private JButton jbBack;
    private LinkedList<Game> games;

    private JPanel table = new JPanel();
    private JPanel jpCenter = new JPanel();
    private JScrollPane scrollPane = new JScrollPane();


    private JPanel[] recorded = new JPanel[10];


    public RecordedGameMenuView() {
        if(games == null){
            games = new LinkedList<Game>();
        }
        setLayout(new BorderLayout());
        setSize(550, 720);
        JPanel background = new JPanel(new BorderLayout());
        background.setSize(550, 50);
        background.setLayout(new BorderLayout());
        //background.setBackground(Color.GRAY);

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

        scrollPane.setBounds(5, 10, 580, 80);


        //TODO: Sacar el numero de Juegos grabados por usuario y la informacion de cada juego
        BoxLayout layout = new BoxLayout(jpCenter, BoxLayout.PAGE_AXIS);
        jpCenter.setLayout(layout);

        jpCenter.add(scrollPane);

        background.add(scrollPane, BorderLayout.CENTER);

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

    public void update(LinkedList<Game> games){
        this.games = games;
        scrollPane.remove(table);

        if(games.size() != 0) {
            for (int i = 0; i < games.size(); i++) {
                recorded[i] = new JPanel(new BorderLayout());
                recorded[i].setSize(50, 50);

                String name = "Hola";
                recorded[i].add(new JLabel("Name: " + games.get(i).getName()), BorderLayout.NORTH);
                recorded[i].add(new JLabel("Player: "+ games.get(i).getPlayer()));
                if (games.get(i).getWin()) {
                    recorded[i].setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(100, 5, 0, 5), BorderFactory.createLineBorder(Color.blue)));
                } else {
                    recorded[i].setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(100, 5, 0, 5), BorderFactory.createLineBorder(Color.red)));
                }

                recorded[i].add(new JLabel(games.get(i).getDate()), BorderLayout.SOUTH);

                table.add(recorded[i]);
            }
        }else{
            jpCenter.add(new Label("There are no games recorded!"));
        }
        scrollPane.setViewportView(table);

        revalidate();
        repaint();
    }
}
