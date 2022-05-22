package no.ntnu.idatg2001.wargamesapplication.ui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import no.ntnu.idatg2001.wargamesapplication.ui.views.WarGamesApplication;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Class for controlling the main menu view.
 *
 * @author Martin Hegnum Johannessen
 * @version 1.0-SNAPSHOT
 */
public class MainMenuController implements Initializable {

    private Scene scene;
    private Parent root;

    /**
     * initializing the view
     * @param url
     * @param resourceBundle MainMenuView.fxml
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    /**
     * Makes the "Create new battle" button open the simulate battle view.
     *
     * @param event
     * @throws IOException throw exceptions if failed or interrupted I/O operations
     */
    @FXML
    private void onCreateBattleButtonClick(ActionEvent event) throws IOException {
        root = new FXMLLoader(getClass().getClassLoader().getResource("SimulateBattleView.fxml")).load();
        scene = new Scene(root);
        WarGamesApplication.primaryStage.setTitle("Battle simulation");
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
     * This method makes the "Create Army" menuItem move to the Create Army Page
     *
     * @param event create army button is clicked
     * @throws IOException throw exceptions if failed or interrupted I/O operations
     */
    @FXML
    private void onCreateArmyButtonClick(ActionEvent event) throws IOException {
        root = new FXMLLoader(getClass().getClassLoader().getResource("CreateArmyView.fxml")).load();
        scene = new Scene(root);
        WarGamesApplication.primaryStage.setTitle("Create Army");
        WarGamesApplication.primaryStage.setScene(scene);
    }
}
