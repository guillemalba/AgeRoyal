package presentation.views;

import business.entities.Game;
import business.entities.User;
import presentation.controllers.RecordedGameMenuController;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseMotionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.LinkedList;

public class RankingView extends JPanel {
    private JButton jbSettings;
    private JButton jbBack;
    private LinkedList<User> players;

    private JPanel table = new JPanel();
    private JPanel jpCenter = new JPanel();
    private JScrollPane scrollPane = new JScrollPane();
    private RecordedGameMenuController recordedGameMenuController;

    private JPanel[] recorded = new JPanel[100];


    public RankingView() {
        if(players == null){
            players = new LinkedList<User>();
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

    public void setRegisterController(RecordedGameMenuController recordedGameMenuController) {
        this.recordedGameMenuController = recordedGameMenuController;
    }

    public void registerRankingController(ActionListener actionListener) {
        jbSettings.addActionListener(actionListener);
        jbBack.addActionListener(actionListener);
    }

    public void update(LinkedList<User> players){
        this.players = players;

        if(recorded[0] != null){
            for (int i = 0; i < recorded.length; i++) {
                if(recorded[i] != null) {
                    table.remove(recorded[i]);
                }
            }
        }
        scrollPane.remove(table);

        if(players.size() != 0) {

            for (int i = 0; i < players.size(); i++) {
                recorded[i] = new JPanel(new BorderLayout());
                recorded[i].setSize(50, 50);

                recorded[i].add(new JLabel("Name: " + players.get(i).getName()), BorderLayout.NORTH);
                recorded[i].add(new JLabel("Win Ratio: "+ players.get(i).getRatio()));
                recorded[i].setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(100, 5, 0, 5), BorderFactory.createLineBorder(Color.black)));
                table.add(recorded[i]);
            }
        }
        scrollPane.setViewportView(table);

        revalidate();
        repaint();
    }
}
