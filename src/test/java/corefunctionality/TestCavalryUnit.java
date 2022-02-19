package corefunctionality;

import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class is a test class of the class CavalryUnit
 * @author Martin Hegnum Johannessen
 * @version 1.0-SNAPSHOT
 */
class TestCavalryUnit {


    // A dummy unit for testing the methods
    private CavalryUnit infantry1;
    private CavalryUnit infantry2;

    @BeforeEach
    @DisplayName("This method will create objects for the tests before each test")
    void Setup() {
        infantry1 = new CavalryUnit("Martin", 100, 10, 20);
        infantry2 = new CavalryUnit("Martin", 100, 20, 10);
    }

    @Test
    void TestCavalryUnitConstructor() {
        assertEquals("Martin", infantry1.getName());
        assertEquals(100, infantry1.getHealth());
        assertEquals(10, infantry1.getAttack());
        assertEquals(20, infantry1.getArmour());
    }

    @Test
    void testAttackAndSetHealth() {
        infantry1.setHealth(50);
        assertEquals(50, infantry1.getHealth());
        infantry2.setHealth(60);
        assertEquals(60, infantry2.getHealth());

        infantry2.setHealth(infantry2.getHealth() - (infantry1.getAttack() + infantry1.getAttackBonus()) + (infantry2.getArmour() + infantry2.getResistBonus()));

        assertEquals(54, infantry2.getHealth());
    }

    @Test
    void testHitsDealtAndHitsTaken(){
        infantry1.attack(infantry2);
        assertEquals(1, infantry1.getHitsDealt());
        assertEquals(1, infantry2.getHitsTaken());
    }

    @Test
    void testGetName() {
        assertEquals("Martin", infantry1.getName());
        assertEquals("Martin", infantry2.getName());
    }

    @Test
    void testGetHealth() {
        assertEquals(100, infantry1.getHealth());
        assertEquals(100, infantry2.getHealth());
    }

    @Test
    void testGetAttack() {
        assertEquals(10, infantry1.getAttack());
        assertEquals(20, infantry2.getAttack());
    }


    @Test
    @Description("")
    void testResistBonus() {
        assertEquals(0, infantry1.getResistBonus());
        assertEquals(0, infantry2.getResistBonus());
    }

    @Test
    void testAttackBonus() {
        assertEquals(6, infantry1.getAttackBonus());
        assertEquals(6, infantry2.getAttackBonus());

        infantry1.attack(infantry2);
        assertEquals(1, infantry1.getHitsDealt());
        assertEquals(2, infantry1.getAttackBonus());

    }
}