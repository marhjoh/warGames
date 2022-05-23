package no.ntnu.idatg2001.wargamesapplication.ui.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import no.ntnu.idatg2001.wargamesapplication.corefunctionality.Army;
import no.ntnu.idatg2001.wargamesapplication.corefunctionality.Battle;
import no.ntnu.idatg2001.wargamesapplication.corefunctionality.units.Unit;
import no.ntnu.idatg2001.wargamesapplication.corefunctionality.units.UnitFactory;
import no.ntnu.idatg2001.wargamesapplication.filehandler.ArmyFileHandler;
import no.ntnu.idatg2001.wargamesapplication.ui.views.WarGamesApplication;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ResourceBundle;


/**
 * Class for controlling the simulate battle view.
 *
 * @author Martin Hegnum Johannessen
 * @version 1.0-SNAPSHOT
 */
public class SimulateBattleController implements Initializable {

  private Scene scene;
  private Parent root;
  private FileChooser fileChooser;
  private Battle battleSimulation;
  private Army armyOne;
  private Army armyTwo;
  private Army duplicateArmyOne;
  private Army duplicateArmyTwo;
  private ObservableList<Unit> armyOneObservableList;
  private ObservableList<Unit> armyTwoObservableList;
  private String csvFull = "Comma Separated File";
  private String chooseFile = "Choose File";
  private String csv = "*.csv";

  @FXML ToggleButton leftToggleButton;
  @FXML ToggleButton centerToggleButton;
  @FXML ToggleButton rightToggleButton;
  @FXML TableView<Unit> armyOneTableView;
  @FXML TableView<Unit> armyTwoTableView;
  @FXML TableColumn<Unit, String> armyOneUnitTypeTableColumn;
  @FXML TableColumn<Unit, String> armyOneUnitNameTableColumn;
  @FXML TableColumn<Unit, Integer> armyOneUnitHealthTableColumn;
  @FXML TableColumn<Unit, String> armyTwoUnitTypeTableColumn;
  @FXML TableColumn<Unit, String> armyTwoUnitNameTableColumn;
  @FXML TableColumn<Unit, Integer> armyTwoUnitHealthTableColumn;
  @FXML Text winnerText;
  @FXML Text infantryUnitsArmyOne;
  @FXML Text rangedUnitsArmyOne;
  @FXML Text commanderUnitsArmyOne;
  @FXML Text cavalryUnitsArmyOne;
  @FXML Text totalUnitsArmyOne;
  @FXML Text infantryUnitsArmyTwo;
  @FXML Text rangedUnitsArmyTwo;
  @FXML Text commanderUnitsArmyTwo;
  @FXML Text cavalryUnitsArmyTwo;
  @FXML Text totalUnitsArmyTwo;
  @FXML Text armyOneName;
  @FXML Text armyTwoName;
  @FXML Button simulateBattleButton;

  /**
   * Initializing the view
   * @param url
   * @param resourceBundle SimulateBattleView.fxml
   */
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    armyOne = new Army("armyOne", new ArrayList<>());
    armyTwo = new Army("armyTwo", new ArrayList<>());

    //Choosing a valid terrain, it will not let it simulate though without choosing a terrain
    battleSimulation = new Battle(armyOne, armyTwo, 'P');

    // setting up the observable lists for the detailed table view
    armyOneObservableList = FXCollections.observableList(battleSimulation.getArmyOne().getAllUnits());
    armyTwoObservableList = FXCollections.observableList(battleSimulation.getArmyTwo().getAllUnits());
    armyOneTableView.setItems(armyOneObservableList);
    armyTwoTableView.setItems(armyTwoObservableList);

    //creating toggleGroup
    ToggleGroup toggleGroup = new ToggleGroup();
    leftToggleButton.setToggleGroup(toggleGroup);
    centerToggleButton.setToggleGroup(toggleGroup);
    rightToggleButton.setToggleGroup(toggleGroup);

