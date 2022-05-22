package no.ntnu.idatg2001.wargamesapplication.corefunctionality.units;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represent a Unit Factory
 *
 * @author Martin Hegnum Johannessen
 * @version 1.0-SNAPSHOT
 */
public class UnitFactory {

    /**
     * This is a constructor for a static class
     */
    private UnitFactory(){
    }

    /**
     * This method creates a unit based on string input.
     *
     * @param unitType the unit instance
     * @param name the name of the unit
     * @param health the unit's health
     *
     * @return a new unit based on input.
     */
    public static Unit createUnit(String unitType, String name, int health){
        if(unitType.strip().equalsIgnoreCase("InfantryUnit")){
            return new InfantryUnit(name, health);
        }
        else if(unitType.strip().equalsIgnoreCase("CavalryUnit")){
            return new CavalryUnit(name, health);
        }
        else if(unitType.strip().equalsIgnoreCase("CommanderUnit")){
            return new CommanderUnit(name, health);
        }
        else if(unitType.strip().equalsIgnoreCase("RangedUnit")){
            return new RangedUnit(name, health);
        }
        return null;
    }

    /**
     * This method will create multiple units based on string input
     *
     * @param unitType the unit instance
     * @param name the name of the unit
     * @param health the unit's health
     * @param amountOfUnits the number of units to be created
     *
     * @return multiple units based on string input as an arrayList.
     */
    public static List<Unit> createUnitList(String unitType, String name, int health, int amountOfUnits){
        List<Unit> unitList = new ArrayList<>();
        int i = 0;

        while(i <  amountOfUnits){
            unitList.add(createUnit(unitType, name, health));
            i++;
        }
        return unitList;
    }
}
