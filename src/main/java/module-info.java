module Wargames {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;

    opens no.ntnu.idatg2001.wargamesapplication.corefunctionality to javafx.fxml, javafx.base;
    opens no.ntnu.idatg2001.wargamesapplication.ui.views to javafx.fxml;
    opens no.ntnu.idatg2001.wargamesapplication.ui.controllers to javafx.fxml;

    exports no.ntnu.idatg2001.wargamesapplication.ui.controllers;
    exports no.ntnu.idatg2001.wargamesapplication.ui.views to javafx.graphics;
    opens no.ntnu.idatg2001.wargamesapplication.corefunctionality.units to javafx.base, javafx.fxml;
}
