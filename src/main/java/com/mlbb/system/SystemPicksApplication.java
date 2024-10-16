package com.mlbb.system;

import com.mlbb.system.controllers.DashboardHeroesController;
import com.mlbb.system.controllers.SystemSlotsController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class SystemPicksApplication extends Application {

    @Override
    public void start(Stage stageDashboard) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SystemPicksApplication.class
                .getResource("dashboard-heroes-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        DashboardHeroesController dashboardHeroesController = fxmlLoader.getController();
        dashboardHeroesController.setOpenPicksSlotsHandler(() -> {
            try {
                dashboardHeroesController.setSystemSlotsController(openPicksSlotsStage());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        stageDashboard.setTitle("Flex Wrap Example");
        stageDashboard.setScene(scene);
        stageDashboard.show();
    }

    private SystemSlotsController openPicksSlotsStage() throws IOException {
        FXMLLoader fxmlLoaderPicksSlots = new FXMLLoader(SystemPicksApplication.class
                .getResource("slots-view.fxml"));
        Scene scenePicksSlots = new Scene(fxmlLoaderPicksSlots.load());
        Stage stagePicksSlots = new Stage();
        stagePicksSlots.setScene(scenePicksSlots);
        stagePicksSlots.setTitle("PickSlots");
        stagePicksSlots.initStyle(StageStyle.UNDECORATED);
        double screenHeight = Screen.getPrimary().getBounds().getHeight();
        double height = screenHeight / 2.8;
        stagePicksSlots.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
        stagePicksSlots.setHeight(height);
        stagePicksSlots.setY(screenHeight - height);
        stagePicksSlots.setX(0);
        stagePicksSlots.show();
        return fxmlLoaderPicksSlots.getController();
    }

    public static void main(String[] args) {
        launch();
    }
}