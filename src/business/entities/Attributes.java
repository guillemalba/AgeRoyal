package business.entities;

/**
 * Una enumeracion con atributos de las tropas.
 */
public enum Attributes {

    ARCHER_ID(0),
    ARCHER_COST(3),
    ARCHER_LIFE(12),
    ARCHER_DAMAGE(4),
    ARCHER_ATTACK_RANGE(3),
    ARCHER_ATTACK_VELOCITY(2000),
    ARCHER_MOVEMENT_VELOCITY(3000),

    GIANT_ID(1),
    GIANT_COST(5),
    GIANT_LIFE(70),
    GIANT_DAMAGE(5),
    GIANT_ATTACK_RANGE(1),
    GIANT_ATTACK_VELOCITY(2000),
    GIANT_MOVEMENT_VELOCITY(4000),

    CANNON_ID(2),
    CANNON_COST(4),
    CANNON_LIFE(30),
    CANNON_DAMAGE(4),
    CANNON_ATTACK_RANGE(3),
    CANNON_ATTACK_VELOCITY(3000),
    CANNON_TIME_LIFE(18),//*atackVel

    TESLA_ID(3),
    TESLA_COST(5),
    TESLA_LIFE(30),
    TESLA_DAMAGE(4),
    TESLA_ATTACK_RANGE(2),
    TESLA_ATTACK_VELOCITY(2000),
    TESLA_TIME_LIFE(20),
    ;

    private final int value;

    Attributes(final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }
}
