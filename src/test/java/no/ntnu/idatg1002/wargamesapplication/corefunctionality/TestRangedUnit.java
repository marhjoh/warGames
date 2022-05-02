package no.ntnu.idatg1002.wargamesapplication.corefunctionality;

import no.ntnu.idatg1002.wargamesapplication.exceptions.UnitException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class is a test class of the class RangedUnit
 * @author Martin Hegnum Johannessen
 * @version 1.0-SNAPSHOT
 */
class TestRangedUnit {

    // A dummy unit for testing the methods
    private RangedUnit rangedUnit1;
    private RangedUnit rangedUnit2;
    private RangedUnit rangedUnit3;

    @BeforeEach
    @DisplayName("This method will create objects for the tests before each test")
    void setup() {
      rangedUnit1 = new RangedUnit("Martin", 100, 10, 20);
      rangedUnit2 = new RangedUnit("Martin", 100, 20, 10);
      rangedUnit3 = new RangedUnit("Martin", 100);
    }

    @Test
    @DisplayName("This method will test the constructor")
    void testRangedUnitConstructor() {
        assertEquals("Martin", rangedUnit1.getName());
        assertEquals(100, rangedUnit1.getHealth());
        assertEquals(10, rangedUnit1.getAttack());
        assertEquals(20, rangedUnit1.getArmour());
    }

    @Test
    @DisplayName("This method will test the simple constructor")
    void testSimpleRangedUnitConstructor() {
        assertEquals("Martin", rangedUnit3.getName());
        assertEquals(100, rangedUnit3.getHealth());
        assertEquals(15, rangedUnit3.getAttack());
        assertEquals(8, rangedUnit3.getArmour());
    }

    @Test
    @DisplayName("This method will test the setHealth method")
    void testSetHealth() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> rangedUnit2.setHealth(-999));
        }

    @Test
    @DisplayName("This method will test the attack method")
    void testAttack(){
        try {
            Unit dominantUnit = new RangedUnit("Martin", 100, 200, 100);
            Unit weakUnit = new RangedUnit("Stian", 1, 1, 1);
            dominantUnit.attack(weakUnit, 'P');
        }
        catch (UnitException unitException){
            fail();
        }
    }

    @Test
    @DisplayName("This method will test the getName method")
    void testGetName() {
        assertEquals("Martin", rangedUnit1.getName());
        assertEquals("Martin", rangedUnit2.getName());
    }

    @Test
    @DisplayName("This method will test the getHealth method")
    void testGetHealth() {
        assertEquals(100, rangedUnit1.getHealth());
        assertEquals(100, rangedUnit2.getHealth());
    }

    @Test
    @DisplayName("This method will test the getAttack method")
    void testGetAttack() {
        assertEquals(10, rangedUnit1.getAttack());
        assertEquals(20, rangedUnit2.getAttack());
    }

    @Test
    @DisplayName("This method will test the getResistBonus method")
    void testGetResistBonus() {
        assertEquals(6, rangedUnit1.getResistBonus('P'));
        assertEquals(6, rangedUnit2.getResistBonus('P'));
    }

    @Test
    @DisplayName("This method will test the getResistBonus method after the unit has been attacked once")
    void testGetResistBonusAfterOneAttack() {
        rangedUnit1.attack(rangedUnit2, 'P');
        assertEquals(4, rangedUnit2.getResistBonus('P'));
    }


    @Test
    @DisplayName("This method will test the getResistBonus method after the unit has been attacked twice")
    void testGetResistBonusAfterTwoAttacks() {
        rangedUnit1.attack(rangedUnit2, 'P');
        rangedUnit1.attack(rangedUnit2, 'P');
        assertEquals(2, rangedUnit2.getResistBonus('P'));
    }

    @Test
    @DisplayName("This method will test the getAttackBonus method")
    void testGetAttackBonus() {
        assertEquals(3, rangedUnit1.getAttackBonus('P'));
        assertEquals(3, rangedUnit2.getAttackBonus('P'));
    }
}