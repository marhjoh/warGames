package GUI;
import corefunctionality.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class BattleApplication {

    private static Battle battle;
    private Scanner readInput;
    private Army norway;
    private Army sweden;
    private List<Unit> militia;

    private static final int LIST_ALL_ARMIES = 1;
    private static final int SIMULATE_BATTLE = 2;
    private static final int EXIT_APPLICATION = 3;

    /**
     * This is the constructor of the battle app
     */
    public BattleApplication() {
        initializeApplication();
    }

    //The method to start the GUI

    /**
     * This method will initialize the application
     */
    public void initializeApplication(){
        militia = new ArrayList<>();
        fillArmies();
        norway = new Army("Norway", militia);
        sweden = new Army("Sweden", militia);
        battle = new Battle(norway, sweden);
        readInput = new Scanner(System.in);
        startApplication();
    }

    public void fillArmies(){
        Unit unit1 = new CavalryUnit("Martin", 100);
        Unit unit2 = new CommanderUnit("Georg", 100);
        Unit unit3 = new InfantryUnit("Christian", 100);
        Unit unit4 = new InfantryUnit("Jonas", 100);
        Unit unit5 = new RangedUnit("Sebastian", 100);
        Unit unit6 = new CavalryUnit("Mikkel", 100);
        Unit unit7 = new CavalryUnit("Zorro", 100);

        militia.add(unit1);
        militia.add(unit2);
        militia.add(unit3);
        militia.add(unit4);
        militia.add(unit5);
        militia.add(unit6);
        militia.add(unit7);
    }

    //Print methods

    /**
     * This method will print out the different menuChoices
     */
    private void printWelcome() {
        System.out.println("\n" + "===================== " + "Welcome to the wargames application!" + " =====================");
        System.out.println("\n" + "Please select your choice" + "\n");
        System.out.println("1. List all armies available");
        System.out.println("2. Simulate battle");
        System.out.println("3. Exit application" + "\n");
    }

    /**
     * This message will print out an exit message
     */
    private void printExit(){
        System.out.println("Goodbye for now!");
    }

    /**
     * This method will print out an error message
     */
    private void printError(){
        System.err.println("[ERROR] Invalid input, please try again!");
    }

    //The methods for the menu

    /**
     * This method will show the menu,
     * @return
     */
    private int showMenu(){
        printWelcome();
        int menuChoice;
        menuChoice = validInputNumberForMenu();
        return menuChoice;
    }

    /**
     * This method starts the application. This is the main loop of the application, presenting the menu,
     * retrieving the selected menu choice from the user, and executing the selected functionality.
     */
    public void startApplication() {
        boolean finished = false;
        // The while-loop will run as long as the user has not selected
        // to exit the application
        do {
            int menuChoice = this.showMenu();
            switch (menuChoice) {
                case LIST_ALL_ARMIES:
                    break;
                case SIMULATE_BATTLE:
                    System.out.println(battle.simulate());
                    break;
                case EXIT_APPLICATION:
                    printExit();
                    finished = true;
                    break;
                default:
                    printError();
                    break;
            }
        }
        while(!finished);
    }

    //The validators

    /**
     * This method validates the given input number for the menu
     *  the menuChoice have to be a number, and cannot be null.
     * @return the menuChoice if it is success.
     */
    private int validInputNumberForMenu(){
        int menuChoice = 0;
        boolean isValid = false;
        while(!isValid) {
            if (readInput.hasNextInt() || readInput.nextLine() == null) {
                menuChoice = readInput.nextInt();
                if (menuChoice >= LIST_ALL_ARMIES && menuChoice <= EXIT_APPLICATION) {
                    isValid = true;
                }
                else{
                    printError();
                    readInput.nextLine();
                }
            }
            else {
                printError();
            }
            readInput.nextLine();
        }
        return menuChoice;
    }

    /**
     * This method validates the number of pages in the book to be added, it will continue as long as it's false
     * @param readInput the input that is given
     * @return the number of pages in the book
     */
    int readIntValueUnitsFrom(Scanner readInput){
        int units = 0;
        boolean isValid = false;
        do {
            boolean inputInteger = readInput.hasNextInt();
            if(inputInteger){
                 units = readInput.nextInt();
            }
            else{
                readInput.next();
            }

            isValid = (units > 0);
            if(!isValid) {
                System.err.println("Your input is invalid, please try again! The input has to be more than 0");
            }
        }
        while(!isValid);
        return units;
    }

    /**
     * This method will create and add a book to the battle app.
     * Bugs: if i  have .nextLine() the method will jump 1 extra skipping the original one
     * Problem: Next will only register the next word, not sentence
     */
    private void addArmy() {
        System.out.println("\nEnter Army Name: ");
        String ArmyName = readInput.nextLine();
        System.out.println("\nEnter Amount of Units: ");
        int units = readIntValueUnitsFrom(readInput);
        System.out.println("\n" + "The army has been added to the battle!");
    }

    private String getValidString(String pattern) {
        boolean validInput = false;
        String input = null;
        do {
            Scanner reader = new Scanner(System.in);
            if (reader.hasNext(pattern)) {
                validInput = true;
                input = reader.nextLine();
            } else{
                System.err.println("INVALID INPUT");
                reader.nextLine();
            }
        }while (!validInput);
        return input;
    }

    public static void main(String[] args) {
        BattleApplication battleApplication = new BattleApplication();
        battleApplication.initializeApplication();
    }
}

