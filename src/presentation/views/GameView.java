package presentation.views;

import business.entities.Board;
import business.entities.Troop;

import presentation.controllers.GameViewController;
import org.w3c.dom.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class GameView extends JPanel {

    private JButton settingsJb = new JButton("Settings");
    private JButton backJb = new JButton("Back");
    private JPanel[][] tableGrid = new JPanel[15][15];
    private Board board;
    private JPanel table = new JPanel();
    private JPanel midJp = new JPanel();
    private JPanel defT1 = new JPanel();
    private JPanel offT1 = new JPanel();
    private JPanel offT2 = new JPanel();
    private JPanel defT2 = new JPanel();
    private JLabel mLabel = new JLabel("5");

    public GameView(){
        if (board == null) {
            board = new Board();
        }
        configureView();
    }

    private void configureView() {
        setLayout(new BorderLayout());
        setSize(550, 720);
        JPanel general = new JPanel();
        general.setLayout(new BorderLayout());
        JPanel topJp = new JPanel();
        topJp.add(settingsJb, BorderLayout.EAST);


        GridLayout layout = new GridLayout(2,2);
        midJp.setLayout(layout);

        int height = 15;
        int width = 15;


        table.setSize(400, 400);
        GridLayout tableLayout = new GridLayout(width,height);
        table.setLayout(tableLayout);
        //----------
        //----------
        tableGrid = new JPanel[15][15];
        //funcion para pinta mapa nuevo
        for(int i = 0; i < 15; i++){
            for(int j = 0; j < 15; j++) {
                tableGrid[i][j] = new JPanel();
                tableGrid[i][j].setLayout(new BorderLayout());
                tableGrid[i][j].setSize(15,15);
                tableGrid[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                tableGrid[i][j].setName(i+","+j);
            }
        }
        updateView(board,5);
        midJp.add(table);

        //si fa falta borrar el table

        JPanel info = new JPanel();
        info.setLayout(new BorderLayout());
        info.setSize(200, 400);
        GridLayout layoutInfo = new GridLayout(4,1);
        info.setLayout(layoutInfo);
        JPanel livesPanel1 = new JPanel();
        info.add(livesPanel1);
        JLabel lives = new JLabel("Lives");
        livesPanel1.add(lives);
        JPanel livesPanel2 = new JPanel();
        livesPanel2.setBackground(Color.gray);
        livesPanel2.setBorder(BorderFactory.createLineBorder(Color.black));
        livesPanel2.setLayout(new GridLayout(2,1));
        JPanel badLives = new JPanel();
        badLives.setBackground(Color.red);
        livesPanel2.add(badLives);
        JPanel goodLives = new JPanel();
        goodLives.setBackground(Color.blue);
        livesPanel2.add(goodLives);
        info.add(livesPanel2);
        JPanel troopCountPanel1 = new JPanel();
        info.add(troopCountPanel1);
        JLabel Troops = new JLabel("Troops");
        troopCountPanel1.add(Troops);
        JPanel troopCountPanel2 = new JPanel();
        troopCountPanel2.setBackground(Color.gray);
        troopCountPanel2.setBorder(BorderFactory.createLineBorder(Color.black));
        troopCountPanel2.setLayout(new GridLayout(2,1));
        JPanel badTroops = new JPanel();
        badTroops.setBackground(Color.red);
        troopCountPanel2.add(badTroops);
        JPanel goodTroops = new JPanel();
        goodTroops.setBackground(Color.blue);
        troopCountPanel2.add(goodTroops);
        info.add(troopCountPanel2);
        midJp.add(info);

        JPanel troopPanel = new JPanel();
        troopPanel.setBackground(Color.white);
        troopPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        GridLayout troopCardNameLayout = new GridLayout(2, 2);
        troopPanel.setLayout(troopCardNameLayout);
        JLabel offensiveLabel = new JLabel("Offensive");
        JLabel defensiveLabel = new JLabel("Defensive");
        offensiveLabel.setHorizontalAlignment(JLabel.CENTER);
        defensiveLabel.setHorizontalAlignment(JLabel.CENTER);
        troopPanel.add(offensiveLabel);
        troopPanel.add(defensiveLabel);
        JPanel offensiveCardPanel = new JPanel();
        GridLayout offensiveCardLayout = new GridLayout(2, 2);
        offensiveCardPanel.setLayout(offensiveCardLayout);

        offT1.setBackground(Color.YELLOW);
        offT1.setName("offT1");
        offT1.setLayout(new BorderLayout());
        try {
            BufferedImage image = ImageIO.read(new File("files/user_archer.png"));
            JLabel label = new JLabel(new ImageIcon(image));
            offT1.add(label);

        } catch (IOException e) {
            e.printStackTrace();
        }

        offensiveCardPanel.add(offT1);

        offT2.setBackground(Color.YELLOW);
        offT2.setName("offT2");
        offT2.setLayout(new BorderLayout());
        try {
            BufferedImage image = ImageIO.read(new File("files/user_giant.png"));
            JLabel label = new JLabel(new ImageIcon(image));
            offT2.add(label);

        } catch (IOException e) {
            e.printStackTrace();
        }

        offensiveCardPanel.add(offT2);
        offensiveCardPanel.add(new JLabel("5"));
        offensiveCardPanel.add(new JLabel("3"));
        troopPanel.add(offensiveCardPanel);

        JPanel defensiveCardPanel = new JPanel();
        GridLayout defensiveCardLayout = new GridLayout(2, 2);
        defensiveCardPanel.setLayout(defensiveCardLayout);

        defT1.setBackground(Color.GREEN);
        defT1.setName("defT1");
        defT1.setLayout(new BorderLayout());
        try {
            BufferedImage image = ImageIO.read(new File("files/user_cannon.png"));
            JLabel label = new JLabel(new ImageIcon(image));
            defT1.add(label);

        } catch (IOException e) {
            e.printStackTrace();
        }
        defensiveCardPanel.add(defT1);


        defT2.setBackground(Color.GREEN);
        defT2.setName("defT2");
        defT2.setLayout(new BorderLayout());
        try {
            BufferedImage image = ImageIO.read(new File("files/user_tesla.png"));
            JLabel label = new JLabel(new ImageIcon(image));
            defT2.add(label);

        } catch (IOException e) {
            e.printStackTrace();
        }

        defensiveCardPanel.add(defT2);
        defensiveCardPanel.add(new JLabel("4"));
        defensiveCardPanel.add(new JLabel("2"));
        troopPanel.add(defensiveCardPanel);

        midJp.add(troopPanel);
        JPanel goldPanel = new JPanel();
        GridLayout goldLayout = new GridLayout(2,1);
        goldPanel.setLayout(goldLayout);
        JLabel gLabel = new JLabel("Gold");
        gLabel.setHorizontalAlignment(JLabel.CENTER);
        goldPanel.add(gLabel);

        mLabel.setHorizontalAlignment(JLabel.CENTER);
        goldPanel.add(mLabel);
        midJp.add(goldPanel);

        JPanel botJp = new JPanel();
        botJp.add(backJb, BorderLayout.EAST);

        general.add(topJp, BorderLayout.NORTH);
        general.add(midJp, BorderLayout.CENTER);
        general.add(botJp, BorderLayout.SOUTH);

        add(general, BorderLayout.CENTER);
    }

    public void registerController(ActionListener listener1, MouseListener listener2) {
        settingsJb.addActionListener(listener1);
        backJb.addActionListener(listener1);
        defT2.addMouseListener(listener2);
        defT1.addMouseListener(listener2);
        offT2.addMouseListener(listener2);
        offT1.addMouseListener(listener2);
        for(int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                tableGrid[i][j].addMouseListener(listener2);
            }
        }
    }


    public void updateView(Board board,int moneyUser) {
        //midJp.remove(table);
        table.removeAll();
        midJp.remove(table);

        //pintem el panell
        for(int i = 0; i < board.getSide(); i++){
            for(int j = 0; j < 15; j++) {
                tableGrid[i][j].removeAll();
                if (board.isEmpty(i,j)) {
                    tableGrid[i][j].setBackground(Color.WHITE);
                } else {
                    tableGrid[i][j].add(new JLabel (new ImageIcon(board.getCellsMatrix()[i][j].getTroop().getImage())));

                    /*tableGrid[i][j].setBackground(board.getColorTroop(i,j));*/
                }

            }
        }
        //omplim la table amb el panell pintat
        for(int i = 0; i < 15; i++){
            for(int j = 0; j < 15; j++) {
                table.add(tableGrid[i][j]);
            }
        }
        mLabel.setText(Integer.toString(moneyUser));
        midJp.add(table, 0);



        revalidate();
        repaint();
    }

    public void putBorder(String click){
        switch (click){
            case "offT1":
                offT1.setBorder(BorderFactory.createLineBorder(Color.RED,4));
                offT2.setBorder(null);
                defT1.setBorder(null);
                defT2.setBorder(null);
                break;
            case "offT2":
                offT1.setBorder(null);
                offT2.setBorder(BorderFactory.createLineBorder(Color.RED,4));
                defT1.setBorder(null);
                defT2.setBorder(null);
                break;
            case "defT1":
                offT1.setBorder(null);
                offT2.setBorder(null);
                defT1.setBorder(BorderFactory.createLineBorder(Color.RED,4));
                defT2.setBorder(null);
                break;
            case "defT2":
                offT1.setBorder(null);
                offT2.setBorder(null);
                defT1.setBorder(null);
                defT2.setBorder(BorderFactory.createLineBorder(Color.RED,4));
                break;
            default:
                offT1.setBorder(null);
                offT2.setBorder(null);
                defT1.setBorder(null);
                defT2.setBorder(null);
        }
    }

}
