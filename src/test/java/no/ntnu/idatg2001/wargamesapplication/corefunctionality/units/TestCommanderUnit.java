package no.ntnu.idatg2001.wargamesapplication.corefunctionality.units;

import no.ntnu.idatg2001.wargamesapplication.exceptions.UnitException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * This class is a test class of the class CommanderUnit
 *
 * @author Martin Hegnum Johannessen
 * @version 1.0-SNAPSHOT
 */
class TestCommanderUnit {

    // A dummy unit for testing the methods
    private CommanderUnit commanderUnit1;
    private CommanderUnit commanderUnit2;
    private CommanderUnit commanderUnit3;

    @BeforeEach
    @DisplayName("This method will create objects for the tests before each test")
    void setup() {
        commanderUnit1 = new CommanderUnit("Martin", 100, 10, 20);
        commanderUnit2 = new CommanderUnit("Martin", 100, 20, 10);
        commanderUnit3 = new CommanderUnit("Martin", 100);
    }

    @Test
    @DisplayName("This method will test the constructor")
    void testCommanderUnitConstructor() {
        assertEquals("Martin", commanderUnit1.getName());
        assertEquals(100, commanderUnit1.getHealth());
        assertEquals(10, commanderUnit1.getAttack());
        assertEquals(20, commanderUnit1.getArmour());
    }

    @Test
    @DisplayName("This method will test the simple constructor")
    void testSimpleCommanderUnitConstructor() {
        assertEquals("Martin", commanderUnit3.getName());
        assertEquals(100, commanderUnit3.getHealth());
        assertEquals(25, commanderUnit3.getAttack());
        assertEquals(15, commanderUnit3.getArmour());
    }

    @Test
    @DisplayName("This method will test the setHealth method")
    void testSetHealth() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> commanderUnit1.setHealth(-999));
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
    @DisplayName("This method will test the getName method")
    void testGetName() {
        assertEquals("Martin", commanderUnit1.getName());
        assertEquals("Martin", commanderUnit2.getName());
    }

    @Test
    @DisplayName("This method will test the getHealth method")
    void testGetHealth() {
        assertEquals(100, commanderUnit1.getHealth());
        assertEquals(100, commanderUnit2.getHealth());
    }

    @Test
    @DisplayName("This method will test the getAttack method")
    void testGetAttack() {
        assertEquals(10, commanderUnit1.getAttack());
        assertEquals(20, commanderUnit2.getAttack());
    }


    @Test
    @DisplayName("This method will test the getResistBonus method after zero hits taken")
    void testGetResistBonusAfterZeroHitsTaken() {
        assertEquals(0, commanderUnit1.getResistBonus('P'));
        assertEquals(0, commanderUnit2.getResistBonus('P'));
    }

    @Test
    @DisplayName("This method will test the getResistBonus method after one hit taken")
    void testGetResistBonusAfterOneHitTaken() {
        commanderUnit1.attack(commanderUnit2, 'P');
        assertEquals(1, commanderUnit2.getResistBonus('P'));
        assertEquals(1, commanderUnit2.getHitsTaken());
    }

    @Test
    @DisplayName("This method will test the getAttackBonus method after the unit has attacked zero times")
    void testAttackBonusAfterZeroAttacks() {
        assertEquals(6, commanderUnit1.getAttackBonus('P'));
        assertEquals(0, commanderUnit1.getHitsDealt());
    }

    @Test
    @DisplayName("This method will test the getAttackBonus method after the unit has attacked once")
    void testAttackBonusAfterOneAttack() {
        commanderUnit1.attack(commanderUnit2, 'P');
        assertEquals(2, commanderUnit1.getAttackBonus('P'));
        assertEquals(1, commanderUnit1.getHitsDealt());
    }

}