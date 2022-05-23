package business.entities;

/**
 * An enumeration with some Troop Ids.
 */
public enum Ids {

    ARCHER(0),
    GIANT(1),
    CANNON(2),
    TESLA(3);

    private final int value;

    Ids(final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }
}
