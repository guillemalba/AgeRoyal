package persistence;

import business.entities.User;

import java.util.LinkedList;

/**
 * Interficie con los metodos relacionados del Usuario
 */
public interface UserDAO {
    /**
     * Creates the User into the DAO
     *
     * @param user with all info to add
     * @return true if it succeeded or false if not
     */
    boolean createUser(User user);

    /**
     * Deletes the User from the DAO
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

    /**
     * Gets a list with all the Users
     *
     * @return a list of Users
     */
    LinkedList<User> readAllUsers();

    /**
     * Gets a list of user in the order of there win rate
     *
     * @return a list of Users
     */
    LinkedList<User> readAllOrderUsers();

    /**
     * Metodo para leer un usuario de la base de datoos
     *
     * @param username nombre
     * @return el usuario
     */
    User readUser(String username);

    /**
     * Metodo para actualizar las estadisticas de un usuario en la base de datos
     *
     * @param user que queremos actualizar
     * @return true si se ha podido completar, false si no
     */
    boolean update(User user);
}
