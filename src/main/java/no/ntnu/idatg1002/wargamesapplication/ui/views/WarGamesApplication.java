package no.ntnu.idatg1002.wargamesapplication.ui.views;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

/**
 * Class for the graphical user interface. Lets the user interact with the program.
 *
 * @author Martin Hegnum Johannessen
 * @version 1.0-SNAPSHOT
 */
public class WarGamesApplication extends Application {

  public static Stage primaryStage;

  /**
   * The entry-point to start the application.
   *
   * @param args Command-line arguments supplied during startup
   */
  public static void main(String[] args) {
    launch(args);
  }

  /**
   * The start-method is called by the JavaFX platform upon starting the JavaFX-platform.
   *
   * @param stage The stage making up the main window.
   * @throws IOException throw exceptions if failed or interrupted I/O operations
   */
  @Override
  public void start(Stage stage) throws IOException {
    primaryStage = stage;
    FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("MainMenuView.fxml"));

    Parent root = loader.load();
    Scene scene = new Scene(root);
    primaryStage.setScene(scene);

    primaryStage.setTitle("Main Menu");
    primaryStage.setOnCloseRequest(e -> {
      e.consume();
      exitApplicationWindow();
    });
    primaryStage.show();
  }

  /**
   * Method for asking the user for confirmation before closing the application.
   */
  @FXML
  public static void exitApplicationWindow() {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("Confirmation Dialog");
    alert.setHeaderText("Exit Application ?");
    alert.setContentText("Are you sure you want to exit this application?");
    Optional<ButtonType> result = alert.showAndWait();
    if (result.isPresent()) {
      if (result.get() == ButtonType.OK) {
        Platform.exit();
      } else {
      }
    }
  }

  /**
   * Method to show an error popupmenu.
   * @param message, The string of the error message.
   */
  @FXML
  public static void errorPopUpWindow(String message) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle("There was an error");
    alert.setContentText("Error: " + message);

    Optional<ButtonType> result = alert.showAndWait();
    if (result.isPresent()) {
      if (result.get() == ButtonType.OK) {
      } else {
      }
    }
  }

  /**
   * Method to show a confirmation popupmenu.
   * @param message, The string of the confirmation message.
   */
  @FXML
  public static void confirmationPopUpWindow(String message) {
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
    alert.setTitle("There was a confirmation");
    alert.setContentText("Confirmation: " + message);

    Optional<ButtonType> result = alert.showAndWait();
    if (result.isPresent()) {
      if (result.get() == ButtonType.OK) {
      } else {
      }
    }
  }
}
