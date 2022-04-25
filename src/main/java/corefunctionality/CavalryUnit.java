package corefunctionality;

/**
 * This class represents a cavalry unit
 * This unit's strength is charge (first attack), then melee (the rest attacks)
 *
 * @author Martin Hegnum Johannessen
 * @version 1.0-SNAPSHOT
 */
public class CavalryUnit extends Unit {

    //The fields
    private static final int ATTACK_DAMAGE = 20;
    private static final int ARMOUR = 12;
    private static final int STANDARD_ATTACK_BONUS = 2;
    private static final int STANDARD_RESIST_BONUS = 1;

    /**
     * This method creates a cavalry unit
     *
     * @param name   the name of the cavalry unit
     * @param health the health of the cavalry unit
     */
    public CavalryUnit(String name, int health) {
        super(name, health, ATTACK_DAMAGE, ARMOUR);
    }

    /**
     * This method creates a cavalry unit with no predetermined values
     *
     * @param name   the name of the cavalry unit
     * @param health the health of the cavalry unit
     * @param attack the cavalry unit's attack damage
     * @param armour the cavalry unit's armour
     */
    public CavalryUnit(String name, int health, int attack, int armour) {
        super(name, health, attack, armour);
    }

    /**
     * This method returns the cavalry unit's attack bonus.
     *
     * @param terrain the location of the unit
     * @return the cavalry unit's resist bonus as an int
     */
    @Override
    int getAttackBonus(char terrain) {

        ////Attack type: Charge
        if (getHitsDealt() == 0) {
            if (terrain == 'P') {
                return 6 + 3; }
            else{
                return 6; }
        }
        ////Attack type: Melee
        else if (getHitsDealt() != 0){
            if(terrain == 'P'){
                return STANDARD_ATTACK_BONUS + 3; }
        }

        return STANDARD_ATTACK_BONUS;
    }

    /**
     * This method returns the cavalry unit's resist bonus
     *
     * @param terrain the location of the unit
     * @return the cavalry unit's resist bonus as an int
     */
    @Override
    int getResistBonus(char terrain) {

        ////Attack type: Melee
        if (getHitsTaken() != 0) {
            if (terrain == 'F') {
                return 0;
            } else {
                return STANDARD_RESIST_BONUS;
            }
        }
        ////Attack type: Charge
        return 0;
    }
}
