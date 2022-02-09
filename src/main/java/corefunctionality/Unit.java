package corefunctionality;

/**
 * This class represents a unit
 */
public abstract class Unit {

    //The fields
    private String name;
    private int health;
    private int attack;
    private int armour;

    protected Unit(String name, int health, int attack, int armour) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.armour = armour;
    }

    protected void attack(Unit opponent){
        opponent.setHealth(opponent.health - (this.attack + this.getAttackBonus()) + (opponent.armour + opponent.getResistBonus()));
    }

    /**
     * This method returns the unit's name
     * @return the name pf the unit
     */
    public String getName() {
        return name;
    }

    /**
     * This method returns the unit's health
     * @return the health of the unit
     */
    public int getHealth() {
        return health;
    }

    /**
     * This method returns the unit's attack damage
     * @return the unit's attack damage
     */
    public int getAttack() {
        return attack;
    }

    /**
     * This method returns the unit's armour
     * @return the unit's armour
     */
    public int getArmour() {
        return armour;
    }

    /**
     * This method sets the unit's health
     * @param health the unit's health
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * This method returns a string consisting of all the fields in the unit class
     * @return a string with all the information in the class field
     */
    @Override
    public String toString() {
        return "Unit{" + "name='" + name + '\'' + ", health=" + health +
                ", attack=" + attack + ", armour=" + armour + '}';
    }

    abstract int getAttackBonus();

    abstract int getResistBonus();


}
