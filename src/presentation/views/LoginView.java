package presentation.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginView extends JPanel {
    public static final String BTN_LOG = "BTN_LOG";
    public static final String BTN_REG = "BTN_REG";
    private JButton jbLogin;
    private JButton jbBack;
    private JTextField jtfUsernameEmail = new JTextField();
    private JPasswordField jpfPassword = new JPasswordField();
    private CardLayout components;
    private MainView mainView;

    //TODO: Eliminar boton de prueba
    public static final String BTN_LOGOUT = "BTN_LOGOUT";
    private JButton jbLogout;

    public LoginView(){
        configureLoginView();
    }

    private void configureLoginView() {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        //Creamos los labels que queremos que aparezcan en la pagina
        JLabel jlLogin = new JLabel("LOGIN");

        //Creamos un panel nuevo para tener una tabla para intriducir los datos de los usuarios
        JPanel jpTable = new JPanel(new GridLayout(0,2));
        JLabel jlUsernameEmail = new JLabel("Username / Email");
        JLabel jlPassword = new JLabel("Password");

        //Añadimos todos los elementos dentro de la tabla
        jpTable.add(jlUsernameEmail);
        jpTable.add(jtfUsernameEmail);
        jpTable.add(jlPassword);
        jpTable.add(jpfPassword);

        JPanel jpButtons = new JPanel();

        //Creamos un boton para poder enviar la información
        jbLogin = new JButton("Login");
        jbLogin.setActionCommand(BTN_LOG);
        jpButtons.add(jbLogin);

        //Creamos un boton para poder volver
        jbBack = new JButton("Register");
        jbBack.setActionCommand(BTN_REG);
        jpButtons.add(jbBack);

        //TODO: ELIMINAR ESTO
        //Creamos un boton para poder volver
        jbLogout = new JButton("Logout");
        jbLogout.setActionCommand(BTN_LOGOUT);
        jpButtons.add(jbLogout);

        //Añadimos los elementos a la pantalla
        add(jlLogin);
        add(jpTable);
        add(jpButtons);

    }

    public void loginController(ActionListener listener) {
        jbLogin.addActionListener(listener);
        jbBack.addActionListener(listener);
        jbLogout.addActionListener(listener);
    }

    public String getInputUsernameEmail() {
        return jtfUsernameEmail.getText();
    }

    public char[] getInputPassword() {
        return jpfPassword.getPassword();
    }

    public void errorMessage() {
        JOptionPane.showMessageDialog(this, "The user or the password is wrong");
    }

    public void setMainView(MainView mainView){
        this.mainView = mainView;
    }

    public void setComponents(CardLayout viewComponents) {
        this.components = viewComponents;
    }

    public void showRegister(){
        components.show(this.mainView.getContentPane(), "registerView");
    }

    //TODO:ELIMINAR ESTO
    public void showLogout() {
        components.show(this.mainView.getContentPane(), "logoutView");
    }
}
