package no.ntnu.idatg1002.wargamesapplication.corefunctionality;

import no.ntnu.idatg1002.wargamesapplication.exceptions.UnitException;

/**
 * This class represents a unit
 *
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
    private String className;

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
    protected Unit(String name, int health, int attack, int armour)  {
        this.name = name;
        setHealth(health);
        this.attack = attack;
        this.armour = armour;
        this.isAlive = true;
        this.className = getClass().getSimpleName();
    }

    /**
     * This method will attack the opponent
     *
     * @param opponent the one the attack inflicted.
     * @param terrain the location of the attack
     */
    public void attack(Unit opponent, char terrain){
        int opponentHealth = opponent.health - (this.attack + this.getAttackBonus(terrain)) + (opponent.armour + opponent.getResistBonus(terrain));
        try{
            opponent.setHealth(opponentHealth);
        }catch (IllegalArgumentException e){
            opponent.setHealth(0);
        }
        opponent.hitsTaken++;
        hitsDealt++;
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
     * This method the simple name of the unit class
     *
     * @return the simple name of the unit class as a String
     */
    public String getClassName(){
        return className;
    }

    /**
     * This method sets the unit's health
     *
     * @param health the unit's health
     */
    public void setHealth(int health) {
        if (health >= 0){
            this.health = health;
            if(this.health == 0){
                isAlive = false;
            }
        }else{
            throw new IllegalArgumentException("Health can not be lower than 0");
        }
    }

    /**
     * This method set's the unit alive or dead
     *
     * @param isAlive if the unit is alive or not
     */
    public void setIsAlive(boolean isAlive) {
        if (isAlive == false || isAlive == true) {
            this.isAlive = isAlive;
        } else {
            throw new IllegalArgumentException("Illegal value set in setIsAlive");
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
     * @param terrain the location of the unit
     */
    abstract int getAttackBonus(char terrain);


    /**
     * This method returns the unit's resist bonus
     *
     * @return the unit's resist bonus as an int
     * @param terrain the location of the unit
     */
    abstract int getResistBonus(char terrain);
}
