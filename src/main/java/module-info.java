module com.example.flightsfx {
    requires javafx.controls;
    requires javafx.fxml;

    exports app.flightsfx.model;
    exports app.flightsfx.utils;

    opens app.flightsfx to javafx.fxml;
    exports app.flightsfx;


}