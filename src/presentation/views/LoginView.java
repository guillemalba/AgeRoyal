package presentation.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Esta clase nos permitira crear la vista de inicio de sesion de nuestra aplicaion.
 */
public class LoginView extends JPanel {
    public static final String BTN_LOG = "BTN_LOG";
    public static final String BTN_REG = "BTN_REG";
    private JButton jbLogin;
    private JButton jbBack;
    private JTextField jtfUsernameEmail = new JTextField();
    private JPasswordField jpfPassword = new JPasswordField();
    private CardLayout components;
    private MainView mainView;

    /**
     * Este al ser el constructor de nuestra vista, lo unico que hace es llamar al metodo (configureLoginView())
     */
    public LoginView(){
        configureLoginView();
    }

    /**
     * Este metodo servira para crear la vista en si, con todos los paneles, botones y JTextfields necesarios
     */
    private void configureLoginView() {
        setLayout(new BorderLayout());

        //Creamos los labels que queremos que aparezcan en la pagina
        JLabel jlLogin = new JLabel("LOGIN");
        jlLogin.setFont(new Font("Serif", Font.PLAIN, 40));

        //Creamos un panel nuevo para tener una tabla para introducir los datos de los usuarios
        JPanel jpTable = new JPanel(new GridLayout(0,2 ,0, 400));
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

        //Añadimos los elementos a la pantalla
        add(jlLogin, BorderLayout.NORTH);
        add(jpTable, BorderLayout.CENTER);
        add(jpButtons, BorderLayout.SOUTH);

    }

    /**
     * Este metodod servira para poder asignar los listeners necesarios a cada boton de nuestra vista.
     * @param listener
     */
    public void loginController(ActionListener listener) {
        jbLogin.addActionListener(listener);
        jbBack.addActionListener(listener);
    }

    /**
     * Este metodod nos devolvera el correo electronico / nombre de usuario introducido en nuestra vista.
     * @return un string que contiene lo que el usuario haya introducido en ese campo de texto
     */
    public String getInputUsernameEmail() {
        return jtfUsernameEmail.getText();
    }

    /**
     * Este metodod nos devolvera la contraseña introducida en nuestra vista.
     * @return devolvera un array de caracteres que forman la contraseña de nuestro usuario
     */
    public char[] getInputPassword() {
        return jpfPassword.getPassword();
    }

    /**
     * Este metodo envia un mensaje de error si la informacion introducioda no es correcta
     */
    public void errorMessage() {
        JOptionPane.showMessageDialog(this, "The user or the password is wrong");
    }

    public void setMainView(MainView mainView){
        this.mainView = mainView;
    }

    public void setComponents(CardLayout viewComponents) {
        this.components = viewComponents;
    }

    public void resetInputInfo() {
        this.jpfPassword.setText("");
        this.jtfUsernameEmail.setText("");
    }
}
