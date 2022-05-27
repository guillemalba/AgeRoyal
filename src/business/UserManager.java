package business;

import business.entities.User;
import persistence.UserDAO;
import persistence.UserSQLDAO;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class UserManager {
    private UserDAO userDAO;
    private String user;
    private LinkedList<User> users;

    public UserManager() {
        userDAO = new UserSQLDAO();
    }

    public boolean register(User user) {
        return userDAO.createUser(user);
    }

    public boolean delete() {
        return userDAO.deleteUser(user);
    }

    public boolean login(User user) {
        return userDAO.checkLogin(user);
    }

    public boolean emailIsUnique(String email) {
        LinkedList<User> users = userDAO.readAllUsers();
        for (User user: users) {
            if (user.getEmail().equals(email)) {
                return false;
            }
        }
        return true;
    }

    public boolean usernameIsUnique(String username) {
        LinkedList<User> users = userDAO.readAllUsers();
        for (User user: users) {
            if (user.getName().equals(username)) {
                return false;
            }
        }
        return true;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<User> updateUsers(){
        if(users != null) users.removeAll(users);
        users = userDAO.readAllOrderUsers();
        return Collections.unmodifiableList(users);
    }

}
