package no.ntnu.idatg1002.wargamesapplication.corefunctionality;

import no.ntnu.idatg1002.wargamesapplication.exceptions.UnitException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class is a test class of the class Unit
 * @author Martin Hegnum Johannessen
 * @version 1.0-SNAPSHOT
 */
class TestUnit {

    // A dummy unit for testing the methods
    private InfantryUnit infantry1;
    private CommanderUnit infantry2;


    @BeforeEach
    @DisplayName("This method will create objects for the tests before each test")
    void Setup() throws UnitException {
        infantry1 = new InfantryUnit("Martin", 100, 10, 20);
        infantry2 = new CommanderUnit("Martin", 100, 20, 10);
    }

    @Test
    @DisplayName("This method will test the constructor")
    void TestUnitConstructor() {
        assertEquals("Martin", infantry1.getName());
        assertEquals(100, infantry1.getHealth());
        assertEquals(10, infantry1.getAttack());
        assertEquals(20, infantry1.getArmour());
    }

    @Test
    @DisplayName("This method will test the setHealth method")
    void testSetHealth() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> infantry1.setHealth(-999));
    }

    @Test
    @DisplayName("This method will test the attack method")
    void testAttack(){
        try {
            Unit dominantUnit = new CommanderUnit("Martin", 100, 200, 100);
            Unit weakUnit = new CommanderUnit("Stian", 1, 1, 1);
            dominantUnit.attack(weakUnit, 'P');
        }
        catch (UnitException unitException){
            fail();
        }
    }

    @Test
    @DisplayName("This method will test the setIsAlive method")
    void testSetIsAlive(){
        infantry1.setIsAlive(false);
        infantry2.setIsAlive(true);

        assertEquals(false, infantry1.getIsAlive());
        assertEquals(true, infantry2.getIsAlive());
    }

    @Test
    @DisplayName("This method will test the getName method")
    void testGetName() {
        assertEquals("Martin", infantry1.getName());
        assertEquals("Martin", infantry2.getName());
    }

   @Test
   @DisplayName("This method will test the getHealth method")
   void testGetHealth() {
        assertEquals(100, infantry1.getHealth());
        assertEquals(100, infantry2.getHealth());
    }

    @Test
    @DisplayName("This method will test the getAttack method")
    void testGetAttack() {
        assertEquals(10, infantry1.getAttack());
        assertEquals(20, infantry2.getAttack());
    }

    @Test
    @DisplayName("This method will test the getResistBonus method")
    void testGetResistBonus() {
        assertEquals(1, infantry1.getResistBonus('P'));
        assertEquals(0, infantry2.getResistBonus('P'));
    }

    @Test
    @DisplayName("This method will test the getAttackBonus method")
    void testGetAttackBonus() {
        assertEquals(2, infantry1.getAttackBonus('P'));
        assertEquals(6, infantry2.getAttackBonus('P'));
    }
}
