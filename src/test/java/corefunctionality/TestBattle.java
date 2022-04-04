package corefunctionality;

import exceptions.UnitException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

class TestBattle {

    private Army dominantArmy;
    private Army weakArmy;
    private Battle battle;
    private Army island;
    private Army finland;

    @BeforeEach
    @DisplayName("This method will create objects for the tests before each test")
    void Setup() {
        //For testing toString
        finland = new Army("Finland");
        island = new Army("Island");

        //For testing battle
        dominantArmy = new Army("DominantArmy");
        weakArmy = new Army("WeakArmy");
        battle = new Battle(dominantArmy, weakArmy);
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
        Battle battle2 = new Battle(poland, england);

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
        Battle battle = new Battle(island, finland); // didn't supply the armies with units
        String expected = "Army One: \n" + "Name: Island\n" + "Army: []Army Two: \n" +
                "Name: Finland\n" + "Army: []"; // the expected value
        assertEquals(expected, battle.toString());
    }

}
