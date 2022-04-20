package presentation.views;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainMenuView extends JFrame {
    JButton jbSettings;
    JButton playGame;
    JButton ranking;
    JButton gameGraphics;
    JButton gameRecording;

    public MainMenuView () {
        setTitle("Main Menu");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel background = new JPanel();
        background.setLayout(new BorderLayout());
        background.setBackground(Color.GRAY);

        JPanel jpNorth = new JPanel(new BorderLayout());
        jpNorth.setOpaque(false);

        jbSettings = new JButton("Settings");
        jbSettings.setBackground(Color.BLUE);
        jbSettings.setForeground(Color.WHITE);
        jbSettings.setActionCommand("settings");
        jpNorth.add(jbSettings, BorderLayout.WEST);

        JPanel jpBody = new JPanel(new GridBagLayout());
        JLabel viewTitle = new JLabel("AGE ROYALE", JLabel.CENTER);
        viewTitle.setFont(new Font("didac", Font.BOLD, 70));
        viewTitle.setForeground(Color.WHITE);
        jpNorth.add(viewTitle, BorderLayout.CENTER);

        background.add(jpNorth, BorderLayout.NORTH);

        Border border = BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(15, 15, 15, 15),
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.WHITE,3,true),
                        BorderFactory.createEmptyBorder(5,5,10,10)
                )

        );
        Dimension dimension = new Dimension(300,100);

        JPanel jpCenter = new JPanel(new GridLayout(4, 1));

        playGame = new JButton("Play Game");
        playGame.setForeground(Color.BLACK);
        playGame.setBackground(Color.WHITE);
        playGame.setActionCommand("play_game");
        playGame.setBorder(border);
        playGame.setPreferredSize(dimension);
        jpCenter.add(playGame);

        ranking = new JButton("Ranking");
        ranking.setForeground(Color.BLACK);
        ranking.setBackground(Color.WHITE);
        ranking.setActionCommand("ranking");
        ranking.setBorder(border);
        ranking.setPreferredSize(dimension);
        jpCenter.add(ranking);

        gameGraphics = new JButton("Game Graphics");
        gameGraphics.setForeground(Color.BLACK);
        gameGraphics.setBackground(Color.WHITE);
        gameGraphics.setActionCommand("game_graphics");
        gameGraphics.setBorder(border);
        gameGraphics.setPreferredSize(dimension);
        jpCenter.add(gameGraphics);

        gameRecording = new JButton("Game Recording");
        gameRecording.setForeground(Color.BLACK);
        gameRecording.setBackground(Color.WHITE);
        gameRecording.setActionCommand("play_game");
        gameRecording.setBorder(border);
        gameRecording.setPreferredSize(dimension);
        jpCenter.add(gameRecording);

        jpBody.add(jpCenter);
        jpBody.setOpaque(false);
        background.add(jpBody, BorderLayout.CENTER);

        add(background);
        setVisible(true);
    }

    public void mainController(ActionListener actionListener) {
        jbSettings.addActionListener(actionListener);
        playGame.addActionListener(actionListener);
        ranking.addActionListener(actionListener);
        gameGraphics.addActionListener(actionListener);
        gameRecording.addActionListener(actionListener);
    }
}
