package no.ntnu.idatg1002.wargamesapplication.corefunctionality.units;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


/**
 * This class is a test class for the UnitFactory class
 *
 * @author Martin Hegnum Johannessen
 * @version 1.0-SNAPSHOT
 */
class TestUnitFactory {

    @Test
    @DisplayName("This method tests both if the method creates a unit if the unitType is a match and not")
    void testCreateUnit(){
        InfantryUnit infantryUnit = new InfantryUnit("test", 100);

        assertEquals(infantryUnit.toString(), UnitFactory.createUnit("InfantryUnit", "test", 100).toString());
        assertNull(UnitFactory.createUnit("WizardUnit", "test", 100));
    }

    @Test
    @DisplayName("This method tests if the method creates a list of units")
    void testCreateUnitList(){
        InfantryUnit infantryUnit = new InfantryUnit("test", 100);
        InfantryUnit infantryUnit1 = new InfantryUnit("test", 100);
        List<Unit> unitList = new ArrayList<>();

        unitList.add(infantryUnit);
        unitList.add(infantryUnit1);

        assertEquals(unitList.toString(), UnitFactory.createUnitList("infantryunit", "test", 100, 2).toString());
    }
}