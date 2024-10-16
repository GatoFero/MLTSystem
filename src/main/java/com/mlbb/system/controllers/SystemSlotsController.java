package com.mlbb.system.controllers;

import com.mlbb.system.models.HeroSlot;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class SystemSlotsController {

    @FXML
    private HBox teamBlueContain;
    @FXML
    private HBox teamRedContain;

    private List<HeroSlot> playerViews;
    private int countSlots = 0;

    public void prueba(Image heroPick){
        int[] slots = {0,9,8,1,2,7,6,3,4,5};
        int slotSelect = slots[countSlots];
        playerViews.get(slotSelect)
                .heroPickSelect(heroPick);
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