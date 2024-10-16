package com.mlbb.pruebas;

import com.mlbb.pruebas.models.HeroSlot;
import com.mlbb.pruebas.repository.HeroesRepository;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class HelloController {

    @FXML
    private HBox teamBlueContain;
    @FXML
    private HBox teamRedContain;

    private List<HeroSlot> playerViews;
    private final HeroesRepository heroesRepository = new HeroesRepository();
    private int countSlots = 0;

    public void prueba(){
        int[] slots = {0,9,8,1,2,7,6,3,4,5};
        int slotSelect = slots[countSlots];
        Random rand = new Random();
        playerViews.get(slotSelect)
                .heroPickSelect(heroesRepository.getHero
                        (rand.nextInt(heroesRepository.getHeroes().size())));
        countSlots++;
    }

    @FXML
    public void initialize(){
        playerViews = new ArrayList<>();
        while (playerViews.size() < 10) {
            playerViews.add(new HeroSlot());
        }
        IntStream.range(0, playerViews.size()).forEach(i -> {
            if (i < 5) teamBlueContain.getChildren().add(playerViews.get(i).getImageView());
            else teamRedContain.getChildren().add(playerViews.get(i).getImageView());
        });
    }
}