    //setting up detailed table view for armyOne
    armyOneUnitTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("className"));
    armyOneUnitNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    armyOneUnitHealthTableColumn.setCellValueFactory(new PropertyValueFactory<>("health"));

    //setting up detailed table view for armyTwo
    armyTwoUnitTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("className"));
    armyTwoUnitNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    armyTwoUnitHealthTableColumn.setCellValueFactory(new PropertyValueFactory<>("health"));

    winnerText.setText("");
  }

  /**
   * Makes the "Help, FAQ" menu item open FAQ page
   *
   * @param event FAQ menu item is clicked
   * @throws IOException throw exceptions if failed or interrupted I/O operations
   */
  @FXML
  private void onFAQClick(ActionEvent event) throws IOException {
    root = new FXMLLoader(getClass().getClassLoader().getResource("FAQView.fxml")).load();
    scene = new Scene(root);
    WarGamesApplication.primaryStage.setTitle("FAQ - Frequently Asked Questions");
    WarGamesApplication.primaryStage.setScene(scene);
  }

  /**
   * Makes the "Go back" menu item open the main menu
   *
   * @param event main menu - menu item is clicked
   * @throws IOException throw exceptions if failed or interrupted I/O operations
   */
  @FXML
  private void onMainMenuClick(ActionEvent event) throws IOException {
    root = new FXMLLoader(getClass().getClassLoader().getResource("MainMenuView.fxml")).load();
    scene = new Scene(root);
    WarGamesApplication.primaryStage.setTitle("Main Menu");
    WarGamesApplication.primaryStage.setScene(scene);
  }

  /**
   * Makes the "load army one" button open directory
   * @param event load army one button is clicked
   * @throws IOException throw exceptions if failed or interrupted I/O operations
   */
  @FXML
  private void onLoadArmyOneButtonClick(ActionEvent event) throws IOException {
    fileChooser = new FileChooser();
    fileChooser.setTitle(chooseFile);
    fileChooser.getExtensionFilters().setAll(new FileChooser.ExtensionFilter(csvFull, csv));
    File selectedFile = fileChooser.showOpenDialog(new Stage());
    if(selectedFile == null){
    }
    else {
      Army readFromFileArmy = ArmyFileHandler.readArmyCsv(selectedFile);
      armyOne.setUnits(readFromFileArmy.getAllUnits());
      armyOne.setArmyName(readFromFileArmy.getName());
      armyOneTableView.setItems(armyOneObservableList);
      refreshTableView();
      displayUnitCount();
      duplicateArmies();
    }
  }

  /**
   * Makes the "load army two" button open directory
   *
   * @param event load army two button is clicked
   * @throws IOException throw exceptions if failed or interrupted I/O operations
   */
  @FXML
  private void onLoadArmyTwoButtonClick(ActionEvent event) throws IOException {
    fileChooser = new FileChooser();
    fileChooser.setTitle(chooseFile);
    fileChooser.getExtensionFilters().setAll(new FileChooser.ExtensionFilter(csvFull, csv));
    File selectedFile = fileChooser.showOpenDialog(new Stage());
    if(selectedFile == null){
    }
    else {
      Army readFromFileArmy = ArmyFileHandler.readArmyCsv(selectedFile);
      armyTwo.setUnits(readFromFileArmy.getAllUnits());
      armyTwo.setArmyName(readFromFileArmy.getName());
      armyTwoTableView.setItems(armyTwoObservableList);
      refreshTableView();
      displayUnitCount();
      duplicateArmies();
    }
  }

  /**
   * Saves a csv file of army one.
   *
   * @param event save army one menu item is clicked
   */
  @FXML
  private void onSaveArmyOneButtonClick(ActionEvent event) {
    armyOne = new Army(armyOneName.getText());
    armyOne.addAllToArmy(armyOneObservableList);
    fileChooser = new FileChooser();
    fileChooser.setTitle(chooseFile);
    fileChooser.setInitialFileName(armyOne.getName().replace(" ", "-"));
    fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(csv, csvFull));
    fileChooser.setInitialDirectory(new File(Paths.get(".").toAbsolutePath().normalize().toString()));
    File selectedPath = fileChooser.showSaveDialog(simulateBattleButton.getScene().getWindow());
    try {
      ArmyFileHandler.writeArmyCsv(battleSimulation.getArmyOne(), selectedPath);
      WarGamesApplication.confirmationPopUpWindow("Army one has now been saved");
    } catch (IOException ex) {
      ex.printStackTrace();
    }

  }

  /**
   * Saves a csv file of army two
   *
   * @param event save army two menu item is clicked
   */
  @FXML
  private void onSaveArmyTwoButtonClick(ActionEvent event) {
    armyTwo = new Army(armyTwoName.getText());
    armyTwo.addAllToArmy(armyTwoObservableList);
    fileChooser = new FileChooser();
    fileChooser.setTitle(chooseFile);
    fileChooser.setInitialFileName(armyTwo.getName().replace(" ", "-"));
    fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(csv, csvFull));
    fileChooser.setInitialDirectory(new File(Paths.get(".").toAbsolutePath().normalize().toString()));
    File selectedPath = fileChooser.showSaveDialog(simulateBattleButton.getScene().getWindow());
    try {
      ArmyFileHandler.writeArmyCsv(battleSimulation.getArmyTwo(), selectedPath);
      WarGamesApplication.confirmationPopUpWindow("Army two has now been saved");
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  /**
   * Makes the text area display the winner of the battle simulation
   *
   * @param event simulate battle button is clicked
   */
  @FXML
  private void onSimulateBattleButtonClick(ActionEvent event) {
    if((leftToggleButton.isSelected() || centerToggleButton.isSelected() || rightToggleButton.isSelected())
    && (!armyOne.getAllUnits().isEmpty() && !armyTwo.getAllUnits().isEmpty())) {
      checkTerrain();
      Army winnerArmy = battleSimulation.simulate();  //Simulating a battle, returning the winner army
      refreshTableView(); //Updating the table views
      displayUnitCount(); //Updating the display of total units of each unit type
      winnerText.setText("The winner is: \n" + winnerArmy.getName());
    }
    else {
      checkIfArmiesAreEmpty();  //If armies are empty it will not simulate
    }
  }

  /**
   * This method makes the "Create Army" menuItem move to the Create Army Page
   *
   * @param event create army menu item is clicked
   * @throws IOException throw exceptions if failed or interrupted I/O operations
   */
  @FXML
  private void onCreateArmyButtonClick(ActionEvent event) throws IOException {
    root = new FXMLLoader(getClass().getClassLoader().getResource("CreateArmyView.fxml")).load();
    scene = new Scene(root);
    WarGamesApplication.primaryStage.setTitle("Create Army");
    WarGamesApplication.primaryStage.setScene(scene);
  }

  /**
   * This method makes the "reset battle" menuItem reset the battle from scratch
   *
   * @param event battle from scratch button is clicked
   * @throws IOException throw exceptions if failed or interrupted I/O operations
   */
  @FXML
  private void onResetBattleFromScratchClick(ActionEvent event) throws IOException {
    root = new FXMLLoader(getClass().getClassLoader().getResource("SimulateBattleView.fxml")).load();
    scene = new Scene(root);
    WarGamesApplication.primaryStage.setTitle("Battle simulation");
    WarGamesApplication.primaryStage.setScene(scene);
  }

  /**
   * This method makes the "reset battle" menuItem reset the battle with the same armies,
   * without loading the army once more.
   *
   * @param event reset battle menu item is clicked
   */
  @FXML
  private void onResetBattleClick(ActionEvent event) {
    winnerText.setText("");
    if(armyOne.hasUnits() || armyTwo.hasUnits()){
      refreshArmies();
      refreshTableView();
    }
  }

  /**
   * This method checks whether the armies are empty or not.
   */
  @FXML
  void checkIfArmiesAreEmpty(){
    if((armyOne.getAllUnits().isEmpty() || armyTwo.getAllUnits().isEmpty()) &&
            (leftToggleButton.isSelected() || centerToggleButton.isSelected() || rightToggleButton.isSelected())) {
      if (armyOne.getAllUnits().isEmpty() && armyTwo.getAllUnits().isEmpty()) {
        WarGamesApplication.errorPopUpWindow("Both of the armies are empty");
      } else {
        WarGamesApplication.errorPopUpWindow("One of the armies are empty");
      }
    }
    else{
      WarGamesApplication.errorPopUpWindow("Select a terrain, and armies that are not empty"); }
  }

  /**
   * This method checks which terrain is selected.
   */
  @FXML
  private void checkTerrain(){
    if(leftToggleButton.isSelected()){
      battleSimulation.setTerrain('F'); } //Terrain: Forest
    else if(centerToggleButton.isSelected()){
      battleSimulation.setTerrain('H'); } //Terrain: Hills
    else if(rightToggleButton.isSelected()){
      battleSimulation.setTerrain('P'); } //Terrain: Plains
  }

  /**
   * This method refresh the armies unit lists
   */
  @FXML
  private void refreshArmies(){
    armyOne.setUnits(duplicateArmyOne.getAllUnits());
    armyTwo.setUnits(duplicateArmyTwo.getAllUnits());
    duplicateArmies();
  }

  /**
   * This method duplicates the armies
   */
  @FXML
  private void duplicateArmies() {
    duplicateArmyOne = new Army(armyOne.getName());
    duplicateArmyTwo = new Army(armyTwo.getName());

    for (Unit unit : armyOne.getAllUnits()) {
      duplicateArmyOne.addToArmy(UnitFactory.createUnit(unit.getClassName(), unit.getName(), unit.getHealth()));
    }

    for (Unit unit : armyTwo.getAllUnits()) {
      duplicateArmyTwo.addToArmy(UnitFactory.createUnit(unit.getClassName(), unit.getName(), unit.getHealth()));
    }
  }

  /**
   * This method display the unit count of the armies to the view.
   */
  @FXML
  private void displayUnitCount(){
    //armyOne
    if(armyOne.hasUnits()){
      infantryUnitsArmyOne.setText(String.valueOf(armyOne.getInfantryUnits().size()));
      rangedUnitsArmyOne.setText(String.valueOf(armyOne.getRangedUnits().size()));
      commanderUnitsArmyOne.setText(String.valueOf(armyOne.getCommanderUnits().size()));
      cavalryUnitsArmyOne.setText(String.valueOf(armyOne.getCavalryUnits().size()));
      armyOneName.setText(armyOne.getName());
      totalUnitsArmyOne.setText(String.valueOf(armyOne.getAllUnits().size()));
    }
    else{
      //Setting the default text String values
      infantryUnitsArmyOne.setText("xxx");
      rangedUnitsArmyOne.setText("xxx");
      commanderUnitsArmyOne.setText("xxx");
      cavalryUnitsArmyOne.setText("xxx");
      armyOneName.setText(armyOne.getName());
      totalUnitsArmyTwo.setText("xxx");
    }
    //armyTwo
    if(armyTwo.hasUnits()){
      infantryUnitsArmyTwo.setText(String.valueOf(armyTwo.getInfantryUnits().size()));
      rangedUnitsArmyTwo.setText(String.valueOf(armyTwo.getRangedUnits().size()));
      commanderUnitsArmyTwo.setText(String.valueOf(armyTwo.getCommanderUnits().size()));
      cavalryUnitsArmyTwo.setText(String.valueOf(armyTwo.getCavalryUnits().size()));
      armyTwoName.setText(armyTwo.getName());
      totalUnitsArmyTwo.setText(String.valueOf(armyTwo.getAllUnits().size()));
    }
    else {
      //Setting the default text String values
      infantryUnitsArmyTwo.setText("xxx");
      rangedUnitsArmyTwo.setText("xxx");
      commanderUnitsArmyTwo.setText("xxx");
      cavalryUnitsArmyTwo.setText("xxx");
      armyTwoName.setText(armyTwo.getName());
      totalUnitsArmyTwo.setText("xxx");
    }
  }

  /**
   * This method refreshes the table views
   */
  @FXML
  private void refreshTableView(){
    armyOneObservableList = FXCollections.observableList(battleSimulation.getArmyOne().getAllUnits());
    armyTwoObservableList = FXCollections.observableList(battleSimulation.getArmyTwo().getAllUnits());
    armyOneTableView.setItems(armyOneObservableList);
    armyTwoTableView.setItems(armyTwoObservableList);
  }
}
