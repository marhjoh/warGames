package filehandler;

import corefunctionality.*;
import exceptions.UnitException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
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
     * @param path String to the CVS file.
     * @return Army of units
     */
   public static Army readArmyCsv(String path) {
       Army army = new Army("");

       try (BufferedReader reader = Files.newBufferedReader(Path.of(path))) {
           String lineOfText;
           army.setArmyName(reader.readLine());
           while ((lineOfText = reader.readLine()) != null) {

               String[] units = lineOfText.split(",");
               switch(units[0]){
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
           System.out.println(e.getMessage());
       }
       return army;
   }

    /**
     * Write an Army from a CSV file.
     *
     * @param army units in the army.
     * @param path String to the CVS file.
     */
   public static void writeArmyCsv(Army army, String path) {

       try (BufferedWriter writer = Files.newBufferedWriter(Path.of(path))) {
           writer.write(army.getName() + "\n");

           for (Unit unit : army.getAllUnits()) {
               writer.write(unit.getClass().getSimpleName() + "," + unit.getName() + "," + unit.getHealth() + "\n"); }
           }

       catch (IOException ex) {
           ex.printStackTrace();
       }
   }
}
