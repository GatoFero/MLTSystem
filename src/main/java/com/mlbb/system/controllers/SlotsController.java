package com.mlbb.system.controllers;

import com.mlbb.system.models.enums.Role;
import com.mlbb.system.models.SlotComponent;
import com.mlbb.system.models.organization.Player;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class SlotsController implements ViewController {

    @FXML
    private HBox teamBlueContain;
    @FXML
    private HBox teamRedContain;

    private List<SlotComponent> slotComponents;
    private int countSlots = 0;

    @Override
    public void renderComponent(String resource){
        int[] slots = {0,9,8,1,2,7,6,3,4,5};
        int slotSelect = slots[countSlots];
        slotComponents.get(slotSelect)
                .getPlayerSlot().heroPickSelect(resource);
        countSlots++;
    }

    @FXML
    public void initialize(){
        List<Player> players = Arrays.asList(
                new Player("Gato Feroz", Role.JG),
                new Player("StreedVoid", Role.RM),
                new Player("Genos", Role.ML),
                new Player("Fab", Role.EL),
                new Player("Dahli", Role.GL),
                new Player("Gaxxis", Role.ML),
                new Player("Trouble", Role.JG),
                new Player("Furius", Role.RM),
                new Player("Akashi", Role.GL),
                new Player("Joel", Role.EL));
        slotComponents = new ArrayList<>();
        int index = 0;
        while (slotComponents.size() < 10) {
            slotComponents.add(new SlotComponent(players.get(index)));
            index++;
        }
        IntStream.range(0, slotComponents.size()).forEach(i -> {
            if (i < 5) teamBlueContain.getChildren().add(slotComponents.get(i).getVBox());
            else teamRedContain.getChildren().add(slotComponents.get(i).getVBox());
        });
    }
}