package no.ntnu.idatg1002.wargamesapplication.filehandler;

import no.ntnu.idatg1002.wargamesapplication.corefunctionality.Army;
import no.ntnu.idatg1002.wargamesapplication.corefunctionality.units.CommanderUnit;
import no.ntnu.idatg1002.wargamesapplication.corefunctionality.units.InfantryUnit;
import no.ntnu.idatg1002.wargamesapplication.corefunctionality.units.RangedUnit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class is a test class of the class ArmyFileHandler
 * @author Martin Hegnum Johannessen
 * @version 1.0-SNAPSHOT
 */
class TestArmyFileHandler {

    @Test
    @DisplayName("This method will test to write an ArmyCsv and to read the ArmyCsv afterwards")
    void testWriteAndReadArmyCsv() {
        Army army = new Army("Norway");
        army.addToArmy(new InfantryUnit("infantry",100));
        army.addToArmy(new RangedUnit("Ranged",100));
        army.addToArmy(new CommanderUnit("Commander",100));

        try {
            ArmyFileHandler.writeArmyCsv(army, army.getName());
        } catch (IOException e){
            fail();
        }
        String armyCsv = "";
        try{
            armyCsv = ArmyFileHandler.readArmyCsv(army.getName() + ".csv").getName();
        } catch(Exception e){
            fail();
        }
        assertEquals(army.getName(), armyCsv);
    }
}