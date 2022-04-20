package presentation.views;

import javax.swing.*;
import java.awt.*;

public class RecordedGameMenuView extends JFrame {
    JButton jbSettings;
    JButton jbBack;

    public RecordedGameMenuView() {
        setTitle("Recorded Game View");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize.width, screenSize.height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel background = new JPanel(new BorderLayout());
        background.setLayout(new BorderLayout());
        background.setBackground(Color.GRAY);

        /** Creem un altre BorderLayout per distribuir el header de la finestra**/
        JPanel jpNorth = new JPanel(new BorderLayout());
        jpNorth.setOpaque(false);

        /** Configurem el "SETTINGS" button **/
        jbSettings = new JButton("Settings");
        jbSettings.setBackground(Color.BLUE);
        jbSettings.setForeground(Color.WHITE);
        jbSettings.setActionCommand("settings");
        jpNorth.add(jbSettings, BorderLayout.WEST);


    }
}
