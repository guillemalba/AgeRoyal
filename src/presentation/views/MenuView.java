package presentation.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MenuView extends JPanel {
    public static final String BTN_LOGOUT = "BTN_LOGOUT";

    private JButton jbLogout;
    private MainView mainView;
    private CardLayout viewComponents;

    public MenuView(){
        configureMenuView();
    }

    private void configureMenuView() {

        setLayout(new BorderLayout());

        JLabel jlMenuText = new JLabel("Menu");

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));
        jbLogout = new JButton("Logout");
        jbLogout.setActionCommand(BTN_LOGOUT);
        leftPanel.add(jbLogout);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
        centerPanel.add(jlMenuText);

        add(leftPanel, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);
    }

    public void setMainView(MainView mainView) {
        this.mainView = mainView;
    }

    public void setViewComponents(CardLayout viewComponents) {
        this.viewComponents = viewComponents;
    }

    public void registerActionListener(ActionListener actionListener){
        jbLogout.addActionListener(actionListener);
    }

    public void showLogout() {
        viewComponents.show(this.mainView.getContentPane(), "logoutView");
    }
}
