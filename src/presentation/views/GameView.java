package presentation.views;

import business.entities.Attributes;
import business.entities.Board;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


/**
 * Esta vista sera la encargada de mostrar cualquier información relacionada con una partida y cualquier accion que se
 * se pueda realizar durante una de estas, como por ejemplo controlar el tablero o poner una tropa en el campo de
 * batalla
 */
public class GameView extends JPanel {

    private JButton settingsJb = new JButton();
    private JButton backJb = new JButton();
    private JPanel[][] tableGrid = new JPanel[15][15];
    private Board board;
    private boolean isRepro;
    private JPanel table = new JPanel();
    private JPanel midJp = new JPanel();
    private JPanel defT1 = new JPanel();
    private JPanel offT1 = new JPanel();
    private JPanel offT2 = new JPanel();
    private JPanel defT2 = new JPanel();
    private final JLabel costCanon = new JLabel(String.valueOf(Attributes.CANNON_COST.getValue()));
    private final JLabel costTesla = new JLabel(String.valueOf(Attributes.TESLA_COST.getValue()));
    private final JLabel costArcher = new JLabel(String.valueOf(Attributes.ARCHER_COST.getValue()));
    private final JLabel costGiant = new JLabel(String.valueOf(Attributes.GIANT_COST.getValue()));
    private JLabel mLabel = new JLabel();
    private JPanel livesPanel1 = new JPanel();
    private JPanel troopCountPanel1 = new JPanel();
    private JPanel troopCountPanel2 = new JPanel();
    private JPanel livesPanel2 = new JPanel();
    private JPanel livesIA = new JPanel();
    private JPanel livesUser = new JPanel();
    private JPanel goodLives = new JPanel();
    private JPanel goodTroops = new JPanel();
    private JPanel badTroops = new JPanel();
    private JPanel badLives = new JPanel();
    private final Color playerColor = new Color(64, 204, 248);
    private JPanel troopPanel = new JPanel();

    /**
     * Como podeis observar el constructor de esta clase solo contiene la posibilidad de inicializar un tablero si este
     * deja de ser nulo en algun momento. A parte de eso, se llama al metodo configureView() que creara la vista desde cero.
     */
    public GameView() {
        if (board == null) {
            board = new Board();
        }
        configureView();
    }

    /**
     * Este metodo servira para construir toda la vista de una partida. Cada panel ubicado en el panel central se creara
     * llamando a un metodo que nos servira para crear ese componente en especifico. A parte de eso se crea la vista
     * general dividida en tres partes (topPanel, midPanel y botPanel).
     */
    private void configureView() {
        setLayout(new BorderLayout());
        setSize(550, 720);
        JPanel general = new JPanel();
        general.setLayout(new BorderLayout());
        JPanel topJp = new JPanel();
        settingsJb.setIcon(new ImageIcon(new ImageIcon("files/btn_settings.png").getImage().getScaledInstance(150, 75, Image.SCALE_DEFAULT)));
        settingsJb.setBorderPainted(false);
        settingsJb.setContentAreaFilled(false);
        settingsJb.setActionCommand("Settings");
        topJp.add(settingsJb, BorderLayout.EAST);


        GridLayout layout = new GridLayout(2, 2);
        midJp.setLayout(layout);

        createTable();

        JPanel info = new JPanel();
        createInformationTable(info);
        midJp.add(info);


        createTroopPanel(troopPanel);
        midJp.add(troopPanel);

        JPanel goldPanel = new JPanel();
        createGoldPanel(goldPanel);
        midJp.add(goldPanel);

        JPanel botJp = new JPanel();
        backJb.setIcon(new ImageIcon(new ImageIcon("files/btn_leave.png").getImage().getScaledInstance(150, 75, Image.SCALE_DEFAULT)));
        backJb.setBorderPainted(false);
        backJb.setContentAreaFilled(false);
        backJb.setActionCommand("Back");
        botJp.add(backJb, BorderLayout.EAST);

        general.add(topJp, BorderLayout.NORTH);
        general.add(midJp, BorderLayout.CENTER);
        general.add(botJp, BorderLayout.SOUTH);

        add(general, BorderLayout.CENTER);
    }

