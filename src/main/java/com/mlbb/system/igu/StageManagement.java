package com.mlbb.system.igu;

import com.mlbb.system.SystemPicksApplication;
import com.mlbb.system.controllers.ViewController;
import com.mlbb.system.models.enums.View;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import lombok.Getter;
import lombok.Setter;
import java.io.IOException;

@Getter
@Setter
public class StageManagement {

    private final Stage stage;
    private ViewController controller;

    public StageManagement(Stage stage, View view) {
        this.stage = stage;
        this.stage.setTitle(view.getNameView());
        this.stage.setScene(createScene(view));
        this.stage.show();
    }

    public void changeScene(View view) {
        this.stage.setTitle(view.getNameView());
        this.stage.setScene(createScene(view));
    }

    private Scene createScene(View view){
        FXMLLoader fxmlLoader = new FXMLLoader(SystemPicksApplication.class
                .getResource(view.getView()));
        Scene scene;
        try {
            if (fxmlLoader.getLocation() == null) {
                throw new IOException("No se encuentra la vista FXML: " + view.getView());
            }
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            showErrorAlert("No se pudo cargar la vista: " + view.getNameView());
            return null;
        }
        this.controller = fxmlLoader.getController();
        return scene;
    }

    private void showErrorAlert(String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error al cargar la vista");
        alert.setContentText(content);
        alert.showAndWait();
    }
}
