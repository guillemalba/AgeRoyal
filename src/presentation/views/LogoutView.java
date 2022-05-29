package presentation.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Esta clase nos servira para poder mostrar la vista que permite desloguearse y eliminar la cuenta del usuario activo
 */
public class LogoutView extends JPanel {
    public static final String BTN_LOGOUT = "BTN_LOGOUT";
    //public static final String BTN_EDIT = "BTN_EDIT";
    public static final String BTN_DEL = "BTN_DEL";
    public static final String BTN_BACK = "BTN_BACK";

    private JButton jbLogout;
    //private JButton jbEdit;
    private JButton jbDelete;
    private JButton jbBack;

    private MainView mainView;
    private CardLayout components;

    /**
     *  Este al ser el constructor de nuestra vista, lo unico que hace es llamar al metodo (configureLoginView())
     */
    public LogoutView() {
        configureLogoutView();
    }

    /**
     * Este metodo se utiliza para poder crear y añadir todos los componentes de la vista.
     */
    private void configureLogoutView() {
        setLayout(new BoxLayout(this ,BoxLayout.PAGE_AXIS));

        //Creamos los labels que queremos que aparezcan en la pagina
        JLabel jlTitle = new JLabel("User access info");

        JPanel jpButtons = new JPanel();

        jbLogout = new JButton();
        jbLogout.setIcon(new ImageIcon(new ImageIcon("files/btn_logout.png").getImage().getScaledInstance(150, 75, Image.SCALE_DEFAULT)));
        jbLogout.setBorderPainted(false);
        jbLogout.setContentAreaFilled(false);
        jbLogout.setActionCommand(BTN_LOGOUT);
        //jbEdit = new JButton("Edit User");
        //jbEdit.setActionCommand(BTN_EDIT);


        jbDelete = new JButton();
        jbDelete.setIcon(new ImageIcon(new ImageIcon("files/btn_delete.png").getImage().getScaledInstance(150, 75, Image.SCALE_DEFAULT)));
        jbDelete.setBorderPainted(false);
        jbDelete.setContentAreaFilled(false);
        jbDelete.setActionCommand(BTN_DEL);


        jbBack = new JButton();
        jbBack.setIcon(new ImageIcon(new ImageIcon("files/btn_back.png").getImage().getScaledInstance(150, 75, Image.SCALE_DEFAULT)));
        jbBack.setBorderPainted(false);
        jbBack.setContentAreaFilled(false);
        jbBack.setActionCommand(BTN_BACK);

        jpButtons.add(jbLogout, BorderLayout.NORTH);
        //jpButtons.add(jbEdit, BorderLayout.CENTER);
        jpButtons.add(jbDelete, BorderLayout.SOUTH);

        add(jpButtons);
        add(jbBack);

    }

    /**
     * Este metodod servira para poder asignar los listeners necesarios a cada boton de nuestra vista
     * @param listener es la clase que detectara si nuestros botones son pulsados
     */
    public void registerController(ActionListener listener) {
        jbLogout.addActionListener(listener);
        //jbEdit.addActionListener(listener);
        jbDelete.addActionListener(listener);
        jbBack.addActionListener(listener);
    }

    /**
     * Este metodo muestra un mensaje para asegurarse que el ususario quiere desloguearse
     * @return el resultado del popUp (si quiere salir o no)
     */
    public int logout(){
        int dialogButton = JOptionPane.showConfirmDialog (null, "Are you sure you want to logout?","WARNING",JOptionPane.YES_NO_OPTION);
        int option;
        if(dialogButton == JOptionPane.YES_OPTION) {
            option = 1;

        }else {
            option = 0;
        }
        return option;
    }

    /**
     * Este metodo muestra un mensaje para asegurarse que el ususario quiere eliminar su cuenta
     * @return el resultado del popUp (si quiere eliminar su cuenta o no)
     */
    public int delete(){
        int dialogDeleteButton = JOptionPane.showConfirmDialog (null, "Are you sure you want to Delete this account?","WARNING",JOptionPane.YES_NO_OPTION);
        int option;
        if(dialogDeleteButton == JOptionPane.YES_OPTION) {
            option = 1;

        }else {
            option = 0;
        }
        return option;
    }

    /**
     * Setter para asignar los componentes del card layout
     *
     * @param viewComponents card layout
     */
    public void setComponents(CardLayout viewComponents) {
        this.components = viewComponents;
    }

    /**
     * Setter para asignar la main view
     *
     * @param mainView vista principal
     */
    public void setmainView(MainView mainView){
        this.mainView = mainView;
    }
}
