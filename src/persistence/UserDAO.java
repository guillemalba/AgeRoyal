package persistence;

import business.entities.User;

import java.util.LinkedList;

public interface UserDAO {
    /**
     * Creates the User into the DAO
     *
     * @param user with all info to add
     * @return true if it succeeded or false if not
     */
    boolean createUser(User user);

    /**
     * Deletes the Edition from the DAO
     *
     * @param username with all info to delete
     * @return true if it succeeded or false if not
     */
    boolean deleteUser(String username);

    /**
     * Logs the User into the DAO
     *
     * @param user with all info to add
     * @return true if it succeeded or false if not
     */
    boolean checkLogin(User user);
}
