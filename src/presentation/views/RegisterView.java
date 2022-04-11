package presentation.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RegisterView extends JPanel {
    public static final String BTN_SING = "BTN_SING";
    public static final String BTN_BACK = "BTN_BACK";
    
    private JTextField jtfUsername;
    private JTextField jtfEmail;
    private JPasswordField jpfPassword;
    private JPasswordField jpfConfPassword;
    private JButton jbSingin;
    private JButton jbBack;
    private CardLayout components;
    private MainView mainView;
    
    public RegisterView(){
        configureRegisterView();
    }

    private void configureRegisterView() {
        setLayout(new BoxLayout(this ,BoxLayout.PAGE_AXIS));

        //Creamos los labels que queremos que aparezcan en la pagina
        JLabel jlSingIn = new JLabel("Register");

        //Creamos un panel nuevo para tener una tabla para intriducir los datos de los usuarios
        JPanel jpTable = new JPanel(new GridLayout(0,2));
        JLabel jlUsername = new JLabel("Username");
        jtfUsername = new JTextField();
        JLabel jlEmail = new JLabel("Email");
        jtfEmail = new JTextField();
        JLabel jlPassword = new JLabel("Password");
        jpfPassword = new JPasswordField();
        JLabel jlConfPassword = new JLabel("Confirm Password");
        jpfConfPassword = new JPasswordField();

        //Añadimos todos los elementos dentro de la tabla
        jpTable.add(jlUsername);
        jpTable.add(jtfUsername);
        jpTable.add(jlEmail);
        jpTable.add(jtfEmail);
        jpTable.add(jlPassword);
        jpTable.add(jpfPassword);
        jpTable.add(jlConfPassword);
        jpTable.add(jpfConfPassword);

        JPanel jpButtons = new JPanel();

        //Creamos un boton para poder enviar la información
        jbSingin = new JButton("Register");
        jbSingin.setActionCommand(BTN_SING);
        jpButtons.add(jbSingin);

        //Creamos un boton para poder volver
        jbBack = new JButton("Login");
        jbBack.setActionCommand(BTN_BACK);
        jpButtons.add(jbBack);

        //Añadimos los elementos a la pantalla
        add(jlSingIn);
        add(jpTable);
        add(jpButtons);
    }

    public void registerController(ActionListener listener) {
        jbSingin.addActionListener(listener);
        jbBack.addActionListener(listener);
    }

    public void setmainView(MainView mainView){
        this.mainView = mainView;
    }

    public void getComponents(CardLayout components){
        this.components = components;
        setLayout(this.components);
    }

    public String getInputUsername() {
        return jtfUsername.getText();
    }

    public String getInputEmail() {
        return jtfEmail.getText();
    }

    public char[] getInputPassword() {
        return jpfPassword.getPassword();
    }

    public char[] getInputConfPassword() {
        return jpfConfPassword.getPassword();
    }

    public void errorPassword() {
        JOptionPane.showMessageDialog(this, "The password is too short or its not the same as the confirmation password");
    }

    public void errorExists() {
        JOptionPane.showMessageDialog(this, "The user already exists");
    }

    public void errorFormat() {
        JOptionPane.showMessageDialog(this, "The mail has an invalid format");
    }

    public void showMain(){
        components.show(this.mainView.getContentPane(), "loginView");
    }
    public void showMenu(){
        components.show(this.mainView.getContentPane(), "menuView");
    }

    public void setComponents(CardLayout viewComponents) {
        this.components = viewComponents;
    }

}
