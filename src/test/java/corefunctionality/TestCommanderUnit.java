package corefunctionality;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class is a test class of the class CommanderUnit
 * @author Martin Hegnum Johannessen
 * @version 1.0-SNAPSHOT
 */
class TestCommanderUnit {

    // A dummy unit for testing the methods
    private CommanderUnit commanderUnit1;
    private CommanderUnit commanderUnit2;

    @BeforeEach
    @DisplayName("This method will create objects for the tests before each test")
    void Setup() {
        commanderUnit1 = new CommanderUnit("Martin", 100, 10, 20);
        commanderUnit2 = new CommanderUnit("Martin", 100, 20, 10);
    }

    @Test
    @DisplayName("This method will test the constructor")
    void TestCommanderUnitConstructor() {
        assertEquals("Martin", commanderUnit1.getName());
        assertEquals(100, commanderUnit1.getHealth());
        assertEquals(10, commanderUnit1.getAttack());
        assertEquals(20, commanderUnit1.getArmour());
    }

    @Test
    @DisplayName("This method will test the setHealth method")
    void testSetHealth() {
        commanderUnit1.setHealth(50);
        commanderUnit2.setHealth(60);
        assertEquals(50, commanderUnit1.getHealth());
        assertEquals(60, commanderUnit2.getHealth());
    }

    @Test
    @DisplayName("This method will test the attack method, and the hitsDealt and hitsTaken counter in it")
    void testAttack(){
        commanderUnit1.attack(commanderUnit2);
        assertEquals(94, commanderUnit2.getHealth());
        assertEquals(1, commanderUnit1.getHitsDealt());
        assertEquals(1, commanderUnit2.getHitsTaken());
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
    @DisplayName("This method will test the getResistBonus method")
    void testGetResistBonus() {
        assertEquals(0, commanderUnit1.getResistBonus());
        assertEquals(0, commanderUnit2.getResistBonus());
    }

    @Test
    @DisplayName("This method will test the getAttackBonus method after the unit has attacked once")
    void testAttackBonusAfterZeroAttacks() {
        assertEquals(6, commanderUnit1.getAttackBonus());
        assertEquals(6, commanderUnit2.getAttackBonus());
        assertEquals(0, commanderUnit1.getHitsDealt());
        assertEquals(0, commanderUnit2.getHitsTaken());
    }

    @Test
    @DisplayName("This method will test the getAttackBonus method after the unit has attacked once")
    void testAttackBonusAfterOneAttack() {
        commanderUnit1.attack(commanderUnit2);
        assertEquals(2, commanderUnit1.getAttackBonus());
        assertEquals(6, commanderUnit2.getAttackBonus());
        assertEquals(1, commanderUnit1.getHitsDealt());
        assertEquals(1, commanderUnit2.getHitsTaken());

    }

}