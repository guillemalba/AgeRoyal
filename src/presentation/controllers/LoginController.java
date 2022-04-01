package presentation.controllers;

import business.UserManager;
import business.entities.User;

public class LoginController {
    private UserManager userManager;

    public LoginController() {
        userManager = new UserManager();

        User user = new User("Trusty", "trusty@gmail.com", "1234");

        if (userManager.login(user)) {
            System.out.println(user.getName() + " login successful");
        } else {
            System.out.println(user.getName() + " login failed");
        }
    }
}
