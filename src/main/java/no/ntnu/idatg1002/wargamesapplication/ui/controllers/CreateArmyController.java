package no.ntnu.idatg1002.wargamesapplication.ui.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

import no.ntnu.idatg1002.wargamesapplication.corefunctionality.Army;
import no.ntnu.idatg1002.wargamesapplication.corefunctionality.units.Unit;
import no.ntnu.idatg1002.wargamesapplication.corefunctionality.units.UnitFactory;
import no.ntnu.idatg1002.wargamesapplication.filehandler.ArmyFileHandler;
import no.ntnu.idatg1002.wargamesapplication.ui.views.WarGamesApplication;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

/**
 * Class for controlling the Create Army View.
 */
public class CreateArmyController implements Initializable {

    private Scene scene;
    private Parent root;
    private Army army;
    private ObservableList<Unit> armyObservableList;
    private String[] unitTypes = {"InfantryUnit","RangedUnit","CavalryUnit","CommanderUnit"};
    private ArrayList<Unit> rows;

    @FXML TextField armyNameInput;
    @FXML TextField unitNameInput;
    @FXML TextField unitHealthInput;
    @FXML TextField amountOfUnitsInput;
    @FXML ComboBox<String> unitTypeComboBox;
    @FXML TableView<Unit> tableView;
    @FXML TableColumn<Unit, String> unitType;
    @FXML TableColumn<Unit, String> unitName;
    @FXML TableColumn<Unit, Integer> unitHealth;

    /**
     * initializing the view
     *
     * @param url
     * @param resourceBundle CreateArmyView.fxml
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        unitTypeComboBox.setItems(FXCollections.observableArrayList(unitTypes));

        army = new Army("army", new ArrayList<>());

        // setting up the observable list for the table view
        armyObservableList = FXCollections.observableList(army.getAllUnits());
        tableView.setItems(armyObservableList);

        //setting up table view for army
        unitType.setCellValueFactory(new PropertyValueFactory<>("className"));
        unitName.setCellValueFactory(new PropertyValueFactory<>("name"));
        unitHealth.setCellValueFactory(new PropertyValueFactory<>("health"));

        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    /**
     * This method adds all the units to the army, and refreshes the table view.
     */
    @FXML
    private void onAddUnitsToArmyButtonClick(){
        try{
            army.addAllToArmy(UnitFactory.createUnitList(unitTypeComboBox.getValue(), unitNameInput.getText(),
                    parseInt(unitHealthInput.getText()), parseInt(amountOfUnitsInput.getText())));
            refreshTableView();
        }
        catch (IllegalArgumentException exception){
            WarGamesApplication.errorPopUpWindow("You have to input valid values");
        }
    }

    /**
     * This method saves the army when the "Save Army" button is clicked
     */
    @FXML
    private void onSaveArmyButtonClick() {
        army = new Army(armyNameInput.getText());
        army.addAllToArmy(armyObservableList);
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialFileName(armyNameInput.getText().replace(" ", "-"));
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Comma Separated File", "*.csv"));
        fileChooser.setInitialDirectory(new File(Paths.get(".").toAbsolutePath().normalize().toString()));
        File file = fileChooser.showSaveDialog(armyNameInput.getScene().getWindow());
        if (file != null) {
            try {
                ArmyFileHandler.writeArmyCsv(army, file);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

    /**
     * This method deletes the unit from the army when the "Delete Button" is pressed.
     * You can delete multiple units at the same time.
     */
    @FXML
    private void onDeleteUnitButtonClick(){
        try {
            ObservableList<Unit> selectedUnits = tableView.getSelectionModel().getSelectedItems();
            rows = new ArrayList<>(selectedUnits);

            if(!selectedUnits.isEmpty()) {
                rows.forEach(row -> tableView.getItems().remove(row));
                WarGamesApplication.confirmationPopUpWindow("The unit(s) has been deleted");
            }
        }
        catch (Exception e){
            WarGamesApplication.errorPopUpWindow("Unit does not exist");
        }
    }

    /**
     * This method makes the "Create Battle" menu item go to the Create battle page
     *
     * @throws IOException throw exceptions if failed or interrupted I/O operations
     */
    @FXML
    private void onCreateBattleButtonClick() throws IOException {
        root = new FXMLLoader(getClass().getClassLoader().getResource("SimulateBattleView.fxml")).load();
        scene = new Scene(root);
        WarGamesApplication.primaryStage.setTitle("Battle simulation");
        WarGamesApplication.primaryStage.setScene(scene);
    }

    /**
     * This method makes the "Main Menu" menu item return to the main menu.
     *
     * @param event main menu - menu item is clicked
     * @throws IOException throw exceptions if failed or interrupted I/O operations
     */
    @FXML
    public void onMainMenuButtonClick(ActionEvent event) throws IOException{
        root = new FXMLLoader(getClass().getClassLoader().getResource("MainMenuView.fxml")).load();
        scene = new Scene(root);
        WarGamesApplication.primaryStage.setTitle("Main Menu");
        WarGamesApplication.primaryStage.setScene(scene);
    }

    /**
     * This method makes the "Reset Page" menu item reset the page
     *
     * @param event reset page menu item is clicked
     * @throws IOException throw exceptions if failed or interrupted I/O operations
     */
    @FXML
    public void onResetPageClick(ActionEvent event) throws IOException{
        root = new FXMLLoader(getClass().getClassLoader().getResource("CreateArmyView.fxml")).load();
        scene = new Scene(root);
        WarGamesApplication.primaryStage.setTitle("Main Menu");
        WarGamesApplication.primaryStage.setScene(scene);
    }

    /**
     * Makes the "Help, FAQ" menuitem open FAQ page
     *
     * @param event FAQ button is clicked
     * @throws IOException throw exceptions if failed or interrupted I/O operations
     */
    @FXML
    private void onFAQButtonClick(ActionEvent event) throws IOException {
        root = new FXMLLoader(getClass().getClassLoader().getResource("FAQView.fxml")).load();
        scene = new Scene(root);
        WarGamesApplication.primaryStage.setTitle("FAQ - Frequently Asked Questions");
        WarGamesApplication.primaryStage.setScene(scene);
    }

    /**
     * This method refreshes the table view
     */
    @FXML
    private void refreshTableView(){
        armyObservableList = FXCollections.observableList(army.getAllUnits());
        tableView.setItems(armyObservableList);
    }
}
