package no.ntnu.idatg1002.wargamesapplication.corefunctionality;

import java.util.*;

/**
 * This class represents a battle between two armies
 *
 * @author Martin Hegnum Johannessen
 * @version 1.0-SNAPSHOT
 */
public class Battle {
    private Army armyOne;
    private Army armyTwo;
    private Random random;
    private List<Army> militias;
    private final char[] terrains = {'F', 'P', 'H'};
    private char terrain;

    /**
     * This method creates an instance of a battle
     *
     * @param armyOne an army to battle
     * @param armyTwo an army to battle
     * @param terrain the location of the battle
     */
    public Battle(Army armyOne, Army armyTwo, char terrain) {
        this.armyOne = armyOne;
        this.armyTwo = armyTwo;

        militias = new ArrayList<>();

        militias.add(armyOne);
        militias.add(armyTwo);

        setTerrain(terrain);

        random = new Random();
    }

    public Army getArmyOne() {
        return armyOne;
    }

    public Army getArmyTwo() {
        return armyTwo;
    }

    public void setTerrain(Character terrain) {
        for (Character obtainTerrain : terrains) {
            if (terrain.equals(obtainTerrain)) {
                this.terrain = terrain;
                break;
            }
        }
        if (terrain == null) {
            throw new IllegalArgumentException("Illegal terrain input");
        }
    }

    /**
     * This method simulates a battle, a random unit from one army attacks a random unit from another army
     * When one unit gets 0 or below that in health it is removed, this continues until one of the armies win
     *
     * @return the winner of the battle as an Army
     */
    public Army simulate() {

        while (armyOne.hasUnits() && armyTwo.hasUnits()) {
            Unit defenderUnit;
            int randint = random.nextInt(2);

            if (randint == 0) {
                defenderUnit = armyTwo.getRandomUnit();
                armyOne.getRandomUnit().attack(defenderUnit, terrain);
                if (!defenderUnit.getIsAlive()) {
                    armyTwo.removeUnit(defenderUnit);
                }
            } else {
                defenderUnit = armyOne.getRandomUnit();
                armyTwo.getRandomUnit().attack(defenderUnit, terrain);
                if (!defenderUnit.getIsAlive()) {
                    armyOne.removeUnit(defenderUnit);
                }
            }
        }

        if (!armyTwo.hasUnits())
            return armyOne;
        else
            return armyTwo;
    }

    /**
     * This method returns a random army
     *
     * @return a random Army
     */
    public Army getRandomArmy() {

        if (militias.isEmpty()) {
            return null;
        }

        int randomIndex = random.nextInt(2);
        return militias.get(randomIndex);
    }

    /**
     * Returns the battle as a String
     * @return the battle as a String
     */
    @Override
    public String toString() {
        return "Army One: " + armyOne + "Army Two: " + armyTwo;
    }
}
