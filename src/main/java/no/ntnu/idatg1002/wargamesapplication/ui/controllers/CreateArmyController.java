package no.ntnu.idatg1002.wargamesapplication.ui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import no.ntnu.idatg1002.wargamesapplication.ui.views.WarGamesApplication;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Class for controlling the Create Army View.
 */
public class CreateArmyController implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    ChoiceBox unitTypeChoiceBox;

    /**
     * initializing the view
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        unitTypeChoiceBox = new ChoiceBox<>();
        unitTypeChoiceBox.getItems().add("Infantry Unit");
        unitTypeChoiceBox.getItems().add("Ranged Unit");
        unitTypeChoiceBox.getItems().add("Commander Unit");
        unitTypeChoiceBox.getItems().add("Cavalry Unit");
    }

    /**
     * Button for returning to the main menu.
     * @param event
     * @throws IOException
     */
    @FXML
    public void OnGoBackToMainMenuButtonClick(ActionEvent event) throws IOException{
        root = new FXMLLoader(getClass().getClassLoader().getResource("MainMenuView.fxml")).load();
        scene = new Scene(root);
        WarGamesApplication.primaryStage.setTitle("Main Menu");
        WarGamesApplication.primaryStage.setScene(scene);
    }

    /**
     * Makes the "Help, FAQ" menuitem open FAQ page
     *
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

    @FXML
    private void getSelectedUnitType(){
        unitTypeChoiceBox.setOnAction((event) -> {
            int selectedIndex = unitTypeChoiceBox.getSelectionModel().getSelectedIndex();
            Object selectedItem = unitTypeChoiceBox.getSelectionModel().getSelectedItem();
        });
    }

    @FXML
    private void onAddUnitsToArmyButtonClick(){

    }

    @FXML
    private void onSaveArmyButtonClick(){

    }

    @FXML
    private void onDeleteUnitButtonClick(){
    }

    @FXML
    private void onCreateNewBattleButtonClick(){

    }
}
