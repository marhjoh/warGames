package no.ntnu.idatg1002.wargamesapplication.corefunctionality.units;

import no.ntnu.idatg1002.wargamesapplication.exceptions.UnitException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * This class is a test class of the class CavalryUnit
 *
 * @author Martin Hegnum Johannessen
 * @version 1.0-SNAPSHOT
 */
class TestCavalryUnit {


    // A dummy unit for testing the methods
    private CavalryUnit cavalryUnit1;
    private CavalryUnit cavalryUnit2;
    private CavalryUnit cavalryUnit3;

    @BeforeEach
    @DisplayName("This method will create objects for the tests before each test")
    void setup() throws UnitException {
        cavalryUnit1 = new CavalryUnit("Martin", 100, 10, 20);
        cavalryUnit2 = new CavalryUnit("Martin", 100, 20, 10);
        cavalryUnit3 = new CavalryUnit("Martin", 100);

    }

    @Test
    @DisplayName("This method will test the constructor")
    void testCavalryUnitConstructor() {
        assertEquals("Martin", cavalryUnit1.getName());
        assertEquals(100, cavalryUnit1.getHealth());
        assertEquals(10, cavalryUnit1.getAttack());
        assertEquals(20, cavalryUnit1.getArmour());
    }

    @Test
    @DisplayName("This method will test the simple constructor")
    void testSimpleCommanderUnitConstructor() {
        assertEquals("Martin", cavalryUnit3.getName());
        assertEquals(100, cavalryUnit3.getHealth());
        assertEquals(20, cavalryUnit3.getAttack());
        assertEquals(12, cavalryUnit3.getArmour());
    }

    @Test
    @DisplayName("This method will test the setHealth method")
    void testSetHealth() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> cavalryUnit1.setHealth(-999));
    }

    @Test
    @DisplayName("This method will test the attack method")
    void testAttack() {
        try {
            Unit dominantUnit = new InfantryUnit("Martin", 100, 200, 100);
            Unit weakUnit = new InfantryUnit("Stian", 1, 1, 1);
            dominantUnit.attack(weakUnit, 'P');
        } catch (UnitException unitException) {
            fail();
        }
    }

    @Test
    @DisplayName("This method will test the getName method")
    void testGetName() {
        assertEquals("Martin", cavalryUnit1.getName());
        assertEquals("Martin", cavalryUnit2.getName());
    }

    @Test
    @DisplayName("This method will test the getHealth method")
    void testGetHealth() {
        assertEquals(100, cavalryUnit1.getHealth());
        assertEquals(100, cavalryUnit2.getHealth());
    }

    @Test
    @DisplayName("This method will test the getAttack method")
    void testGetAttack() {
        assertEquals(10, cavalryUnit1.getAttack());
        assertEquals(20, cavalryUnit2.getAttack());
    }

    @Test
    @DisplayName("This method will test the getResistBonus method after zero hits taken")
    void testGetResistBonusAfterZeroHitsTaken() {
        assertEquals(0, cavalryUnit1.getResistBonus('P'));
        assertEquals(0, cavalryUnit2.getResistBonus('P'));
        assertEquals(0, cavalryUnit1.getHitsTaken());
        assertEquals(0, cavalryUnit2.getHitsTaken());
    }

    @Test
    @DisplayName("This method will test the getResistBonus method after one hit taken in forest terrain")
    void testGetResistBonusAfterOneHitTaken() {
        cavalryUnit1.attack(cavalryUnit2, 'F');
        assertEquals(0, cavalryUnit2.getResistBonus('F'));
        assertEquals(1, cavalryUnit2.getHitsTaken());
    }

    @Test
    @DisplayName("This method will test the getAttackBonus method")
    void testGetAttackBonusAfterZeroAttacks() {
        assertEquals(9, cavalryUnit1.getAttackBonus('P'));
        assertEquals(9, cavalryUnit2.getAttackBonus('P'));
    }

    @Test
    @DisplayName("This method will test the getAttackBonus method after the unit has attacked once")
    void testGetAttackBonusAfterOneAttack() {
        cavalryUnit1.attack(cavalryUnit2, 'P');
        assertEquals(5, cavalryUnit1.getAttackBonus('P'));
        assertEquals(1, cavalryUnit1.getHitsDealt());
    }
}