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
    private boolean isAlive;

    /**
     * This method creates a unit
     * @param name the name of the unit
     * @param health the health of the unit
     * @param attack the unit's attack damage
     * @param armour the unit's armour
     */
    protected Unit(String name, int health, int attack, int armour) {
        this.name = name;
        if(health <= 0){
            throw new IllegalArgumentException("Invalid Health");
        }
        this.health = health;
        this.attack = attack;
        this.armour = armour;
        this.isAlive = true;
    }

    /**
     * This method will attack the opponent
     * @param opponent the one the attack inflicted.
     */
    protected void attack(Unit opponent){
        opponent.setHealth(opponent.health - (this.attack + this.getAttackBonus()) + (opponent.armour + opponent.getResistBonus()));
        opponent.hitsTaken++;
        hitsDealt++;

        if(opponent.getHealth() <= 0){
            opponent.setIsAlive(false); }
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
     * This method returns whether the unit is alive or not
     * @return if the unit is alive or not
     */
    public boolean getIsAlive(){
        return isAlive;}

    /**
     * This method sets the unit's health
     * @param health the unit's health
     */
    public void setHealth(int health) {
        if(health <= 0){
            throw new IllegalArgumentException("Invalid health");
        }
        this.health = health;
    }

    /**
     * This method set's the unit alive or dead
     * @param isAlive if the unit is alive or not
     */
    public void setIsAlive(boolean isAlive){
        this.isAlive = isAlive;
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
