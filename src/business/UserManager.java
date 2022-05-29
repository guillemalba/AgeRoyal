package business;

import business.entities.User;
import persistence.GameDAO;
import persistence.UserDAO;
import java.util.LinkedList;


/**
 * Manager del jugador donde se encuentran todas las funciones necesarias para añadir jugadores en la base de datos, comprovar que la informacion introducida sea valida.
 * entre otras cosas
 */
public class UserManager {
    private UserDAO userDAO;
    private GameDAO gameDAO;
    private String user;
    private LinkedList<User> users;

    /**
     * Constructor del manager con una nueva instancia del UserDAO
     *
     * @param userSQLDAO con los metodos necesarios de la base de datos
     */
    public UserManager(UserDAO userSQLDAO, GameDAO gameSQLDAO) {
        userDAO = userSQLDAO;
        gameDAO = gameSQLDAO;
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

    /**
     * Metodo que elimina todas las partidas guardadas de un usuario en la base de datos
     *
     * @return true si ha sido posible eliminarlas, false si no
     */
    public boolean deleteAllGames() {
        return gameDAO.deleteUserGames(user);
    }

    /**
     * Metodo que llama a la funcion de la DAO para devolver un usuario
     *
     * @return el usuario
     */
    public User readUser() {
        return userDAO.readUser(user);
    }

    /**
     * Metodo que llama a la funcion de la DAO para actualizar las estadisticas del jugador
     *
     * @param user a actualizar en la base de datos
     */
    public void updateUser(User user) {
        userDAO.update(user);
    }

}
