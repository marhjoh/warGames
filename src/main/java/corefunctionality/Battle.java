package corefunctionality;

import exceptions.UnitException;

import java.util.ArrayList;
import java.util.InputMismatchException;
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

        militias = new ArrayList<>();

        militias.add(armyOne);
        militias.add(armyTwo);

        random = new Random();
    }

    /**
     * This method simulates a battle, a random unit from one army attacks a random unit from another army
     * When one unit gets 0 or below that in health it is removed, this continues until one of the armies win
     *
     * @return the winner of the battle as an Army
     */
    public Army simulate(){
        while(armyOne.hasUnits() && armyTwo.hasUnits()) {

            Unit defenderUnit;
            if(random.nextInt(2) == 0){
                defenderUnit = armyTwo.getRandomUnit();
                armyOne.getRandomUnit().attack(defenderUnit);
                if(!defenderUnit.getIsAlive()){
                    armyTwo.removeUnit(defenderUnit);
                }
            }else{
                defenderUnit = armyOne.getRandomUnit();
                armyTwo.getRandomUnit().attack(defenderUnit);
                if(!defenderUnit.getIsAlive()){
                    armyOne.removeUnit(defenderUnit);
                }

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
     *
     * @return a random Army
     */
    public Army getRandomArmy(){

        if(militias.isEmpty()){
            return null;
        }

        int randomIndex = random.nextInt(2);
        return militias.get(randomIndex);
    }

    @Override
    public String toString() {
        return "Army One: " + armyOne + "Army Two: " + armyTwo;
    }


}
