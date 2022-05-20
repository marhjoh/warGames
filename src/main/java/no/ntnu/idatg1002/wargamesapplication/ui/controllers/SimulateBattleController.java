package no.ntnu.idatg1002.wargamesapplication.ui.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import no.ntnu.idatg1002.wargamesapplication.corefunctionality.Army;
import no.ntnu.idatg1002.wargamesapplication.corefunctionality.ArmyCount;
import no.ntnu.idatg1002.wargamesapplication.corefunctionality.Battle;
import no.ntnu.idatg1002.wargamesapplication.corefunctionality.Unit;
import no.ntnu.idatg1002.wargamesapplication.filehandler.ArmyFileHandler;
import no.ntnu.idatg1002.wargamesapplication.ui.views.WarGamesApplication;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;


/**
 * Class for controlling the TournamentMaker view.
 */
public class SimulateBattleController implements Initializable {

  /**
   * Initializing the text fields and elements in the two tables.
   */

  ObservableList<ArmyCount> armyOneObservableList;
  ObservableList<ArmyCount> armyTwoObservableList;

  private Stage stage;
  private Scene scene;
  private Parent root;

  @FXML
  ToggleButton leftToggleButton;

  @FXML
  ToggleButton centerToggleButton;

  @FXML
  ToggleButton rightToggleButton;

  @FXML
  TableView<ArmyCount> armyOneTableView;

  @FXML
  TableView<ArmyCount> armyTwoTableView;

  @FXML
  TableColumn<ArmyCount, Integer> armyOneNumberOfUnitsTableColumn;

  @FXML
  TableColumn<ArmyCount, String> armyOneUnitType;

  @FXML
  TableColumn<ArmyCount, Integer> armyTwoNumberOfUnitsTableColumn;

  @FXML
  TableColumn<ArmyCount, String> armyTwoUnitType;

  @FXML
  TableView<Unit> armyOneDetailedTableView;

  @FXML
  TableView<Unit> armyTwoDetailedTableView;

  @FXML
  TableColumn<Unit, String> armyOneUnitTypeTableColumn;

  @FXML
  TableColumn<Unit, String> armyOneUnitNameTableColumn;

  @FXML
  TableColumn<Unit, Integer> armyOneUnitHealthTableColumn;

  @FXML
  TableColumn<Unit, String> armyTwoUnitTypeTableColumn;

  @FXML
  TableColumn<Unit, String> armyTwoUnitNameTableColumn;

  @FXML
  TableColumn<Unit, Integer> armyTwoUnitHealthTableColumn;

  @FXML
  TextArea winnerTextArea;

  private Battle battleSimulation;
  private Army armyOne;
  private Army armyTwo;

  ObservableList<Unit> armyOneObservableList1;
  ObservableList<Unit> armyTwoObservableList2;


  /**
   * Initializing the view
   * @param url
   * @param resourceBundle
   */
  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    armyOne = new Army("armyOne", new ArrayList<>());
    armyTwo = new Army("armyTwo", new ArrayList<>());

    //Choosing a valid terrain, it will not let it simulate though without choosing a terrain
    battleSimulation = new Battle(armyOne, armyTwo, 'P');

    //setting up the observable lists for the table view
    armyOneObservableList = FXCollections.observableList(battleSimulation.getArmyOne().getArmyCount());
    armyTwoObservableList = FXCollections.observableList(battleSimulation.getArmyTwo().getArmyCount());
    armyOneTableView.setItems(armyOneObservableList);
    armyTwoTableView.setItems(armyTwoObservableList);

    // setting up the observable lists for the detailed table view
    armyOneObservableList1 = FXCollections.observableList(battleSimulation.getArmyOne().getFullArmy());
    armyTwoObservableList2 = FXCollections.observableList(battleSimulation.getArmyTwo().getFullArmy());
    armyOneDetailedTableView.setItems(armyOneObservableList1);
    armyTwoDetailedTableView.setItems(armyTwoObservableList2);

    //creating toggleGroup
    ToggleGroup toggleGroup = new ToggleGroup();
    leftToggleButton.setToggleGroup(toggleGroup);
    centerToggleButton.setToggleGroup(toggleGroup);
    rightToggleButton.setToggleGroup(toggleGroup);

    //setting up table view for armyOne
    armyOneNumberOfUnitsTableColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
    armyOneUnitType.setCellValueFactory(new PropertyValueFactory<>("unitName"));

