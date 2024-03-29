package presentation.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Esta clase nos permitira crear la vista de inicio de sesion de nuestra aplicaion.
 */
public class LoginView extends JPanel {
    private static final String BTN_LOG = "BTN_LOG";
    private static final String BTN_REG = "BTN_REG";
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
        jlLogin.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        jlLogin.setFont(new Font("Serif", Font.PLAIN, 40));

        //Creamos un panel nuevo para tener una tabla para introducir los datos de los usuarios
        JPanel jpTable = new JPanel(new GridLayout(0,2 ,0, 400));
        JLabel jlUsernameEmail = new JLabel("Username / Email");
        JLabel jlPassword = new JLabel("Password");

        jlUsernameEmail.setHorizontalAlignment((int)CENTER_ALIGNMENT);
        jlPassword.setHorizontalAlignment((int)CENTER_ALIGNMENT);

        //Añadimos todos los elementos dentro de la tabla
        jpTable.add(jlUsernameEmail);
        jpTable.add(jtfUsernameEmail);
        jpTable.add(jlPassword);
        jpTable.add(jpfPassword);

        JPanel jpButtons = new JPanel();

        //Creamos un boton para poder enviar la información
        jbLogin = new JButton();
        jbLogin.setIcon(new ImageIcon(new ImageIcon("files/btn_login.png").getImage().getScaledInstance(150, 75, Image.SCALE_DEFAULT)));
        jbLogin.setBorderPainted(false);
        jbLogin.setContentAreaFilled(false);
        jbLogin.setActionCommand(BTN_LOG);
        jpButtons.add(jbLogin);

        //Creamos un boton para poder volver
        jbBack = new JButton("");
        jbBack.setIcon(new ImageIcon(new ImageIcon("files/btn_back.png").getImage().getScaledInstance(150, 75, Image.SCALE_DEFAULT)));
        jbBack.setBorderPainted(false);
        jbBack.setContentAreaFilled(false);
        jbBack.setActionCommand(BTN_REG);
        jpButtons.add(jbBack);

        //Añadimos los elementos a la pantalla
        add(jlLogin, BorderLayout.NORTH);
        add(jpTable, BorderLayout.CENTER);
        add(jpButtons, BorderLayout.SOUTH);

    }

    /**
     * Este metodod servira para poder asignar los listeners necesarios a cada boton de nuestra vista.
     * @param listener listener
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
     * Setter para asignar la main view
     *
     * @param mainView vista principal
     */
    public void setMainView(MainView mainView){
        this.mainView = mainView;
    }

    /**
     * Setter para asignar los componentes del card layout
     *
     * @param viewComponents card layout
     */
    public void setComponents(CardLayout viewComponents) {
        this.components = viewComponents;
    }

    /**
     * Metodo que resetea los campos de texto del login
     */
    public void resetInputInfo() {
        this.jpfPassword.setText("");
        this.jtfUsernameEmail.setText("");
    }
}
