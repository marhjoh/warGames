package corefunctionality;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

class TestBattle {

    private Army norway;
    private Army sweden;
    private List<Unit> militia;
    private List<Unit> militia1;
    private Unit infantry1;
    private Unit commander1;
    private List<Army> militias;
    private Battle battle;
    private Army island;
    private Army finland;

    @BeforeEach
    @DisplayName("This method will create objects for the tests before each test")
    void Setup() {
        militia = new ArrayList<>();
        militia1 = new ArrayList<>();
        militias = new ArrayList<>();
        infantry1 = new InfantryUnit("Martin", 100, 10, 20);
        commander1 = new CommanderUnit("Martin", 100, 100, 10);
        militia.add(infantry1);
        militia.add(commander1);
        militia1.add(infantry1);
        militia1.add(commander1);
        norway = new Army("Norway", militia);
        sweden = new Army("Sweden", militia1);
        battle = new Battle(sweden, norway);
        militias.add(norway);
        militias.add(sweden);

        List<Unit> militia2 = new ArrayList<>();
        finland = new Army("Finland", militia2);

        List<Unit> militia3 = new ArrayList<>();
        island = new Army("Island", militia3);
    }

    @Test
    void testGetRandomArmy(){
        List<Unit>militia2 = new ArrayList<>();
        List<Unit> militia3 = new ArrayList<>();
        List<Army> militias2 = new ArrayList<>();
        militia2.add(infantry1);
        militia2.add(commander1);
        militia3.add(infantry1);
        militia3.add(commander1);
        Army poland = new Army("Poland", militia2);
        Army england = new Army("England", militia3);
        Battle battle2 = new Battle(poland, england);
        militias2.add(poland);
        militias2.add(england);

        assertEquals(poland.toString(),battle2.getRandomArmy());
    }

    @Test
    @DisplayName("This method will test the simulate method, which returns the army that wins the battle")
    void testSimulate(){
        //TODO: testen kjører for evig dersom jeg fjerner throw invalid health
        assertNotNull(battle.simulate());
        assertEquals(norway,battle.simulate());
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
