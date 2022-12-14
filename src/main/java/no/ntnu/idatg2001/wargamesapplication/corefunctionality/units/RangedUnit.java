package no.ntnu.idatg2001.wargamesapplication.corefunctionality.units;

/**
 * This class represents a ranged unit
 * The unit's strength that it can attack from range (terrain = hill).
 * The unit's resist bonus remains the same regardless the terrain.
 *
 * @author Martin Hegnum Johannessen
 * @version 1.0-SNAPSHOT
 */
public class RangedUnit extends Unit {

    //The fields
    private static final int ATTACK_DAMAGE = 15;
    private static final int ARMOUR = 8;
    private static final int STANDARD_ATTACK_BONUS = 3;
    private static final int STANDARD_RESIST_BONUS = 2;

    /**
     * This method creates an object of a ranged unit
     *
     * @param name the name of the ranged unit
     * @param health the health of the ranged unit
     */
    public RangedUnit(String name, int health) {
        super(name, health, ATTACK_DAMAGE, ARMOUR);
    }

    /**
     * This method creates a ranged unit with no predetermined values
     *
     * @param name the name of the ranged unit
     * @param health the health of the ranged unit
     * @param attack the ranged unit's attack damage
     * @param armour the ranged unit's armour
     */
    public RangedUnit(String name, int health, int attack, int armour) {
        super(name, health, attack, armour);
    }

    /**
     * This method returns the ranged unit's attack bonus
     *
     * @param terrain the location of the unit
     * @return the ranged unit's attack bonus as an int
     */
    @Override
    int getAttackBonus(char terrain) {
        if(terrain == 'H'){
            return STANDARD_ATTACK_BONUS + 2;
        }

        if(terrain == 'F'){
            return STANDARD_ATTACK_BONUS - 1;
        }

        if(terrain == 'P') {
            return STANDARD_ATTACK_BONUS;
        }
        return 0;
    }

    /**
     * This method returns the ranged unit's resist bonus
     * Terrain does not affect this unit's resist bonus
     *
     * @param terrain the location of the unit
     * @return the ranged unit's resist bonus as an int
     */
    @Override
    int getResistBonus(char terrain) {
        if(getHitsTaken() == 0){
            return 6;
        }

        else if(getHitsTaken() == 1){
            return 4;
        }

        else{
            return STANDARD_RESIST_BONUS;
        }
    }
}
