package filehandler;

import corefunctionality.*;
import exceptions.UnitException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 * Class with static methods for handling ArrayLists of Person.
 */
public class ArmyFileHandler {


    /**
     * Create an Army from a CSV file.
     *
     * @return Army of units
     */
   public static Army readArmyCsv(String filename) throws IOException {
       Army army = new Army("");

       try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/armyFiles/"+filename+".csv"))) {
           String lineOfText;

           // Reading first line in file
           lineOfText = reader.readLine();
           if(lineOfText.split(",").length != 1){
               throw new IOException("File format error. There should only be one value");
           }
           army.setArmyName(lineOfText);

           // Looping through unit lines
           while ((lineOfText = reader.readLine()) != null) {

               String[] units = lineOfText.split(",");
               if(units.length != 3){
                   throw new IOException("Format error. There should be exactly 3 values");
               }

               switch(units[0].strip()){
                   case "CommanderUnit":
                       army.addToArmy(new CommanderUnit(units[1].strip(), Integer.parseInt(units[2].strip())));
                       break;

                   case "CavalryUnit":
                       army.addToArmy(new CavalryUnit(units[1].strip(), Integer.parseInt(units[2].strip())));
                       break;

                   case "InfantryUnit":
                       army.addToArmy(new InfantryUnit(units[1].strip(), Integer.parseInt(units[2].strip())));
                       break;

                   case "RangedUnit":
                       army.addToArmy(new RangedUnit(units[1].strip(), Integer.parseInt(units[2].strip())));
                       break;
               }
           }
       } catch (IOException | UnitException e) {
           throw new IOException(e.getMessage());
       }
       return army;
   }

    /**
     * Write an Army from a CSV file.
     *
     * @param army units in the army.
     */
    public static void writeArmyCsv(Army army, String fileName) throws IOException {

        try(BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/armyFiles/"+fileName+".csv"))){
            writer.write(army.getName()+"\n");

            for (Unit unit : army.getAllUnits()) {
                writer.write(unit.getClass().getSimpleName() + "," + unit.getName() + "," + unit.getHealth() + "\n");
            }

        }catch (IOException e){
            throw new IOException(e.getMessage());
        }


    }
}
