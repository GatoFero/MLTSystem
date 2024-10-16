package com.mlbb.system.controllers;

import com.mlbb.system.models.HeroButton;
import com.mlbb.system.repository.HeroesRepository;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Getter
@Setter
public class DashboardHeroesController {

    private SystemSlotsController systemSlotsController;
    private Runnable openPicksSlotsHandler;
    private HeroesRepository heroesRepository = new HeroesRepository();
    private List<HeroButton> heroButtons;

    @FXML
    private Button openSlotsButton;
    @FXML
    private FlowPane flowPane;


    @FXML
    public void initialize() {
        heroButtons = new ArrayList<>();
        IntStream.range(0, 5).forEach(index ->{
            HeroButton heroButton = new HeroButton(heroesRepository.getHero(index));
            heroButtons.add(heroButton);
            flowPane.getChildren().add(heroButton.getButton());
        });
        openSlotsButton.setOnAction(event -> {
            if (openPicksSlotsHandler != null) {
                openPicksSlotsHandler.run();
            }
        });
    }

    public void setSystemSlotsController(SystemSlotsController systemSlotsController) {
        this.systemSlotsController = systemSlotsController;
        heroButtons.forEach(heroButton ->
            heroButton.getButton().setOnAction(event -> {
               this.systemSlotsController.prueba(heroButton.getImage());
            })
        );
    }
}
