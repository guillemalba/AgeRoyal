package business;

import business.entities.User;
import persistence.UserDAO;
import persistence.UserSQLDAO;

import java.util.LinkedList;

public class UserManager {
    private UserDAO userDAO;

    public UserManager() {
        userDAO = new UserSQLDAO();
    }

    public boolean register(User user) {
        return userDAO.createUser(user);
    }

    public boolean delete(String username) {
        return userDAO.deleteUser(username);
    }

    public boolean login(User user) {
        return userDAO.checkLogin(user);
    }

    public boolean emailIsUnique(User u) {
        LinkedList<User> users = userDAO.readAllUsers();
        for (User user: users) {
            if (user.getEmail().equals(u.getEmail())) {
                return false;
            }
        }
        return true;
    }

    public boolean usernameIsUnique(User u) {
        LinkedList<User> users = userDAO.readAllUsers();
        for (User user: users) {
            if (user.getName().equals(u.getName())) {
                return false;
            }
        }
        return true;
    }
}
