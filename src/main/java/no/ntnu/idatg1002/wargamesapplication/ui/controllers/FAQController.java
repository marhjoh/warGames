package no.ntnu.idatg1002.wargamesapplication.ui.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import no.ntnu.idatg1002.wargamesapplication.ui.views.WarGamesApplication;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Class for controlling the FAQ view.
 *
 * @author Martin Hegnum Johannessen
 * @version 1.0-SNAPSHOT
 */
public class FAQController implements Initializable {

    @FXML TextArea textArea;

    /**
     * initializing the view
     * @param resourceBundle FAQView.fxml
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    textArea.setEditable(false);
    }

    /**
     * Button for returning to the main menu.
     *
     * @param event main menu button is clicked
     * @throws IOException throw exceptions if failed or interrupted I/O operations
     */
    @FXML
    public void onGoBackToMainMenuButtonClick(ActionEvent event) throws IOException{
        Parent root = new FXMLLoader(getClass().getClassLoader().getResource("MainMenuView.fxml")).load();
        Scene scene = new Scene(root);
        WarGamesApplication.primaryStage.setTitle("Main Menu");
        WarGamesApplication.primaryStage.setScene(scene);
    }
}
