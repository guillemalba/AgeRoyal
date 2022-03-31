import persistence.UserSQLDAO;


public class Main {
    public static void main(String[] args) {
        System.out.println("First commit");
        UserSQLDAO sl = new UserSQLDAO();
        sl.register("Mario","1234","mario@mario.com");
        sl.mostrar();
    }
    
}







