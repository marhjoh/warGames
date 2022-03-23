package corefunctionality;

/**
 * This class represent an infantry unit
 * This unit's strength is melee.
 * @author Martin Hegnum Johannessen
 * @version 1.0-SNAPSHOT
 */
public class InfantryUnit extends Unit {

    //The fields
    private static final int ATTACK_DAMAGE = 15;
    private static final int ARMOUR = 10;
    private static final int ATTACK_BONUS = 2;
    private static final int RESIST_BONUS = 1;

    /**
     * This method creates an infantry unit
     *
     * @param name the name of the infantry unit
     * @param health the health of the infantry unit
     */
    public InfantryUnit(String name, int health){
        super(name, health, ATTACK_DAMAGE, ARMOUR); }

    /**
     * This method creates an infantry unit with no predetermined values
     *
     * @param name the name of the infantry unit
     * @param health the health of the infantry unit
     * @param attack the infantry unit's attack damage
     * @param armour the infantry unit's armour
     */
    public InfantryUnit(String name, int health, int attack, int armour){
        super(name, health, attack, armour);
    }

    /**
     * This method will return the attack bonus
     *
     * @return the infantry unit's attack bonus as an int
     */
    @Override
    int getAttackBonus() {
        return ATTACK_BONUS; }

    /**
     * This method will return the resist bonus
     *
     * @return the infantry unit's resist bonus as an int
     */
    @Override
    int getResistBonus() {
        return RESIST_BONUS; }
}
