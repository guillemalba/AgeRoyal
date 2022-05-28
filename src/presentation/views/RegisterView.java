package presentation.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Esta clase va a ser usada para crear la vista de registro de nuestro programa
 */
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

    /**
     * Este metodo es el constructor de nuestra vista el cual va a llamar al metodo configureRegisterView()
     */
    public RegisterView(){
        configureRegisterView();
    }

    /**
     * Esta vista va a construir nuestra vista y va a añadir los componentes que creemos aqui
     */
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

    /**
     * Este metodo asignara el controlador de los botones de nuestra vista
     * @param listener es la clase que asigna los controladores a nuestros botones
     */
    public void registerController(ActionListener listener) {
        jbSingin.addActionListener(listener);
        jbBack.addActionListener(listener);
    }

    /**
     * Este metodo muestra un popUp si la contraseña es muy corta
     */
    public void errorPasswordLength() {
        JOptionPane.showMessageDialog(this, "The minimum password lenght is 8 characters.");
    }

    /**
     * Este metodo muestra un popUp si la segunda contraseña no coincide con la primera
     */
    public void errorConfirmPassword() {
        JOptionPane.showMessageDialog(this, "Both passwords are not equal.");
    }

    /**
     * Este metodo muestra un popUp si la contraseña no tiene un formato correcto
     */
    public void errorUpperLowerNumber() {
        JOptionPane.showMessageDialog(this, "Password must have at least 1 upper case, 1 lower case and 1 number.");
    }

    /**
     * Este metodo muestra un popUp si la base de datos falla
     */
    public void errorConnection() {
        JOptionPane.showMessageDialog(this, "Something went wrong with the database connection");
    }

    /**
     * Este metodo muestra un popUp si el correo introducido ya esta asignado a algun usuario
     */
    public void errorEmailExist() {
        JOptionPane.showMessageDialog(this, "The email already exist.");
    }

    /**
     * Este metodo muestra un popUp si el nombre de usuario introducido ya esta asignado a algun usuario
     */
    public void errorUsernameExist() {
        JOptionPane.showMessageDialog(this, "The username already exist.");
    }

    /**
     * Este metodo muestra un popUp si el correo introducido no tiene un formato valido
     */
    public void errorFormat() {
        JOptionPane.showMessageDialog(this, "The mail has an invalid format.");
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

    public void setmainView(MainView mainView){
        this.mainView = mainView;
    }

    public void setComponents(CardLayout viewComponents) {
        this.components = viewComponents;
    }

    public void resetInputInfo() {
        this.jtfEmail.setText("");
        this.jtfUsername.setText("");
        this.jpfConfPassword.setText("");
        this.jpfPassword.setText("");
    }

}
