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
   * Makes the "Load Battle" button open the files.
   * @param event
   * @throws IOException
   */
  @FXML
  private void onLoadBattleButtonClick(ActionEvent event) throws IOException {
      //WarGamesApplication.goToSimulateBattle();
  }

  /**
   * Makes the "View Brackets" button open the Bracket view.
   * @param event
   * @throws IOException
   */
  @FXML
  private void onCreateNewBattleButtonClick(ActionEvent event) throws IOException {
      //WarGamesApplication.goToSimulateBattle();
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
    WarGamesApplication.primaryStage.setScene(scene);
  }


  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
  }

  public void onExitApplication(ActionEvent actionEvent) {
      WarGamesApplication.exitApplicationWindow();
  }

}
