package business;

import business.entities.User;
import persistence.UserDAO;
import persistence.UserSQLDAO;

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
}
