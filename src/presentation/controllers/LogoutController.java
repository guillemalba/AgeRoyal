package presentation.controllers;

import business.UserManager;

public class LogoutController {
    UserManager userManager;

    public LogoutController() {
        userManager = new UserManager();

        String name = "Trusty";

        if (userManager.delete(name)) {
            System.out.println(name + " deleted successful");
        } else {
            System.out.println(name + " deleted failed");
        }
    }
}
