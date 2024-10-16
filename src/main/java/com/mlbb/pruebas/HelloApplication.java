package com.mlbb.pruebas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.setTitle("Picks");
        stage.initStyle(StageStyle.UNDECORATED);

        Stage dashboard = new Stage();
        VBox vbox = new VBox();
        Scene dashboardScene = new Scene(vbox, 200, 200);
        dashboard.setScene(dashboardScene);
        Button selectHeroButton = new Button("Seleccionar Héroe");
        selectHeroButton.setOnAction(e -> {
            HelloController controller = fxmlLoader.getController();
            controller.prueba();
        });
        vbox.getChildren().add(selectHeroButton);
        dashboard.show();

        double screenHeight = Screen.getPrimary().getBounds().getHeight();
        double height = screenHeight / 2.8;
        stage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
        stage.setHeight(height);
        stage.setX(0);
        stage.setY(screenHeight - height);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}