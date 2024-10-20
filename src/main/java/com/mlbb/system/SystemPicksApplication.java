package com.mlbb.system;

import com.mlbb.system.models.enums.View;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class SystemPicksApplication extends Application {

    @Override
    public void start(Stage stageDashboard) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SystemPicksApplication.class
                .getResource(View.DashboardHeroesView.getView()));
        Scene scene = new Scene(fxmlLoader.load());
        stageDashboard.setTitle(View.DashboardHeroesView.getNameView());
        stageDashboard.setScene(scene);
        stageDashboard.show();
    }

    public static void main(String[] args) {
        launch();
    }
}