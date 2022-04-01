import persistence.UserSQLDAO;
import presentation.controllers.LoginController;
import presentation.controllers.LogoutController;
import presentation.controllers.RegisterController;


public class Main {
    public static void main(String[] args) {

        RegisterController registerController = new RegisterController();
        LoginController loginController = new LoginController();
        LogoutController logoutController = new LogoutController();

        /*sl.register("Mario","1234","mario@mario.com");
        sl.register("Guille","1234","guille@mario.com");
        sl.register("Didac","1234","didac@mario.com");
        sl.register("Puchi","1234","puchi@mario.com");

        boolean proba1 = sl.login("Mario","1234"); //prueba nombre buena
        boolean proba2 = sl.login("mario@mario.com","1234"); //prueba correo buena
        boolean proba3 = sl.login("guille@guille.com","1234"); // pureba correo mal
        boolean proba4 = sl.login("didi","1234"); //prueba nombre mal
        boolean proba5 = sl.login("Puchi","4321"); //prueba contra mal

        System.out.println(proba1+"\t"+proba2+"\t"+proba3+"\t"+proba4+"\t"+proba5);

        sl.deleteAccount("Didac");
        sl.deleteAccount("Pepe");

        sl.mostrar();*/
    }
    
}







