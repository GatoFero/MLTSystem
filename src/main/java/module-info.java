module com.mlbb.pruebas {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;


    opens com.mlbb.system to javafx.fxml;
    exports com.mlbb.system;
    exports com.mlbb.system.controllers;
    opens com.mlbb.system.controllers to javafx.fxml;
}