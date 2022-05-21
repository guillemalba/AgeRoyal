package presentation.views;

import business.entities.Game;
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

public class RecordedGameMenuView extends JPanel {
    private JButton jbSettings;
    private JButton jbBack;
    private LinkedList<Game> games;

    private JPanel table = new JPanel();
    private JPanel jpCenter = new JPanel();
    private JScrollPane scrollPane = new JScrollPane();
    private RecordedGameMenuController recordedGameMenuController;

    private JPanel[] recorded = new JPanel[100];


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

    public void setRecordedGameMenuController(RecordedGameMenuController recordedGameMenuController) {
        this.recordedGameMenuController = recordedGameMenuController;
        recordedGameMenuController(recordedGameMenuController);
    }

    public void recordedGameMenuController(ActionListener actionListener) {
        jbSettings.addActionListener(actionListener);
        jbBack.addActionListener(actionListener);
    }

    public void update(LinkedList<Game> games){
        this.games = games;

        if(recorded[0] != null){
            for (int i = 0; i < recorded.length; i++) {
                if(recorded[i] != null) {
                    table.remove(recorded[i]);
                }
            }
        }
        scrollPane.remove(table);

        if(games.size() != 0) {

            for (int i = 0; i < games.size(); i++) {
                recorded[i] = new JPanel(new BorderLayout());
                recorded[i].setSize(50, 50);

                recorded[i].add(new JLabel("Name: " + games.get(i).getName()), BorderLayout.NORTH);
                recorded[i].add(new JLabel("Player: "+ games.get(i).getPlayer()));
                if (games.get(i).getWin()) {
                    recorded[i].setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(100, 5, 0, 5), BorderFactory.createLineBorder(Color.blue)));
                } else {
                    recorded[i].setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(100, 5, 0, 5), BorderFactory.createLineBorder(Color.red)));
                }
                recorded[i].addMouseListener(recordedGameMenuController);
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

    public void popUp() {
        int input = JOptionPane.showConfirmDialog(new RecordedGameMenuView(),
                "Do you want to watch that game?", "Customized Dialog",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
        System.out.println(input);
    }
}
