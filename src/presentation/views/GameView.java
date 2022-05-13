package presentation.views;

import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameView extends JPanel {

    private JButton settingsJb = new JButton("Settings");
    private JButton backJb = new JButton("Back");
    private JPanel[][] tableGrid;

    public GameView(){
        configureView();
    }

    private void configureView() {
        JPanel general = new JPanel();

        JPanel topJp = new JPanel();
        //topJp.add(settingsJb, BorderLayout.EAST);

        JPanel midJp = new JPanel();
        GridLayout layout = new GridLayout(2,2);
        midJp.setLayout(layout);

        int height = 15;
        int width = 15;

        JPanel table = new JPanel();
        GridLayout tableLayout = new GridLayout(width,height);
        table.setLayout(tableLayout);
        tableGrid = new JPanel[width][height];

        for(int i = 0; i < width; i++){
            for(int j = 0; j < height; j++) {
                tableGrid[i][j] = new JPanel();
                tableGrid[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                table.add(tableGrid[i][j]);
                int finalI = i;
                int finalJ = j;
                tableGrid[i][j].addMouseListener(new MouseAdapter() {
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
                });
            }
        }
        midJp.add(table);

        JPanel info = new JPanel();
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
        JPanel tropeCountPanel1 = new JPanel();
        info.add(tropeCountPanel1);
        JLabel troupes = new JLabel("Troupes");
        tropeCountPanel1.add(troupes);
        JPanel tropeCountPanel2 = new JPanel();
        tropeCountPanel2.setBackground(Color.gray);
        tropeCountPanel2.setBorder(BorderFactory.createLineBorder(Color.black));
        tropeCountPanel2.setLayout(new GridLayout(2,1));
        JPanel badTroupes = new JPanel();
        badTroupes.setBackground(Color.red);
        tropeCountPanel2.add(badTroupes);
        JPanel goodTroupes = new JPanel();
        goodTroupes.setBackground(Color.blue);
        tropeCountPanel2.add(goodTroupes);
        info.add(tropeCountPanel2);
        midJp.add(info);

        JPanel troupePanel = new JPanel();
        troupePanel.setBackground(Color.white);
        troupePanel.setBorder(BorderFactory.createLineBorder(Color.black));
        GridLayout troupeCardNameLayout = new GridLayout(2, 2);
        troupePanel.setLayout(troupeCardNameLayout);
        JLabel offensiveLabel = new JLabel("Offensive");
        JLabel defensiveLabel = new JLabel("Defensive");
        offensiveLabel.setHorizontalAlignment(JLabel.CENTER);
        defensiveLabel.setHorizontalAlignment(JLabel.CENTER);
        troupePanel.add(offensiveLabel);
        troupePanel.add(defensiveLabel);
        JPanel offensiveCardPanel = new JPanel();
        GridLayout offensiveCardLayout = new GridLayout(2, 3);
        offensiveCardPanel.setLayout(offensiveCardLayout);
        JPanel offT1 = new JPanel();
        offT1.setBackground(Color.green);
        offT1.addMouseListener(new MouseAdapter() {
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
        });
        offensiveCardPanel.add(offT1);
        JPanel offT2 = new JPanel();
        offT2.setBackground(Color.pink);
        offT2.addMouseListener(new MouseAdapter() {
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
        });
        offensiveCardPanel.add(offT2);
        JPanel offT3 = new JPanel();
        offT3.setBackground(Color.GRAY);
        offT3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                offT3.setBackground(Color.lightGray);
                super.mouseClicked(e);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                offT3.setBackground(Color.GRAY);
                super.mouseClicked(e);
            }
        });
        offensiveCardPanel.add(offT3);
        offensiveCardPanel.add(new JLabel("5"));
        offensiveCardPanel.add(new JLabel("3"));
        offensiveCardPanel.add(new JLabel("7"));
        troupePanel.add(offensiveCardPanel);
        JPanel defensiveCardPanel = new JPanel();
        GridLayout defensiveCardLayout = new GridLayout(2, 3);
        defensiveCardPanel.setLayout(defensiveCardLayout);
        JPanel defT1 = new JPanel();
        defT1.setBackground(Color.green);
        defensiveCardPanel.add(defT1);
        defT1.addMouseListener(new MouseAdapter() {
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
        });
        JPanel defT2 = new JPanel();
        defT2.setBackground(Color.pink);
        defT2.addMouseListener(new MouseAdapter() {
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
        });
        defensiveCardPanel.add(defT2);
        JPanel defT3 = new JPanel();
        defT3.setBackground(Color.GRAY);
        defT3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                defT3.setBackground(Color.lightGray);
                super.mouseClicked(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                defT3.setBackground(Color.GRAY);
                super.mouseClicked(e);
            }
        });
        defensiveCardPanel.add(defT3);
        defensiveCardPanel.add(new JLabel("4"));
        defensiveCardPanel.add(new JLabel("2"));
        defensiveCardPanel.add(new JLabel("6"));
        troupePanel.add(defensiveCardPanel);

        midJp.add(troupePanel);
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

        add(midJp);

        JPanel botJp = new JPanel();
        //botJp.add(backJb, BorderLayout.EAST);

        general.add(settingsJb, BorderLayout.NORTH);
        general.add(midJp, BorderLayout.CENTER);
        general.add(backJb, BorderLayout.SOUTH);

        add(general);
    }

    public void registerController(ActionListener listener) {
        settingsJb.addActionListener(listener);
        backJb.addActionListener(listener);
    }
}
