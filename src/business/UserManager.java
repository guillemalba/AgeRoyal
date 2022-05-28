package business;

import business.entities.User;
import persistence.UserDAO;
import persistence.UserSQLDAO;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Manager del jugador donde se encuentran todas las funciones necesarias para añadir jugadores en la base de datos, comprovar que la informacion introducida sea valida.
 * entre otras cosas
 */
public class UserManager {
    private UserDAO userDAO;
    private String user;
    private LinkedList<User> users;

    /**
     * Constructor del manager con una nueva instancia del UserDAO
     *
     * @param userSQLDAO con los metodos necesarios de la base de datos
     */
    public UserManager(UserDAO userSQLDAO) {
        userDAO = userSQLDAO;
    }

    /**
     * Metodo que llama a la funcion de la DAO para crear un usuario en la base de datos
     *
     * @param user usuario que se añade en la base de datos
     * @return true si se ha podido añadir, false si ha habido algun problema
     */
    public boolean register(User user) {
        return userDAO.createUser(user);
    }

    /**
     * Metodo que llama a la funcion de la DAO para eliminar un usuario de la base de datos
     *
     * @return true si se ha podido eliminar, false si ha habido algun problema
     */
    public boolean delete() {
        return userDAO.deleteUser(user);
    }

    /**
     * Metodo que llama a la funcion de la DAO para comprobar si el usuario existe y poder hacer login
     *
     * @param user para comprobar
     * @return true si se ha podido hacer login, false si ha habido algun problema
     */
    public boolean login(User user) {
        return userDAO.checkLogin(user);
    }

    /**
     * Metodo que comprueba si el email introducido es unico o ya existe
     *
     * @param email del usuario a comprobar
     * @return true si es unico, false si no lo es
     */
    public boolean emailIsUnique(String email) {
        LinkedList<User> users = userDAO.readAllUsers();
        for (User user: users) {
            if (user.getEmail().equals(email)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Metodo que comprueba si el username introducido es unico o ya existe
     *
     * @param username del usuario a comprobar
     * @return true si es unico, false si no lo es
     */
    public boolean usernameIsUnique(String username) {
        LinkedList<User> users = userDAO.readAllUsers();
        for (User user: users) {
            if (user.getName().equals(username)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Getter para devolver el nombre el usuario que ha hecho login
     *
     * @return nombre
     */
    public String getUser() {
        return user;
    }

    /**
     * Setter para asignar el nombre del usuario de la session tras hacer login
     *
     * @param user nombre
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Metodo que llama a la funcion de la DAO para leer la lista de usuarios ordenada por ratio
     *
     * @return la lista de usuarios ordenada por ratio
     */
    public LinkedList<User> readSortedUsers(){
        if(users != null) users.removeAll(users);
        users = userDAO.readAllOrderUsers();
        return users;
    }

}