    /**
     * Este metodo nos servira para crear el tablero central de juego. Esto se ara en un bucle que generara cada panel
     * (casilla) con sus respectivos mouseListeners que nos ayudaran a detectar cuando se intenta interactuar con alguno
     * de estos.
     */
    private void createTable() {
        int height = 15;
        int width = 15;


        table.setSize(400, 400);
        GridLayout tableLayout = new GridLayout(width, height);
        table.setLayout(tableLayout);
        tableGrid = new JPanel[15][15];
        //funcion para pinta mapa nuevo
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                tableGrid[i][j] = new JPanel();
                tableGrid[i][j].setLayout(new BorderLayout());
                tableGrid[i][j].setSize(15, 15);
                tableGrid[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
                tableGrid[i][j].setName(i + "," + j);
            }
        }
    }

    /**
     * Este metodo servira para crear el panel derecho con toda la informacion de la partida. Este panel se crea en el
     * metodo configure view pero se esta utilizando en este metodo y se le esta añadiendo toda la informacion que era
     * necesaria.
     *
     * @param info es el panel que deseamos modificar y al que queremos añadir el resto de componentes
     */
    private void createInformationTable(JPanel info) {
        info.setLayout(new BorderLayout());
        info.setSize(200, 400);
        GridLayout layoutInfo = new GridLayout(4, 1);
        info.setLayout(layoutInfo);


        info.add(livesPanel1);
        JLabel lives = new JLabel("Lives");
        livesPanel1.add(lives);


        livesPanel2.setBackground(Color.GRAY);
        livesPanel2.setLayout(new GridLayout(2, 1));

        livesIA.setLayout(new BorderLayout());
        livesUser.setLayout(new BorderLayout());
        livesIA.setBackground(Color.RED);
        livesUser.setBackground(Color.CYAN);
        livesPanel2.add(livesIA);
        livesPanel2.add(livesUser);
        livesPanel2.setBorder(BorderFactory.createLineBorder(Color.black));
        livesPanel2.setLayout(new GridLayout(2, 1));


        //Vidas ia
        livesPanel2.add(badLives);


        //Vidas user
        livesPanel2.add(goodLives);
        info.add(livesPanel2);


        info.add(troopCountPanel1);
        JLabel Troops = new JLabel("Troops");
        troopCountPanel1.add(Troops);


        troopCountPanel2.setBackground(Color.gray);
        troopCountPanel2.setBorder(BorderFactory.createLineBorder(Color.black));
        troopCountPanel2.setLayout(new GridLayout(2, 1));

        //Llista tropas ia
        troopCountPanel2.add(badTroops);

        //Llista tropas user
        troopCountPanel2.add(goodTroops);


        info.add(troopCountPanel2);
        updateView(board, 5, 50, 50,0,0);
        midJp.add(table);
    }

    /**
     * Este metodo crear sirve para introducir toda la informacion de las tropas como su coste o el tipo de tropa que es.
     * El panel que se esta modificando en este caso es el que se encuentra debajo del tablero.
     *
     * @param troopPanel es el panel que deseamos modificar y al que queremos añadir el resto de componentes
     */
    private void createTroopPanel(JPanel troopPanel) {
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

        offT1.setBackground(playerColor);
        offT1.setName("offT1");
        offT1.setLayout(new BorderLayout());
        try {
            BufferedImage image = ImageIO.read(new File("files/user_archer.png"));
            JLabel label = new JLabel(new ImageIcon(image.getScaledInstance(65, 65, Image.SCALE_DEFAULT)));
            offT1.add(label);

        } catch (IOException e) {
            e.printStackTrace();
        }

        offensiveCardPanel.add(offT1);

        offT2.setBackground(playerColor);
        offT2.setName("offT2");
        offT2.setLayout(new BorderLayout());
        try {
            BufferedImage image = ImageIO.read(new File("files/user_giant.png"));
            JLabel label = new JLabel(new ImageIcon(image.getScaledInstance(65, 65, Image.SCALE_DEFAULT)));
            offT2.add(label);

        } catch (IOException e) {
            e.printStackTrace();
        }

        offensiveCardPanel.add(offT2);
        offensiveCardPanel.add(costArcher);
        offensiveCardPanel.add(costGiant);
        costArcher.setHorizontalAlignment(0);
        costGiant.setHorizontalAlignment(0);
        troopPanel.add(offensiveCardPanel);

        JPanel defensiveCardPanel = new JPanel();
        GridLayout defensiveCardLayout = new GridLayout(2, 2);
        defensiveCardPanel.setLayout(defensiveCardLayout);

        defT1.setBackground(playerColor);
        defT1.setName("defT1");
        defT1.setLayout(new BorderLayout());
        try {
            BufferedImage image = ImageIO.read(new File("files/user_cannon.png"));
            JLabel label = new JLabel(new ImageIcon(image.getScaledInstance(65, 65, Image.SCALE_DEFAULT)));
            defT1.add(label);

        } catch (IOException e) {
            e.printStackTrace();
        }
        defensiveCardPanel.add(defT1);


        defT2.setBackground(playerColor);
        defT2.setName("defT2");
        defT2.setLayout(new BorderLayout());
        try {
            BufferedImage image = ImageIO.read(new File("files/user_tesla.png"));
            JLabel label = new JLabel(new ImageIcon(image.getScaledInstance(65, 65, Image.SCALE_DEFAULT)));
            defT2.add(label);

        } catch (IOException e) {
            e.printStackTrace();
        }

        defensiveCardPanel.add(defT2);

        defensiveCardPanel.add(costCanon);
        costCanon.setHorizontalAlignment(0);
        defensiveCardPanel.add(costTesla);
        costTesla.setHorizontalAlignment(0);

        troopPanel.add(defensiveCardPanel);
    }

    /**
     * Este metodo crear sirve para introducir toda la informacion de los recursos (oro) que tiene nuestro usuario para
     * combatir contra la IA. El panel que se esta modificando en este caso es el que se encuentra debajo del tablero.
     *
     * @param goldPanel
     */
    private void createGoldPanel(JPanel goldPanel) {
        GridLayout goldLayout = new GridLayout(2, 1);
        goldPanel.setLayout(goldLayout);
        JLabel gLabel = new JLabel("Gold");
        gLabel.setHorizontalAlignment(JLabel.CENTER);
        goldPanel.add(gLabel);

        mLabel.setHorizontalAlignment(JLabel.CENTER);
        goldPanel.add(mLabel);
    }

    /**
     * En este metodo se esta añadiendo los listeners de todos los botones y paneles qu podemos localizar en la vista.
     *
     * @param listener1 son los listeners de los botones
     * @param listener2 son los listeners de los paneles
     */
    public void registerController(ActionListener listener1, MouseListener listener2) {
        settingsJb.addActionListener(listener1);
        backJb.addActionListener(listener1);
        defT2.addMouseListener(listener2);
        defT1.addMouseListener(listener2);
        offT2.addMouseListener(listener2);
        offT1.addMouseListener(listener2);
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                tableGrid[i][j].addMouseListener(listener2);

            }
        }
    }

    /**
     * Este metodo servira para actualizar la vista. Para ello necesitamos recibir toda la infomraion que nos permita
     * mostrar desde las tropas enemigas y aliadas ubicada en el tablero hasta la vida restante de nuestro oponente.
     *
     * @param board     Una matriz que contiene toda la informacion de las tropas (enemigas y aliadas)
     * @param moneyUser Es el dinero del que dispone nuestro usuario para poder introducir tropas en el campo de batalla
     * @param vidasUser Es el numer de vidas restantes de la torre aliada
     * @param vidasIA   Es el numer de vidas restantes de la torre enemigas
     * @param tropasIA   Es el numer de tropas restantes de la torre enemigas
     */
    public void updateView(Board board, int moneyUser, float vidasUser, float vidasIA,int tropasUser,int tropasIA) {
        //midJp.remove(table);
        table.removeAll();
        midJp.remove(table);
        badLives.removeAll();
        goodLives.removeAll();
        badTroops.removeAll();
        goodTroops.removeAll();

        //pintem el panell
        for (int i = 0; i < board.getSide(); i++) {
            for (int j = 0; j < 15; j++) {
                tableGrid[i][j].removeAll();
                if (board.isEmpty(i, j)) {
                    tableGrid[i][j].setBackground(Color.WHITE);
                } else {
                    tableGrid[i][j].add(new JLabel(new ImageIcon(board.getCellsMatrix()[i][j].getTroop().getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT))));
                    tableGrid[i][j].getComponent(0).setSize(1, 1);

                }

            }
        }

        //omplim la table amb el panell pintat
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                table.add(tableGrid[i][j]);
            }
        }
        mLabel.setText(Integer.toString(moneyUser));

        midJp.add(table, 0);


        //Vidas IA
        JLabel iaLive = new JLabel(Integer.toString((int)vidasIA));
        badLives.add(iaLive);
        badLives.setBackground(Color.RED);
        //badLives.setLayout(new BorderLayout());
        livesIA.add(badLives);

        //Vidas user
        JLabel userLive = new JLabel(Integer.toString((int)vidasUser));
        goodLives.setBackground(Color.BLUE);
        goodLives.add(userLive);
        livesUser.add(goodLives);

        //Llista tropas ia
        JLabel IATrops = new JLabel(Integer.toString(tropasIA));
        badTroops.setBackground(Color.red);
        badTroops.add(IATrops);
        troopCountPanel2.add(badTroops);

        //Llista tropas user
        JLabel UserTrops = new JLabel(Integer.toString(tropasUser));
        goodTroops.setBackground(Color.blue);
        goodTroops.add(UserTrops);
        troopCountPanel2.add(goodTroops);

        revalidate();
        repaint();
    }

    /**
     * Este metodo genera un popUp que permitira guardar la partida
     *
     * @return el nombre de la partida guardada
     */
    public String popUpSaveGame(boolean userWins) {
        String winOrLose;
        if (userWins) {
            winOrLose = "You Win!";
        } else {
            winOrLose = "You Lose!";
        }
        return JOptionPane.showInputDialog(null, "Enter a unique name for the game:",
                winOrLose, JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Este metodo nos pertmite añadir un reborde rojo al rededor de la tropa seleccionada en el panel inferior
     *
     * @param click es el nombre assingado a la tropa que se ha selecionado
     */
    public void putBorder(String click) {
        switch (click) {
            case "offT1":
                offT1.setBorder(BorderFactory.createLineBorder(Color.RED, 4));
                offT2.setBorder(null);
                defT1.setBorder(null);
                defT2.setBorder(null);
                break;
            case "offT2":
                offT1.setBorder(null);
                offT2.setBorder(BorderFactory.createLineBorder(Color.RED, 4));
                defT1.setBorder(null);
                defT2.setBorder(null);
                break;
            case "defT1":
                offT1.setBorder(null);
                offT2.setBorder(null);
                defT1.setBorder(BorderFactory.createLineBorder(Color.RED, 4));
                defT2.setBorder(null);
                break;
            case "defT2":
                offT1.setBorder(null);
                offT2.setBorder(null);
                defT1.setBorder(null);
                defT2.setBorder(BorderFactory.createLineBorder(Color.RED, 4));
                break;
            default:
                offT1.setBorder(null);
                offT2.setBorder(null);
                defT1.setBorder(null);
                defT2.setBorder(null);
        }
    }

    /**
     * Getter de si es reproducida o no
     *
     * @return true si es, false si no
     */
    public boolean isRepro() {
        return isRepro;
    }

    /**
     * Setter para asignar si se esta reproduciendo o no
     *
     * @param repro boolean
     */
    public void setRepro(boolean repro) {
        isRepro = repro;
    }
}
