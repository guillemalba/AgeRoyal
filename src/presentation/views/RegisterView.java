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
        setLayout(new BorderLayout());
        setSize(550, 720);

        //Creamos los labels que queremos que aparezcan en la pagina
        JLabel jlSingIn = new JLabel("REGISTER");
        jlSingIn.setFont(new Font("Serif", Font.PLAIN, 40));

        //Creamos un panel nuevo para tener una tabla para intriducir los datos de los usuarios
        JPanel jpTable = new JPanel(new GridLayout(0,2, 0, 140));
        jpTable.setSize(550, 720);
        JLabel jlUsername = new JLabel("Username");
        JPanel jpUsername = new JPanel();
        jpUsername.setLayout(new BorderLayout());
        jpUsername.setSize(300, 5);
        jpUsername.setBounds(5, 10, 580, 80);
        jtfUsername = new JTextField();
        jpUsername.add(jtfUsername, BorderLayout.CENTER);
        JLabel jlEmail = new JLabel("Email");
        jtfEmail = new JTextField();
        jtfEmail.setSize(300, 50);
        JLabel jlPassword = new JLabel("Password");
        jpfPassword = new JPasswordField();
        jpfPassword.setSize(300, 50);
        JLabel jlConfPassword = new JLabel("Confirm Password");
        jpfConfPassword = new JPasswordField();
        jpfConfPassword.setSize(300, 50);
        jpTable.setSize(500, 720);
        jpTable.setBounds(5, 30, 580, 80);

        //Añadimos todos los elementos dentro de la tabla
        jpTable.add(jlUsername);
        jpTable.add(jpUsername);
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
        add(jlSingIn, BorderLayout.NORTH);
        add(jpTable, BorderLayout.CENTER);
        add(jpButtons, BorderLayout.SOUTH);
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

    public void errorPasswordLength() {
        JOptionPane.showMessageDialog(this, "The minimum password lenght is 8 characters.");
    }

    public void errorConfirmPassword() {
        JOptionPane.showMessageDialog(this, "Both passwords are not equal.");
    }

    public void errorUpperLowerNumber() {
        JOptionPane.showMessageDialog(this, "Password must have at least 1 upper case, 1 lower case and 1 number.");
    }

    public void errorConnection() {
        JOptionPane.showMessageDialog(this, "Something went wrong with the database connection");
    }

    public void errorEmailExist() {
        JOptionPane.showMessageDialog(this, "The email already exist.");
    }

    public void errorUsernameExist() {
        JOptionPane.showMessageDialog(this, "The username already exist.");
    }

    public void errorFormat() {
        JOptionPane.showMessageDialog(this, "The mail has an invalid format.");
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