    //setting up detailed table view for armyOne
    armyOneUnitTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("className"));
    armyOneUnitNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    armyOneUnitHealthTableColumn.setCellValueFactory(new PropertyValueFactory<>("health"));

    //setting up table view for armyTwo
    armyTwoNumberOfUnitsTableColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
    armyTwoUnitType.setCellValueFactory(new PropertyValueFactory<>("unitName"));

    //setting up detailed table view for armyTwo
    armyTwoUnitTypeTableColumn.setCellValueFactory(new PropertyValueFactory<>("className"));
    armyTwoUnitNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    armyTwoUnitHealthTableColumn.setCellValueFactory(new PropertyValueFactory<>("health"));
  }

  /**
   * Makes the "Help, FAQ" menuitem open FAQ page
   * @param event
   * @throws IOException
   */
  @FXML
  private void onFAQButtonClick(ActionEvent event) throws IOException {
    root = new FXMLLoader(getClass().getClassLoader().getResource("FAQView.fxml")).load();
    scene = new Scene(root);
    WarGamesApplication.primaryStage.setTitle("FAQ - Frequently Asked Questions");
    WarGamesApplication.primaryStage.setScene(scene);
  }

  /**
   * Makes the "Go back" menuitem open the main menu
   * @param event
   * @throws IOException
   */
  @FXML
  private void onMainMenuButtonClick(ActionEvent event) throws IOException {
    root = new FXMLLoader(getClass().getClassLoader().getResource("MainMenuView.fxml")).load();
    scene = new Scene(root);
    WarGamesApplication.primaryStage.setTitle("Main Menu");
    WarGamesApplication.primaryStage.setScene(scene);
  }

  /**
   * Makes the "load army one" button open directory
   * @param event
   * @throws IOException
   */
  @FXML
  private void onLoadArmyOneButtonClick(ActionEvent event) throws IOException {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Choose file");
    fileChooser.getExtensionFilters().setAll(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
    File selectedFile = fileChooser.showOpenDialog(new Stage());
    if(selectedFile == null){
    }
    else {
      armyOne = ArmyFileHandler.readArmyCsv(selectedFile.getName());
      armyOneTableView.setItems(armyOne.getArmyCount());
      armyOneDetailedTableView.setItems(armyOne.getFullArmy());
    }
  }

  /**
   * Makes the "load army two" button open directory
   * @param event
   * @throws IOException
   */
  @FXML
  private void onLoadArmyTwoButtonClick(ActionEvent event) throws IOException {
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Choose file");
    fileChooser.getExtensionFilters().setAll(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
    File selectedFile = fileChooser.showOpenDialog(new Stage());
    if(selectedFile == null){
    }
    else {
      armyTwo = ArmyFileHandler.readArmyCsv(selectedFile.getName());
      armyTwoTableView.setItems(armyTwo.getArmyCount());
      armyTwoDetailedTableView.setItems(armyTwo.getFullArmy());
    }
  }

  /**
   * Saves two csv files of the armies, one of each army in the battle.
   */
  @FXML
  private void onSaveArmiesButtonClick(ActionEvent event) throws IOException {
    ArmyFileHandler.writeArmyCsv(battleSimulation.getArmyOne(), "ArmyOne");
    ArmyFileHandler.writeArmyCsv(battleSimulation.getArmyTwo(), "ArmyTwo");
    WarGamesApplication.confirmationPopUpWindow("The two armies has now been saved");
  }

  /**
   * Saves a csv file of the battle
   */
  @FXML
  private void onSaveBattleButtonClick(ActionEvent event) throws IOException {
    ArmyFileHandler.writeArmyCsv(battleSimulation.getArmyOne(), "Battle");
    WarGamesApplication.confirmationPopUpWindow("The battle has now been saved");
  }


  /**
   * Makes the text area display the winner of the battle simulation
   */
  @FXML
  private void onSimulateBattleButtonClick(ActionEvent event) throws IOException {
    if((leftToggleButton.isSelected() || centerToggleButton.isSelected() || rightToggleButton.isSelected())
    && (!armyOne.getFullArmy().isEmpty() && !armyTwo.getFullArmy().isEmpty())) {
      checkTerrain();
      Army winnerArmy = battleSimulation.simulate();
      winnerTextArea.setText("The winner is: " + winnerArmy.getName());
    }
    else {
      checkIfArmiesAreEmpty();
    }
    }

  /**
   * This method checks whether the armies are empty or not.
   */
  @FXML
    void checkIfArmiesAreEmpty(){
    if((armyOne.getFullArmy().isEmpty() || armyTwo.getFullArmy().isEmpty()) &&
    (leftToggleButton.isSelected() || centerToggleButton.isSelected() || rightToggleButton.isSelected())) {
      if (armyOne.getFullArmy().isEmpty() && armyTwo.getFullArmy().isEmpty()) {
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
   * This method resets the battle from scratch
   * @throws IOException
   */
  @FXML
  private void resetBattle() throws IOException {
    root = new FXMLLoader(getClass().getClassLoader().getResource("SimulateBattleView.fxml")).load();
    scene = new Scene(root);
    WarGamesApplication.primaryStage.setTitle("Battle simulation");
    WarGamesApplication.primaryStage.setScene(scene);
  }

  /**
   * This method makes the "reset battle" menuItem reset the battle from scratch
   */
  @FXML
  private void onResetBattleButtonClick(ActionEvent event) throws IOException {
    resetBattle();
  }
}
