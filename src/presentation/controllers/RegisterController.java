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
                String username = registerView.getInputUsername(), email = registerView.getInputEmail();
                String password = String.valueOf(registerView.getInputPassword()), confPassword = String.valueOf(registerView.getInputConfPassword());

                if(password.equals(confPassword)){
                    User user = new User(username, email, password);
                    if(isValidMail(email)){
                        if (userManager.emailIsUnique(user)) {

                        }
                        if (userManager.usernameIsUnique(user)) {

                        }
                        if(userManager.register(user)){
                            userManager.register(user);
                            System.out.println(username+" register successful");
                            userManager.setUser(user.getName());//Registrar el user en la ram
                            registerView.setmainView(mainView);
                            registerView.setComponents(viewComponents);
                            registerView.showMenu();
                        }else{
                            registerView.errorExists();
                        }
                    }else{
                        registerView.errorFormat();
                    }
                }else{
                    registerView.errorPassword();
                }
            break;

            case RegisterView.BTN_BACK:
                registerView.setmainView(mainView);
                registerView.setComponents(viewComponents);
                registerView.showMain();
            break;
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
