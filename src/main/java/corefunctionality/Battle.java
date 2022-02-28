package corefunctionality;

import java.util.List;
import java.util.Random;

/**
 * This class represents a battle between two armies
 * @author Martin Hegnum Johannessen
 * @version 1.0-SNAPSHOT
 */
public class Battle {
    private Army armyOne;
    private Army armyTwo;
    private Random random;
    private List<Army> militias;

    /**
     * This method creates an instance of a battle
     * @param armyOne an army to battle
     * @param armyTwo an army to battle
     */
    public Battle(Army armyOne, Army armyTwo){
        this.armyOne = armyOne;
        this.armyTwo = armyTwo;
        random = new Random();
    }

    /**
     * This method simulates a battle, a random unit from one army attacks a random unit from another army
     * When one unit gets 0 or below that in health it is removed, this continues until one of the armies win
     * @return the army that wins the battle
     */
    public Army simulate(){
        while(armyOne.hasUnits() && armyTwo.hasUnits()) {
            Unit attacker = getRandomArmy().getRandomUnit();
            Unit armyOneUnit = armyOne.getRandomUnit();
            Unit armyTwoUnit = armyTwo.getRandomUnit();

            if(armyOneUnit.getIsAlive() == false) {
                armyOne.removeUnit(armyOneUnit);
            }

            if(armyTwoUnit.getIsAlive() == false) {
                armyTwo.removeUnit(armyTwoUnit);
            }

            if(armyOne.getAllUnits().contains(attacker)){
                attacker.attack(armyTwoUnit);
            }

            if(armyTwo.getAllUnits().contains(attacker)) {
                attacker.attack(armyOneUnit);
            }
        }

        if(!armyOne.hasUnits()){
            return armyTwo;
        }
        else{
            return armyOne;
        }
    }

    /**
     * This method returns a random army
     * @return a random army
     */
    public Army getRandomArmy(){
        int randomIndex = random.nextInt(0, 1);
        return militias.get(randomIndex);
    }

    @Override
    public String toString() {
        return "Army One: " + armyOne + "\n\nArmy Two: " + armyTwo;
    }

}
