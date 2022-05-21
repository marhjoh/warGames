package no.ntnu.idatg1002.wargamesapplication.corefunctionality;

import no.ntnu.idatg1002.wargamesapplication.corefunctionality.units.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * This class represents an army of units
 *
 * @author Martin Hegnum Johannessen
 * @version 1.0-SNAPSHOT
 */
public class Army {

    private String name;
    private List<Unit> militia;
    private Random random;

    /**
     * This method creates an army
     *
     * @param name the name of the army
     */
    public Army(String name) {
        this.name = name;
        militia = new ArrayList<>();
        random = new Random();
    }

    /**
     * This method creates an army
     *
     * @param name    the name of the army
     * @param militia the list of units
     */
    public Army(String name, List<Unit> militia) {
        this.name = name;
        if (militia == null) {
            this.militia = new ArrayList<>();
        } else {
            this.militia = militia;
        }
        random = new Random();
    }

    /**
     * This method returns the name of the militia
     *
     * @return the name of the militia as a String
     */
    public String getName() {
        return name;
    }

    /**
     * This method returns the militia list (unit list)
     *
     * @return the militia list/unit list as a list
     */
    public List<Unit> getAllUnits() {
        return militia;
    }

    /**
     * This method adds a unit to the militia
     *
     * @param unit the unit to be added to the militia
     */
    public void addToArmy(Unit unit) {
        this.militia.add(unit);
    }

    /**
     * This method adds all units from the input-list to the militia (unit list)
     *
     * @param unitList the units to be added to the army
     */
    public void addAllToArmy(List<Unit> unitList) {
        for (Unit unit : unitList) {
            militia.add(unit);
        }
    }

    /**
     * This method removes a unit from the militia (army / unit list)
     *
     * @param unit the unit to be removed
     */
    public void removeUnit(Unit unit) {
        militia.remove(unit);
    }

    /**
     * This method returns whether the militia has units or not
     *
     * @return if the militia has units or not as a boolean
     */
    public boolean hasUnits() {
        return !militia.isEmpty();
    }

    /**
     * This method will return a random unit from the army (unit list)
     *
     * @return a random unit from the militia (army / unit list)
     */
    public Unit getRandomUnit() {

        int randomIndex = random.nextInt(militia.size());
        return militia.get(randomIndex);
    }

    /**
     * This method sets the army name
     *
     * @param name army name to be set
     */
    public void setArmyName(String name) {
        this.name = name;
    }

    /**
     * This method will set the unit list
     *
     * @param units the unit list to be set
     */
    public void setUnits(List<Unit> units) {
        if (units != null) {
            this.militia = units;
        }
    }

    /**
     * This method returns the infantry units in the army
     *
     * @return the infantry units in the army as a list
     */
    public List<Unit> getInfantryUnits() {
        return militia.stream().filter(p -> p instanceof InfantryUnit).toList();
    }

    /**
     * This method returns the cavalry units in the army
     *
     * @return the cavalry units in the army as a list
     */
    public List<Unit> getCavalryUnits() {
        ArrayList<Unit> result = new ArrayList<>();
        for (Unit unit : militia) {
            if (unit instanceof CavalryUnit && !(unit instanceof CommanderUnit)) {
                result.add(unit);
            }
        }
        return result;
    }

    /**
     * This method returns the commander units in the army
     *
     * @return the commander units in the army as a list
     */
    public List<Unit> getCommanderUnits() {
        return militia.stream().filter(p -> p instanceof CommanderUnit).toList();
    }

    /**
     * This method returns the ranged units in the ary
     *
     * @return the ranged units in the army as a list
     */
    public List<Unit> getRangedUnits() {
        return militia.stream().filter(p -> p instanceof RangedUnit).toList();
    }

    /**
     * This method converts the class details to a string
     *
     * @return the details in a string
     */
    @Override
    public String toString() {
        return "\nName: " + name + "\n" + "Army: " + militia;
    }

    /**
     * This method returns if the armies are equal or not
     *
     * @param o superclass object comparable
     * @return if the militias are equal or not as a boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Army militia1 = (Army) o;
        return Objects.equals(name, militia1.name) && Objects.equals(militia, militia1.militia);
    }

    /**
     * This method returns the army's hash code
     *
     * @return the militia's hash code as an int
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, militia);
    }
}
