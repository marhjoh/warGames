package no.ntnu.idatg1002.wargamesapplication.ui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import no.ntnu.idatg1002.wargamesapplication.ui.views.WarGamesApplication;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Class for controlling the main menu view.
 */
public class MainMenuController implements Initializable {

    public MenuItem onExitApplication;
    private Stage stage;
    private Scene scene;
    private Parent root;

    /**
     * Makes the "Create new battle" button open the simulate battle view.
     *
     * @param event
     * @throws IOException
     */
    @FXML
    private void onCreateNewBattleButtonClick(ActionEvent event) throws IOException {
        root = new FXMLLoader(getClass().getClassLoader().getResource("SimulateBattleView.fxml")).load();
        scene = new Scene(root);
        WarGamesApplication.primaryStage.setTitle("Battle simulation");
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

    /**
     * initializing the view
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
