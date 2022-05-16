package presentation.views;

import org.w3c.dom.Text;
import presentation.controllers.GameViewController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameView extends JPanel {

    private JButton settingsJb = new JButton("Settings");
    private JButton backJb = new JButton("Back");
    private JPanel[][] tableGrid;
    private GameViewController gameViewController;

    public GameView(GameViewController gameViewController){
        this.gameViewController = gameViewController;
        configureView();
    }

    private void configureView() {
        setLayout(new BorderLayout());
        setSize(550, 720);
        JPanel general = new JPanel();
        general.setLayout(new BorderLayout());
        JPanel topJp = new JPanel();
        topJp.add(settingsJb, BorderLayout.EAST);

        JPanel midJp = new JPanel();
        GridLayout layout = new GridLayout(2,2);
        midJp.setLayout(layout);

        int height = 15;
        int width = 15;

        JPanel table = new JPanel();
        table.setSize(400, 400);
        GridLayout tableLayout = new GridLayout(width,height);
        table.setLayout(tableLayout);
        tableGrid = new JPanel[width][height];

        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++) {
                tableGrid[i][j] = new JPanel();
                tableGrid[i][j].setSize(15,15);
                tableGrid[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                tableGrid[i][j].setName(i+","+j);
                table.add(tableGrid[i][j]);
                int finalI = i;
                int finalJ = j;
                tableGrid[i][j].addMouseListener(gameViewController);
                /*tableGrid[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        tableGrid[finalI][finalJ].setBackground(Color.cyan);
                        System.out.println("Position pressed: x -> "+finalI+" y -> "+finalJ);
                        super.mouseClicked(e);
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        tableGrid[finalI][finalJ].setBackground(Color.GRAY);
                        super.mouseEntered(e);
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        tableGrid[finalI][finalJ].setBackground(Color.WHITE);
                        super.mouseExited(e);
                    }
                });*/
            }
        }
        midJp.add(table);

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
        JPanel offT1 = new JPanel();
        offT1.setBackground(Color.green);
        offT1.setName("offT1");
        offT1.addMouseListener(gameViewController);
        /*offT1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                offT1.setBackground(Color.lightGray);
                super.mouseClicked(e);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                offT1.setBackground(Color.green);
                super.mouseClicked(e);
            }
        });*/
        offensiveCardPanel.add(offT1);
        JPanel offT2 = new JPanel();
        offT2.setBackground(Color.pink);
        offT2.setName("offT2");
        offT2.addMouseListener(gameViewController);
        /*offT2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                offT2.setBackground(Color.lightGray);
                super.mouseClicked(e);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                offT2.setBackground(Color.pink);
                super.mouseClicked(e);
            }
        });*/
        offensiveCardPanel.add(offT2);
        offensiveCardPanel.add(new JLabel("5"));
        offensiveCardPanel.add(new JLabel("3"));
        troopPanel.add(offensiveCardPanel);

        JPanel defensiveCardPanel = new JPanel();
        GridLayout defensiveCardLayout = new GridLayout(2, 2);
        defensiveCardPanel.setLayout(defensiveCardLayout);
        JPanel defT1 = new JPanel();
        defT1.setBackground(Color.green);
        defT1.setName("defT1");
        defensiveCardPanel.add(defT1);
        defT1.addMouseListener(gameViewController
                /*new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                defT1.setBackground(Color.lightGray);
                super.mouseClicked(e);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                defT1.setBackground(Color.green);
                super.mouseClicked(e);
            }
        }*/);
        JPanel defT2 = new JPanel();
        defT2.setBackground(Color.pink);
        defT2.setName("defT2");
        defT2.addMouseListener(gameViewController
            /*  new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                defT2.setBackground(Color.lightGray);
                super.mouseClicked(e);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                defT2.setBackground(Color.pink);
                super.mouseClicked(e);
            }
        }*/);
        defensiveCardPanel.add(defT2);
        defensiveCardPanel.add(new JLabel("4"));
        defensiveCardPanel.add(new JLabel("2"));
        troopPanel.add(defensiveCardPanel);

        midJp.add(troopPanel);
        JPanel goldPanel = new JPanel();
        //goldPanel.setBackground(Color.white);
        //goldPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        GridLayout goldLayout = new GridLayout(2,1);
        goldPanel.setLayout(goldLayout);
        JLabel gLabel = new JLabel("Gold");
        gLabel.setHorizontalAlignment(JLabel.CENTER);
        goldPanel.add(gLabel);
        JLabel mLabel = new JLabel("5");
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

    public void registerController(ActionListener listener) {
        settingsJb.addActionListener(listener);
        backJb.addActionListener(listener);
    }
}
