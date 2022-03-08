package corefunctionality;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class is a test class of the class InfantryUnit
 * @author Martin Hegnum Johannessen
 * @version 1.0-SNAPSHOT
 */
class TestInfantryUnit {

    // A dummy unit for testing the methods
    private InfantryUnit infantry1;
    private InfantryUnit infantry2;

    @BeforeEach
    @DisplayName("This method will create objects for the tests before each test")
    void Setup() {
        infantry1 = new InfantryUnit("Martin", 100, 10, 20);
        infantry2 = new InfantryUnit("Martin", 100, 20, 10);
    }

    @Test
    @DisplayName("This method will test the constructor")
    void TestInfantryUnitConstructor() {
        assertEquals("Martin", infantry1.getName());
        assertEquals(100, infantry1.getHealth());
        assertEquals(10, infantry1.getAttack());
        assertEquals(20, infantry1.getArmour());
    }

    @Test
    @DisplayName("This method will test the setHealth method")
    void testSetHealth() {
        infantry1.setHealth(50);
        infantry2.setHealth(60);
        assertEquals(50, infantry1.getHealth());
        assertEquals(60, infantry2.getHealth());
    }

    @Test
    @DisplayName("This method will test the attack method, and the hitsDealt and hitsTaken counter in it")
    void testAttack(){
        infantry1.attack(infantry2);
        assertEquals(99, infantry2.getHealth());
        assertEquals(1, infantry1.getHitsDealt());
        assertEquals(1, infantry2.getHitsTaken());
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
        assertEquals(1, infantry1.getResistBonus());
        assertEquals(1, infantry2.getResistBonus());
    }

    @Test
    @DisplayName("This method will test the getAttackBonus method")
    void testGetAttackBonus() {
        assertEquals(2, infantry1.getAttackBonus());
        assertEquals(2, infantry2.getAttackBonus());
    }
}