package presentation.controllers;

import business.UserManager;
import business.entities.User;
import presentation.views.MainView;
import presentation.views.RegisterView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

/**
 * Esta clase lo que ara sera controlar la vista de registro con sus botones y todos los posibles errores de la contraseña
 * y el nombre de ususario / correo
 */
public class RegisterController implements ActionListener {
    private final RegisterView registerView;
    private final MainView mainView;
    private final CardLayout viewComponents;
    private UserManager userManager;

    /**
     * Este sera el constructor de nuestro controlador que asigna todos parametros necesarios para su funcionamiento
     * @param registerView es la vista de registro de nuestra vista
     * @param mainView es la ventana central de la vista de nuestro codigo
     * @param viewComponents son los componentes de tipo cardLayout de nuestra vista inicial
     * @param userManager es el manager de la base de datos de nuestro ususario
     */
    public RegisterController(RegisterView registerView, MainView mainView, CardLayout viewComponents,UserManager userManager) {
        this.registerView = registerView;
        this.mainView = mainView;
        this.viewComponents = viewComponents;
        this.userManager = userManager;
    }

    /**
     * Este metodo recibe los strings de nuestro inicio de sesion y su contraseña y comprobamos que su estado sea le correcto
     * @param e es el objecto asignado al boton selecionado
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case RegisterView.BTN_SING:
                String username = registerView.getInputUsername();
                String email = registerView.getInputEmail();
                String password = String.valueOf(registerView.getInputPassword());
                String confPassword = String.valueOf(registerView.getInputConfPassword());
                if (password.length() < 8) {
                    registerView.errorPasswordLength();
                } else if (!isValidPassword(password)) {
                    registerView.errorUpperLowerNumber();
                } else if (!password.equals(confPassword)) {
                    registerView.errorConfirmPassword();
                } else if (!isValidMail(email)) {
                    registerView.errorFormat();
                } else if (!userManager.usernameIsUnique(username)) {
                    registerView.errorUsernameExist();
                } else if (!userManager.emailIsUnique(email)) {
                    registerView.errorEmailExist();
                } else if (userManager.register(new User(username, email, password))){
                    System.out.println(username+" register successful");
                    userManager.setUser(username);
                    registerView.setmainView(mainView);
                    registerView.setComponents(viewComponents);
                    registerView.resetInputInfo();
                    mainView.showMenu();
                } else {
                    registerView.errorConnection();
                }


            break;

            case RegisterView.BTN_BACK:
                registerView.resetInputInfo();
                registerView.setmainView(mainView);
                registerView.setComponents(viewComponents);
                mainView.showLogin();
            break;
        }
    }

    /**
     * Este metodo sirve para validar que la contraseña tenga el formato correcto
     * @param password la string que contiene la contraseña que deseamos analizar
     * @return el estado de nuestra contraseña
     */
    public boolean isValidPassword(String password) {
        int upper = 0, lower = 0, number = 0;

        for(int i = 0; i < password.length(); i++)
        {
            char ch = password.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                upper++;
            } else if (ch >= 'a' && ch <= 'z'){
                lower++;
            } else if (ch >= '0' && ch <= '9') {
                number++;
            }
        }
        if (upper == 0  || lower == 0 || number == 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Este metodo sirve para validar que la correo electronico tenga el formato correcto
     * @param email la string que contiene el correo que deseamos analizar
     * @return el estado de nuestro correo
     */
    public static boolean isValidMail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&-]+(?:\\."+"[a-zA-Z0-9_+&-]+)*@"+"(?:[a-zA-Z0-9-]+\\.)+[a-z"+"A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
}
