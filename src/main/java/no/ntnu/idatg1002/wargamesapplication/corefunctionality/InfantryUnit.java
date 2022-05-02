package no.ntnu.idatg1002.wargamesapplication.corefunctionality;

/**
 * This class represent an infantry unit
 * This unit's strength is melee.
 * Extra advantage when fighting in forest (both attack and defence).
 *
 * @author Martin Hegnum Johannessen
 * @version 1.0-SNAPSHOT
 */
public class InfantryUnit extends Unit {

    //The fields
    private static final int ATTACK_DAMAGE = 15;
    private static final int ARMOUR = 10;
    private static final int STANDARD_ATTACK_BONUS = 2;
    private static final int STANDARD_RESIST_BONUS = 1;

    /**
     * This method creates an infantry unit
     *
     * @param name the name of the infantry unit
     * @param health the health of the infantry unit
     */
    public InfantryUnit(String name, int health) {
        super(name, health, ATTACK_DAMAGE, ARMOUR); }

    /**
     * This method creates an infantry unit with no predetermined values
     *
     * @param name the name of the infantry unit
     * @param health the health of the infantry unit
     * @param attack the infantry unit's attack damage
     * @param armour the infantry unit's armour
     */
    public InfantryUnit(String name, int health, int attack, int armour) {
        super(name, health, attack, armour);
    }

    /**
     * This method will return the attack bonus
     *
     * @return the infantry unit's attack bonus as an int
     * @param terrain the location of the unit
     */
    @Override
    int getAttackBonus(char terrain) {
        if(terrain == 'F'){
            return STANDARD_ATTACK_BONUS + 3;
        }
        return STANDARD_ATTACK_BONUS;
    }

    /**
     * This method will return the resist bonus
     *
     * @return the infantry unit's resist bonus as an int
     * @param terrain the location of the unit
     */
    @Override
    int getResistBonus(char terrain) {
        if(terrain == 'F'){
            return STANDARD_RESIST_BONUS + 3;
        }
        return STANDARD_RESIST_BONUS;
    }
}
