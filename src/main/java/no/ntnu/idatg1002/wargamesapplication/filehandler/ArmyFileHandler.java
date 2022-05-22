package no.ntnu.idatg1002.wargamesapplication.filehandler;

import no.ntnu.idatg1002.wargamesapplication.corefunctionality.Army;
import no.ntnu.idatg1002.wargamesapplication.corefunctionality.units.Unit;
import no.ntnu.idatg1002.wargamesapplication.corefunctionality.units.UnitFactory;
import no.ntnu.idatg1002.wargamesapplication.exceptions.UnitException;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

/**
 * Class with static methods for handling csv files of Army.
 */
public class ArmyFileHandler {

    /**
     * This method creates an armyFileHandler
     */
    private ArmyFileHandler(){
    }

    /**
     * Create an Army from a CSV file.
     * @return Army of units
     */
   public static Army readArmyCsv(File filename) throws IOException {
       Army army = new Army("");

       try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
           String lineOfText;

           // Reading first line in file
           lineOfText = reader.readLine();
           if(lineOfText.split(",").length != 1){   // If the length is more than 1 the format is wrong.
               throw new IOException("File format error. There should only be one value");
           }
           army.setArmyName(lineOfText);

           // Looping through unit lines
           while ((lineOfText = reader.readLine()) != null) {

               String[] units = lineOfText.split(",");
               if(units.length != 3){                      // If the length is more than 3 the format is wrong.
                   throw new IOException("Format error. There should be exactly 3 values");
               }
               army.addToArmy(UnitFactory.createUnit(units[0].strip(), units[1].strip(), Integer.parseInt(units[2].strip())));
               }
           }
       catch (IOException | UnitException e) {
           throw new IOException(e.getMessage());
       }
       return army;
   }

    /**
     * Write an Army from a CSV file.
     *
     * @param army units in the army.
     */
    public static void writeArmyCsv(Army army, File file) throws IOException {

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            writer.write(army.getName()+"\n");

            for (Unit unit : army.getAllUnits()) {
                writer.write(unit.getClass().getSimpleName() + "," + unit.getName() + "," + unit.getHealth() + "\n");
            }

        }catch (IOException e){
            throw new IOException(e.getMessage());
        }
    }
}
