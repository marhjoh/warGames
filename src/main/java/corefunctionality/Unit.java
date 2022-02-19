package corefunctionality;

/**
 * This class represents a unit
 * @author Martin Hegnum Johannessen
 * @version 1.0-SNAPSHOT
 */
public abstract class Unit {

    //The fields
    private String name;
    private int health;
    private int attack;
    private int armour;
    private int hitsDealt;
    private int hitsTaken;

    /**
     * This method creates a unit
     * @param name the name of the unit
     * @param health the health of the unit
     * @param attack the unit's attack damage
     * @param armour the unit's armour
     */
    protected Unit(String name, int health, int attack, int armour) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.armour = armour;
    }

    /**
     * This method will attack the opponent
     * @param opponent the one the attack inflicted.
     */
    protected void attack(Unit opponent){
        opponent.setHealth(opponent.health - (this.attack + this.getAttackBonus()) + (opponent.armour + opponent.getResistBonus()));
        opponent.hitsTaken++;
        hitsDealt++;
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
     * This method returns the unit's hits dealt
     * @return the hits dealt by the unit
     */
    public int getHitsDealt(){
        return hitsDealt; }

    /**
     * This method returns the unit's taken hits
     * @return the hits taken by the unit
     */
    public int getHitsTaken(){
        return hitsTaken; }

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
        return "Name: " + name + "\n"
                + "Health: " + health + "\n"
                + "Attack: " + attack + "\n"
                + "Armour: " + armour;
    }

    abstract int getAttackBonus();

    abstract int getResistBonus();


}
