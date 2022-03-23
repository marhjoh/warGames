package corefunctionality;

import exceptions.UnitException;

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
     *
     * @param name the name of the unit
     * @param health the health of the unit
     * @param attack the unit's attack damage
     * @param armour the unit's armour
     *
     * @throws UnitException
     */
    protected Unit(String name, int health, int attack, int armour) throws UnitException {
        this.name = name;
        setHealth(health);
        this.attack = attack;
        this.armour = armour;
        this.isAlive = true;
    }

    /**
     * This method will attack the opponent
     *
     * @param opponent the one the attack inflicted.
     *
     * @throws UnitException
     */
    protected void attack(Unit opponent) throws UnitException {
        opponent.setHealth(opponent.health - (this.attack + this.getAttackBonus()) + (opponent.armour + opponent.getResistBonus()));
        opponent.hitsTaken++;
        hitsDealt++;

        if(opponent.getHealth() <= 0){
            opponent.setIsAlive(false);
        }
    }

    /**
     * This method returns the unit's name
     *
     * @return the name of the unit as a String
     */
    public String getName() {
        return name;
    }

    /**
     * This method returns the unit's health
     *
     * @return the health of the unit as an int
     */
    public int getHealth() {
        return health;
    }

    /**
     * This method returns the unit's attack damage
     *
     * @return the unit's attack damage as an int
     */
    public int getAttack() {
        return attack;
    }

    /**
     * This method returns the unit's armour
     *
     * @return the unit's armour as an int
     */
    public int getArmour() {
        return armour;
    }

    /**
     * This method returns the unit's hits dealt
     *
     * @return the hits dealt by the unit as an int
     */
    public int getHitsDealt(){
        return hitsDealt; }

    /**
     * This method returns the unit's taken hits
     *
     * @return the hits taken by the unit as an int
     */
    public int getHitsTaken(){
        return hitsTaken; }

    /**
     * This method returns whether the unit is alive or not
     *
     * @return if the unit is alive or not as a boolean
     */
    public boolean getIsAlive(){
        return isAlive;}

    /**
     * This method sets the unit's health
     *
     * @param health the unit's health
     *
     * @throws UnitException
     */
    public void setHealth(int health) throws UnitException {
        if (health >= 0){
            this.health = health;
        } else {
            throw new UnitException("Illegal value set in setHealth");
        }
    }

    /**
     * This method set's the unit alive or dead
     *
     * @param isAlive if the unit is alive or not
     *
     * @throws UnitException
     */
    public void setIsAlive(boolean isAlive) throws UnitException {
        if (isAlive == false || isAlive == true) {
            this.isAlive = isAlive;
        } else {
            throw new UnitException("Illegal value set in setIsAlive");
        }
    }


    /**
     * This method returns a string consisting of all the fields in the unit class
     *
     * @return all the information in the class field as a String
     */
    @Override
    public String toString() {
        return "Name: " + name + "\n"
                + "Health: " + health + "\n"
                + "Attack: " + attack + "\n"
                + "Armour: " + armour;
    }

    /**
     * This method returns the unit's attack bonus
     *
     * @return the unit's attack bonus as an int
     */
    abstract int getAttackBonus();


    /**
     * This method returns the unit's resist bonus
     *
     * @return the unit's resist bonus as an int
     */
    abstract int getResistBonus();


}
