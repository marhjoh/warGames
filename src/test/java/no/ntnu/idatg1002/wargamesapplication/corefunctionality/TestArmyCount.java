package no.ntnu.idatg1002.wargamesapplication.corefunctionality;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class is a test class of the class ArmyCount
 * @author Martin Hegnum Johannessen
 * @version 1.0-SNAPSHOT
 */
class TestArmyCount {

    private ArmyCount armyCount;

    @BeforeEach
    @DisplayName("This method will create objects for the tests before each test")
    void setup() {
        armyCount = new ArmyCount("InfantryUnit", 10);
    }

    @Test
    @DisplayName("This method test the ArmyCount constructor")
    void testArmyCountConstructor() {
        assertEquals("InfantryUnit", armyCount.getUnitName());
        assertEquals(10, armyCount.getAmount());
    }

    @Test
    @DisplayName("This method will test the get unit name method")
    void testGetUnitName() {
        assertEquals("InfantryUnit", armyCount.getUnitName());
    }

    @Test
    @DisplayName("This method will test the get amount method")
    void testGetAmount() {
        assertEquals(10, armyCount.getAmount());
    }
}