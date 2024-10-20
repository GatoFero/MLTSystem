package com.mlbb.system.controllers;

import com.mlbb.system.igu.StageManagement;
import com.mlbb.system.models.HeroButton;
import com.mlbb.system.models.enums.View;
import com.mlbb.system.repository.HeroesRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Getter
@Setter
public class DashboardController implements ViewController {

    private StageManagement stageManagement;
    private HeroesRepository heroesRepository = new HeroesRepository();
    private List<HeroButton> btnHeroes;

    @FXML
    private Button btnOpenStageSlots;
    @FXML
    private FlowPane flowPane;


    @FXML
    public void initialize() {
        btnOpenStageSlots.setOnAction(actionEvent -> {
            Stage slotsStage = new Stage();
            slotsStage.initStyle(StageStyle.UNDECORATED);
            double screenHeight = Screen.getPrimary().getBounds().getHeight();
            slotsStage.setWidth(Screen.getPrimary().getBounds().getWidth());
            slotsStage.setOnShown(event -> {
                slotsStage.setY(screenHeight - slotsStage.getHeight());
            });
            stageManagement = new StageManagement(slotsStage, View.SlotsView);
            setRenderSlots();
        });
        btnHeroes = new ArrayList<>();
        IntStream.range(0, 1).forEach(index ->
            renderComponent(heroesRepository.getHero(index)));
    }

    public void setRenderSlots() {
        btnHeroes.forEach(heroButton ->
                heroButton.getButton().setOnAction(event ->
                    this.stageManagement.getController().renderComponent(heroButton.getResource()))
        );
    }

    @Override
    public void renderComponent(String resource) {
        HeroButton btnHero = new HeroButton(resource);
        btnHeroes.add(btnHero);
        flowPane.getChildren().add(btnHero.getButton());
    }
}
