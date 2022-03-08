package corefunctionality;

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

    @BeforeEach
    @DisplayName("This method will create objects for the tests before each test")
    void Setup() {
        rangedUnit1 = new RangedUnit("Martin", 100, 10, 20);
        rangedUnit2 = new RangedUnit("Martin", 100, 20, 10);
    }

    @Test
    @DisplayName("This method will test the constructor")
    void TestRangedUnitConstructor() {
        assertEquals("Martin", rangedUnit1.getName());
        assertEquals(100, rangedUnit1.getHealth());
        assertEquals(10, rangedUnit1.getAttack());
        assertEquals(20, rangedUnit1.getArmour());
    }

    @Test
    @DisplayName("This method will test the setHealth method")
    void testSetHealth() {
        rangedUnit1.setHealth(50);
        rangedUnit2.setHealth(60);
        assertEquals(50, rangedUnit1.getHealth());
        assertEquals(60, rangedUnit2.getHealth());
    }

    @Test
    @DisplayName("This method will test the attack method, and the hitsDealt and hitsTaken counter in it")
    void testAttack(){
        rangedUnit1.attack(rangedUnit2);
        assertEquals(103, rangedUnit2.getHealth());
        assertEquals(1, rangedUnit1.getHitsDealt());
        assertEquals(1, rangedUnit2.getHitsTaken());
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
        assertEquals(6, rangedUnit1.getResistBonus());
        assertEquals(6, rangedUnit2.getResistBonus());
    }

    @Test
    @DisplayName("This method will test the getResistBonus method after the unit has been attacked once")
    void testGetResistBonusAfterOneAttack() {
        rangedUnit1.attack(rangedUnit2);
        assertEquals(4, rangedUnit2.getResistBonus());
    }


    @Test
    @DisplayName("This method will test the getResistBonus method after the unit has been attacked twice")
    void testGetResistBonusAfterTwoAttacks() {
        rangedUnit1.attack(rangedUnit2);
        rangedUnit1.attack(rangedUnit2);
        assertEquals(2, rangedUnit2.getResistBonus());
    }

    @Test
    @DisplayName("This method will test the getAttackBonus method")
    void testGetAttackBonus() {
        assertEquals(3, rangedUnit1.getAttackBonus());
        assertEquals(3, rangedUnit2.getAttackBonus());
    }
}