package presentation.views;

import business.entities.Board;
import business.entities.Troop;
import org.w3c.dom.Text;
import presentation.controllers.GameViewController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

public class GameView extends JPanel {

    private JButton settingsJb = new JButton("Settings");
    private JButton backJb = new JButton("Back");
    private JPanel[][] tableGrid;
    private GameViewController gameViewController;
    private Board board;
    private JPanel table = new JPanel();
    private JPanel midJp = new JPanel();

    public GameView(GameViewController gameViewController){
        this.gameViewController = gameViewController;
        board = new Board();
        configureView();
    }

    public GameView(GameViewController gameViewController,Board board){
        this.gameViewController = gameViewController;
        this.board = board;

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
        updateView(board);

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
        offensiveCardPanel.add(offT1);
        JPanel offT2 = new JPanel();
        offT2.setBackground(Color.pink);
        offT2.setName("offT2");
        offT2.addMouseListener(gameViewController);
        offensiveCardPanel.add(offT2);
        offensiveCardPanel.add(new JLabel("5"));
        offensiveCardPanel.add(new JLabel("3"));
        troopPanel.add(offensiveCardPanel);

        JPanel defensiveCardPanel = new JPanel();
        GridLayout defensiveCardLayout = new GridLayout(2, 2);
        defensiveCardPanel.setLayout(defensiveCardLayout);
        JPanel defT1 = new JPanel();
        defT1.setBackground(Color.red);
        defT1.setName("defT1");
        defensiveCardPanel.add(defT1);
        defT1.addMouseListener(gameViewController);
        JPanel defT2 = new JPanel();
        defT2.setBackground(Color.blue);
        defT2.setName("defT2");
        defT2.addMouseListener(gameViewController);
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

    public void updateView(Board board) {
        tableGrid = new JPanel[15][15];
        String name;
        table.removeAll();

        //funcion para pinta mapa nuevo

        for(int i = 0; i < board.getSide(); i++){
            for(int j = 0; j < board.getSide(); j++) {
                tableGrid[i][j] = new JPanel();
                tableGrid[i][j].setSize(board.getSide(),board.getSide());
                tableGrid[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                tableGrid[i][j].setName(i+","+j);
                table.add(tableGrid[i][j]);
                tableGrid[i][j].addMouseListener(gameViewController);
            }
        }

        for(int i = 0; i < board.getSide(); i++){
            for(int j = 0; j < board.getSide(); j++) {
                if(board.isEmpty(i,j)){
                    tableGrid[i][j].setBackground(Color.WHITE);
                }else{
                    tableGrid[i][j].setBackground(board.getColorTroop(i,j));
                }
            }
        }

        table.revalidate();
        table.repaint();

        /*MapPaint mp = new MapPaint(new GridLayout(map.getWidth(), map.getHeight()), map, players, userPlayer, revealMap);
        jpCenter = mp.creaMapa();

        background.add(jpCenter, BorderLayout.CENTER);

        */
    }
}
