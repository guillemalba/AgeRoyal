package business.entities;

import business.GameManager;


import java.awt.image.BufferedImage;

/**
 * Herencia de la clase Ofensiva donde sobreescribimos los metodos y los implementamos con su constructor.
 */
public class Archer extends Ofensive {

    /**
     * Constructor para crear una nueva Arquera
     *
     * @param name de la arqueraI
     * @param posx del mapa
     * @param posy del mapa
     * @param gameManager para acceder a los metodos
     * @param isUser para saber si es tropa de la IA o del usuario
     * @param stop para parar el thread
     * @param image imagen que cargamos en el mapa
     */
    public Archer(String name, int posx, int posy, GameManager gameManager, boolean isUser, boolean stop, BufferedImage image) {
        super(name,posx, posy, gameManager, isUser, stop, image);
        this.setCost(Attributes.ARCHER_COST.getValue());
        this.setLife(Attributes.ARCHER_LIFE.getValue());
        this.setDamage(Attributes.ARCHER_DAMAGE.getValue());
        this.setRange(Attributes.ARCHER_ATTACK_RANGE.getValue());
        this.setAttackVelocity(Attributes.ARCHER_ATTACK_VELOCITY.getValue());
        this.setMovementVelocity(Attributes.ARCHER_MOVEMENT_VELOCITY.getValue());

    }
}
