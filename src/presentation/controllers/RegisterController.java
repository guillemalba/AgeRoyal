package presentation.controllers;

import business.UserManager;
import business.entities.User;
import presentation.views.MainView;
import presentation.views.RegisterView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class RegisterController implements ActionListener {
    private final RegisterView registerView;
    private final MainView mainView;
    private final CardLayout viewComponents;
    private UserManager userManager;

    public RegisterController(RegisterView registerView, MainView mainView, CardLayout viewComponents,UserManager userManager) {
        this.registerView = registerView;
        this.mainView = mainView;
        this.viewComponents = viewComponents;
        this.userManager = userManager;
    }

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
                    registerView.showMenu();
                } else {
                    registerView.errorConnection();
                }


            break;

            case RegisterView.BTN_BACK:
                registerView.setmainView(mainView);
                registerView.setComponents(viewComponents);
                registerView.showMain();
            break;
        }
    }

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

    public static boolean isValidMail(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&-]+(?:\\."+"[a-zA-Z0-9_+&-]+)*@"+"(?:[a-zA-Z0-9-]+\\.)+[a-z"+"A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
}
