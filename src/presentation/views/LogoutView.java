package presentation.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LogoutView extends JPanel {
    public static final String BTN_LOGOUT = "BTN_LOGOUT";
    //public static final String BTN_EDIT = "BTN_EDIT";
    public static final String BTN_DEL = "BTN_DEL";
    public static final String BTN_BACK = "BTN_BACK";

    private JButton jbLogout;
    //private JButton jbEdit;
    private JButton jbDelete;
    private JButton jbBack;

    private MainView mainView;
    private CardLayout components;

    public LogoutView() {
        configureLogoutView();
    }

    private void configureLogoutView() {
        setLayout(new BoxLayout(this ,BoxLayout.PAGE_AXIS));

        //Creamos los labels que queremos que aparezcan en la pagina
        JLabel jlTitle = new JLabel("User access info");

        JPanel jpButtons = new JPanel();

        jbLogout = new JButton("Logout");
        jbLogout.setActionCommand(BTN_LOGOUT);
        //jbEdit = new JButton("Edit User");
        //jbEdit.setActionCommand(BTN_EDIT);
        jbDelete = new JButton("Delete");
        jbDelete.setActionCommand(BTN_DEL);
        jbBack = new JButton("Back");
        jbBack.setActionCommand(BTN_BACK);

        jpButtons.add(jbLogout, BorderLayout.NORTH);
        //jpButtons.add(jbEdit, BorderLayout.CENTER);
        jpButtons.add(jbDelete, BorderLayout.SOUTH);

        add(jpButtons);
        add(jbBack);

    }

    public void registerController(ActionListener listener) {
        jbLogout.addActionListener(listener);
        //jbEdit.addActionListener(listener);
        jbDelete.addActionListener(listener);
        jbBack.addActionListener(listener);
    }

    public int logout(){
        int dialogButton = JOptionPane.showConfirmDialog (null, "Are you sure you want to logout?","WARNING",JOptionPane.YES_NO_OPTION);
        int option;
        if(dialogButton == JOptionPane.YES_OPTION) {
            option = 1;

        }else {
            option = 0;
        }
        return option;
    }

    public int delete(){
        int dialogDeleteButton = JOptionPane.showConfirmDialog (null, "Are you sure you want to Delete this account?","WARNING",JOptionPane.YES_NO_OPTION);
        int option;
        if(dialogDeleteButton == JOptionPane.YES_OPTION) {
            option = 1;

        }else {
            option = 0;
        }
        return option;
    }

    public void errorusernull() {
        JOptionPane.showMessageDialog(this, "You have not log any user yet");
    }

    public void userdeletedmessage() {JOptionPane.showMessageDialog(this, "Your user has been deleted");}

    public void setComponents(CardLayout viewComponents) {
        this.components = viewComponents;
    }

    public void showMain(){
        components.show(this.mainView.getContentPane(), "main");
    }

    public void setmainView(MainView mainView){
        this.mainView = mainView;
    }

    public void showLoggedMain() {
        components.show(this.mainView.getContentPane(), "loggedMainView");
    }

    public void showEditUser(){ components.show(this.mainView.getContentPane(), "editUserView");}

    public void showMenu() {
        components.show(this.mainView.getContentPane(), "menuView");
    }

    public void showLogin() {
        components.show(this.mainView.getContentPane(), "loginView");
    }

    public void showLogout() {
        components.show(this.mainView.getContentPane(), "logoutView");
    }
}
