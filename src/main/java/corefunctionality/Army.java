package corefunctionality;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * This class represents a militia (an army)
 * @author Martin Hegnum Johannessen
 * @version 1.0-SNAPSHOT
 */
public class Army {

    private String name;
    private List<Unit> militia;
    private Random random;

    public Army(String name){
        this.name = name;
        militia = new ArrayList<Unit>();
        random = new Random();
    }

    /**
     * This method returns the name of the militia
     * @return the name of the militia
     */
    public String getName() {
        return name;
    }

    /**
     * This method returns the militia list (unit list)
     * @return the militia list (unit list)
     */
    public List<Unit> getAllUnits() {
        return militia;
    }

    /**
     * This method adds a unit to the militia
     * @param unit the unit to be added to the militia
     */
    public void addToArmy(Unit unit){
        militia.add(unit);
    }

    /**
     * This method adds all units from the input-list to the militia (unit list)
     * @param unitList the units to be added to the army
     */
    public void addAll(List<Unit> unitList){
        //unitList is input arraylist
        for(Unit unit: unitList){
            militia.add(unit); }
    }

    /**
     * This method removes a unit from the militia (army / unit list)
     * @param unit the unit to be removed
     */
    public void removeUnit(Unit unit){
        militia.remove(unit);
    }

    /**
     * This method returns whether the militia has units or not
     * @return if the militia has units or not
     */
    public boolean hasUnits(){
        return !militia.isEmpty();
    }

    /**
     * This method will return a random unit from the army (unit list)
     * @return a random unit from the militia (army / unit list)
     */
    public Unit getRandom(){
        int randomIndex = random.nextInt(0, militia.size());
        return militia.get(randomIndex);
    }

    /**
     * This method converts the class details to a string
     * @return the details in a string
     */
    @Override
    public String toString() {
        return "Name: " + name + "\n" + " Army: " + militia; }

    /**
     * This method returns if the armies are equal or not
     * @param o superclass object comparable
     * @return if the militias are equal or not
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
     * @return the militia's hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, militia);
    }



}
