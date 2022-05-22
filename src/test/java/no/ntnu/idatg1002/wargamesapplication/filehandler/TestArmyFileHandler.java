package no.ntnu.idatg1002.wargamesapplication.filehandler;

import no.ntnu.idatg1002.wargamesapplication.corefunctionality.Army;
import no.ntnu.idatg1002.wargamesapplication.corefunctionality.units.CommanderUnit;
import no.ntnu.idatg1002.wargamesapplication.corefunctionality.units.InfantryUnit;
import no.ntnu.idatg1002.wargamesapplication.corefunctionality.units.RangedUnit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * This class is a test class of the class ArmyFileHandler
 *
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
        File file = new File(army.getName());

        try {
            ArmyFileHandler.writeArmyCsv(army, file);
        } catch (IOException e){
            fail();
        }
        Army armyCsv = null;
        try{
            armyCsv = ArmyFileHandler.readArmyCsv(file);
        } catch(Exception e){
            fail();
        }
        assertEquals(army.getName(), armyCsv.getName());
    }
}