package no.ntnu.idatg2001.wargamesapplication.corefunctionality;

import no.ntnu.idatg2001.wargamesapplication.corefunctionality.units.CavalryUnit;
import no.ntnu.idatg2001.wargamesapplication.corefunctionality.units.CommanderUnit;
import no.ntnu.idatg2001.wargamesapplication.corefunctionality.units.InfantryUnit;
import no.ntnu.idatg2001.wargamesapplication.corefunctionality.units.RangedUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * This class is a test class of the class battle
 *
 * @author Martin Hegnum Johannessen
 * @version 1.0-SNAPSHOT
 */
class TestBattle {

    private Army dominantArmy;
    private Army weakArmy;
    private Battle battle;
    private Army island;
    private Army finland;

    @BeforeEach
    @DisplayName("This method will create objects for the tests before each test")
    void setup() {
        //For testing toString
        finland = new Army("Finland");
        island = new Army("Island");

        //For testing battle
        dominantArmy = new Army("DominantArmy");
        weakArmy = new Army("WeakArmy");
        battle = new Battle(dominantArmy, weakArmy, 'F');
        InfantryUnit infantryUnit1 = new InfantryUnit("Martin", 100);
        CavalryUnit cavalryUnit1 = new CavalryUnit("Marius", 100);
        CommanderUnit commanderUnit1 = new CommanderUnit("Morten", 100);
        RangedUnit rangedUnit1 = new RangedUnit("Mikkel", 100);
        InfantryUnit infantryUnit2 = new InfantryUnit("Stian", 50);
        InfantryUnit infantryUnit3 = new InfantryUnit("Synne", 50);

        dominantArmy.addToArmy(infantryUnit1);
        dominantArmy.addToArmy(cavalryUnit1);
        dominantArmy.addToArmy(commanderUnit1);
        dominantArmy.addToArmy(rangedUnit1);
        weakArmy.addToArmy(infantryUnit2);
        weakArmy.addToArmy(infantryUnit3);
    }

    @Test
    @DisplayName("This method will test the getRandomArmy method, which returns a random army in the battle")
    void testGetRandomArmy(){
        List<Army> militias = new ArrayList<>();
        Army poland = new Army("Poland");
        Army england = new Army("England");
        Battle battle2 = new Battle(poland, england, 'F');

        militias.add(poland);
        militias.add(england);

        assertTrue(militias.contains(battle2.getRandomArmy()), "The army was not found");
    }

    @Test
    @DisplayName("This method will test the simulate method, which returns the army that wins the battle")
    void testSimulate(){
        assertEquals(dominantArmy,battle.simulate());
    }

    @Test
    @DisplayName("This method will test the toString method")
    void testToString() {
        Battle battle = new Battle(island, finland, 'F'); // didn't supply the armies with units
        String expected = "Army One: \n" + "Name: Island\n" + "Army: []Army Two: \n" +
                "Name: Finland\n" + "Army: []"; // the expected value
        assertEquals(expected, battle.toString());
    }

    @Test
    @DisplayName("This method will test the getArmyOne method")
    void testGetArmyOne() {
        assertEquals(battle.getArmyOne(), dominantArmy);
    }

    @Test
    @DisplayName("This method will test the getArmyTwo method")
    void testGetArmyTwo() {
        assertEquals(battle.getArmyTwo(), weakArmy);
    }

    @Test
    @DisplayName("This method test if the setTerrain method throws exception if input is invalid")
    void testSetTerrain() {
        Assertions.assertThrows(NullPointerException.class, () -> battle.setTerrain(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> battle.setTerrain('C'));
    }

    @Test
    @DisplayName("This method will test the getTerrain method")
    void testGetTerrain(){
        assertEquals('F', battle.getTerrain());
    }
}
