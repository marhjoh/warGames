package no.ntnu.idatg1002.wargamesapplication.corefunctionality.units;

/**
 * This class represents a commander unit
 * This unit's strength is charge (first attack), then melee (the rest attacks)
 *
 * @author Martin Hegnum Johannessen
 * @version 1.0-SNAPSHOT
 */
public class CommanderUnit extends CavalryUnit {

    private static final int ATTACK_DAMAGE = 25;
    private static final int ARMOUR = 15;
    private static final int STANDARD_ATTACK_BONUS = 2;
    private static final int STANDARD_RESIST_BONUS = 1;

    /**
     * This method creates a commander unit
     *
     * @param name the name of the commander unit
     * @param health the health of the commander unit
     */
    public CommanderUnit(String name, int health) {
        super(name, health, ATTACK_DAMAGE, ARMOUR);
    }

    /**
     * This method creates a commander unit with no predetermined values
     *
     * @param name the name of the commander unit
     * @param health the health of the commander unit
     * @param attack the unit's attack damage
     * @param armour the unit's armour
     */
    public CommanderUnit(String name, int health, int attack, int armour) {
        super(name, health, attack, armour);
    }

    /**
     * This method returns the commander unit's attack bonus.
     *
     * @return the commander unit's resist bonus as an int
     * @param terrain the location of the unit
     */
    @Override
    public int getAttackBonus(char terrain) {

        //Attack type: Charge
        if (getHitsDealt() == 0) {
            return 6;
        } else {
            //Attack type: Melee
            return STANDARD_ATTACK_BONUS;
        }
    }

    /**
     * This method returns the commander unit's resist bonus
     *
     * @return the commander unit's resist bonus as an int
     * @param terrain the location of the unit
     */
    @Override
    public int getResistBonus(char terrain) {

        //Attack type: Melee
        if (getHitsTaken() != 0) {
            return STANDARD_RESIST_BONUS;
        }
        //Attack type: Charge
        return 0;
    }
}
