module com.mlbb.pruebas {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;


    opens com.mlbb.pruebas to javafx.fxml;
    exports com.mlbb.pruebas;
}