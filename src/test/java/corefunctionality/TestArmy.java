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
    private Army finland;
    private List<Unit> militia;
    private List<Unit> militia1;
    private List<Unit> militia2;

    @BeforeEach
    @DisplayName("This method will create objects for the tests before each test")
    void Setup() {
        infantry1 = new InfantryUnit("Martin", 100, 10, 20);
        commander1 = new CommanderUnit("Martin", 100, 20, 10);
        militia = new ArrayList<>();
        militia1 = new ArrayList<>();
        militia2 = null;
        norway = new Army("Norway", militia);
        sweden = new Army("Sweden", militia1);
        finland = new Army("Finland", militia2);

    }

    @Test
    @DisplayName("This method will test the constructor")
    void testArmyConstructor(){
        assertEquals("Norway", norway.getName());
        assertEquals(0, norway.getAllUnits().size());
    }

    @Test
    @DisplayName("This method will test to create an army with a militia which equals null")
    void testConstructorWithMilitiaEqualsNull(){
        assertEquals("Finland", finland.getName());
        assertNotNull(finland.getAllUnits().size(), "A new arraylist was not created");
    }

    @Test
    @DisplayName("This method will test the getName method")
    void testGetName() {
        assertEquals("Norway", norway.getName());
    }

    @Test
    @DisplayName("This method will test the getAllUnits method")
    void getAllUnits() {
        assertEquals(0, norway.getAllUnits().size());
    }

    @Test
    @DisplayName("This method will test the addToArmy method")
    void addToArmy() {
        norway.addToArmy(infantry1);
        norway.addToArmy(commander1);
        assertEquals(2, norway.getAllUnits().size());
    }

    @Test
    @DisplayName("This method will test the addAll method, which adds all units from a list to an army")
    void testAddAllToArmy() {
        ArrayList<Unit> humanArmy = new ArrayList<>();
        humanArmy.add(infantry1);
        humanArmy.add(commander1);

        norway.addAllToArmy(humanArmy);

        assertEquals(2, norway.getAllUnits().size());
    }

    @Test
    @DisplayName("This method will test the removeUnit method")
    void testRemoveUnit() {
        norway.addToArmy(infantry1);
        norway.addToArmy(commander1);

        norway.removeUnit(infantry1);

        assertEquals(1, norway.getAllUnits().size());
    }

    @Test
    @DisplayName("This method will test the hasUnits method")
    void testHasUnits() {
        assertEquals(false, norway.hasUnits());
    }

    @Test
    @DisplayName("This method will test the toString method")
    void testToString() {
        assertEquals("\nName: Norway" + "\n" +
                "Army: []", norway.toString());
    }

    @Test
    @DisplayName("This method will test the equals method")
    void testEquals() {
        assertEquals(false, norway.equals(sweden));
    }

}