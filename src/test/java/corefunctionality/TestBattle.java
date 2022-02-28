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

    @BeforeEach
    @DisplayName("This method will create objects for the tests before each test")
    void Setup() {
        militia = new ArrayList<>();
        militia1 = new ArrayList<>();
        militias = new ArrayList<>();
        infantry1 = new InfantryUnit("Martin", 100, 10, 20);
        commander1 = new CommanderUnit("Martin", 100, 20, 10);
        militia.add(infantry1);
        militia.add(commander1);
        militia1.add(infantry1);
        militia1.add(commander1);
        norway = new Army("Norway", militia);
        sweden = new Army("Sweden", militia1);
        battle = new Battle(sweden, norway);
        militias.add(norway);
        militias.add(sweden);

    }


    /**
     * This method simulates a battle, a random unit from one army attacks a random unit from another army
     * When one unit gets 0 or below that in health it is removed, this continues until one of the armies win
     * @return the army that wins the battle
     */
    @Test
    @DisplayName("This method will return the army that wins the battle")
    void testSimulate(){
        assertNotNull(battle.simulate());
        assertEquals(norway,battle.simulate());
    }

    @Test
    void getRandomArmy(){

        militia.add(infantry1);
        militia.add(commander1);
        militia1.add(infantry1);
        militia1.add(commander1);

        militias.add(norway);
        militias.add(sweden);
    }

    @Test
    void testToString() {
        assertEquals("Army One: \nName: Sweden\nArmy: []\n\nArmy Two: \nName: Norway\nArmy: []", battle.toString());
    }

}
