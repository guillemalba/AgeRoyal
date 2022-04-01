package presentation.controllers;

import business.UserManager;
import business.entities.User;

public class RegisterController {
    private UserManager userManager;

    public RegisterController() {
        userManager = new UserManager();

        User user = new User("Trusty", "trusty@gmail.com", "1234", 0, 0, 0);
        if (userManager.register(user)) {
            System.out.println(user.getName() + " register successful");
        } else {
            System.out.println(user.getName() + " register failed");
        }
    }
}
