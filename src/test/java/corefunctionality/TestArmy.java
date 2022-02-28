package corefunctionality;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class is a test class of the class Army
 * @author Martin Hegnum Johannessen
 * @version 1.0-SNAPSHOT
 */
class TestArmy {

    // A dummy unit for testing the methods
    private Unit infantry1;
    private CommanderUnit commander1;
    private Army norway;
    private Army sweden;
    private List<Unit> militia;
    private List<Unit> militia1;


    @BeforeEach
    @DisplayName("This method will create objects for the tests before each test")
    void Setup() {
        infantry1 = new InfantryUnit("Martin", 100, 10, 20);
        commander1 = new CommanderUnit("Martin", 100, 20, 10);
        norway = new Army("Norway", militia);
        sweden = new Army("Sweden", militia1);
    }

    @Test
    void testGetName() {
        assertEquals("Norway", norway.getName());
    }

    @Test
    void getAllUnits() {
        assertEquals(0, norway.getAllUnits().size());
    }

    @Test
    void addToArmy() {
        norway.addToArmy(infantry1);
        assertEquals(1, norway.getAllUnits().size());
        norway.addToArmy(commander1);
        assertEquals(2, norway.getAllUnits().size());
    }

    @Test
    void addAll() {
        ArrayList<Unit> humanArmy = new ArrayList<>();

        humanArmy.add(infantry1);
        humanArmy.add(commander1);

        norway.addAllToArmy(humanArmy);

        assertEquals(2, norway.getAllUnits().size());
    }

    @Test
    void removeUnit() {
        norway.addToArmy(infantry1);
        assertEquals(1, norway.getAllUnits().size());
        norway.removeUnit(infantry1);
        assertEquals(0, norway.getAllUnits().size());
    }

    @Test
    void hasUnits() {
        assertEquals(false, norway.hasUnits());
    }

    @Test
    void testToString() {
        assertEquals("Name: Norway" + "\n" +
                "Army: []", norway.toString());
    }

    @Test
    void testEquals() {
        assertNotEquals(true, norway.equals(sweden));
    }

}