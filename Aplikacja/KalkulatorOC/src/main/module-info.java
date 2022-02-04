module KalkulatorOC {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    exports main to javafx.graphics;
    opens controller to javafx.controls;
}