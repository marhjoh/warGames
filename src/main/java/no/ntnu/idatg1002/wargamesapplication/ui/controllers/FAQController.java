package no.ntnu.idatg1002.wargamesapplication.ui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import no.ntnu.idatg1002.wargamesapplication.ui.views.WarGamesApplication;

import java.io.IOException;

/**
 * Class for controlling the FAQ view.
 */
public class FAQController {

    private Stage stage;
    private Scene scene;
    private Parent root;

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
}
