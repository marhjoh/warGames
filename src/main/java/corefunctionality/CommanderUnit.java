package corefunctionality;

/**
 * This class represents a commander unit
 * This unit's strength is charge (first attack), then melee (the rest attacks)
 */
public class CommanderUnit extends CavalryUnit {

    private static final int ATTACK_DAMAGE = 25;
    private static final int ARMOUR = 15;
    private static final int STANDARD_ATTACK_BONUS = 2;
    private static final int STANDARD_RESIST_BONUS = 1;
    private int attackCounter = 0;

    /**
     * This method creates a commander unit
     * @param name the name of the commander unit
     * @param health the health of the commander unit
     */
    public CommanderUnit(String name, int health) {
        super(name, health, ATTACK_DAMAGE, ARMOUR);
    }

    /**
     * This method creates a commander unit with no predetermined values
     * @param name the name of the commander unit
     * @param health the health of the commander unit
     * @param attack the unit's attack damage
     * @param armour the unit's armour
     */
    public CommanderUnit(String name, int health, int attack, int armour){
        super(name, health, attack, armour);
    }

    /**
     * TODO: Lage bedre counter
     * This method returns the cavalry unit's attack bonus.
     * @return the cavalry unit's resist bonus
     */
    @Override
    int getAttackBonus() {
        if (attackCounter == 0) {
            //Attack type: Charge
            attackCounter++;
            return 6;
        } else {
            //Attack type: Melee
            return STANDARD_ATTACK_BONUS;
        }
    }

    /**
     * TODO: Lage bedre counter
     * This method returns the cavalry unit's resist bonus
     * @return the cavalry unit's resist bonus
     */
    @Override
    int getResistBonus() {
        if (attackCounter != 0) {
            ////Attack type: Melee
            return STANDARD_RESIST_BONUS;
        }
        ////Attack type: Charge
        return 0;
    }
}
