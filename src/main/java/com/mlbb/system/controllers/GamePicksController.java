package com.mlbb.system.controllers;

import com.mlbb.system.models.BanComponent;
import com.mlbb.system.models.TeamComponent;
import com.mlbb.system.models.enums.Country;
import com.mlbb.system.models.enums.Role;
import com.mlbb.system.models.PlayerComponent;
import com.mlbb.system.models.organization.Player;
import com.mlbb.system.models.organization.Team;
import javafx.fxml.FXML;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class GamePicksController implements ViewController {

    @FXML
    private HBox contentTeams;

    private List<TeamComponent> teamsComponents;
    private List<PlayerComponent> playersComponents;
    private List<BanComponent> bansComponents;
    private int countSlots = 0;

    @Override
    public void renderComponent(String resource){
        int[] slots = {0,9,8,1,2,7,6,3,4,5};
        int slotSelect = slots[countSlots];
        bansComponents.get(slotSelect).selectHero(resource);
        playersComponents.get(slotSelect).selectHero(resource);
        countSlots++;
    }

    @FXML
    public void initialize(){
        int cantBans = 5;
        AtomicBoolean isBlue = new AtomicBoolean(true);
        List<Team> teams = getTeams();
        teamsComponents = teams.stream()
                .map(team -> {
                    if (isBlue.get()){
                        TeamComponent teamComponent = new TeamComponent(team, cantBans, isBlue.get());
                        isBlue.set(false);
                        return teamComponent;
                    } else return new TeamComponent(team, cantBans, isBlue.get());
                }).toList();
        Region region = new Region();
        HBox.setHgrow(region, Priority.ALWAYS);
        contentTeams.getChildren().add(teamsComponents.get(0).getVbox());
        contentTeams.getChildren().add(region);
        contentTeams.getChildren().add(teamsComponents.get(1).getVbox());
        playersComponents = teamsComponents.stream()
                .flatMap(teamComponent -> teamComponent.getPlayerComponents().stream())
                .toList();
        bansComponents = teamsComponents.stream()
                .flatMap(teamComponent -> teamComponent.getBanComponents().stream())
                .toList();
    }

    private static List<Team> getTeams() {
        List<Player> radiant = Arrays.asList(
                new Player("Genos", Role.ML), new Player("Gato Feroz", Role.JG),
                new Player("StreedVoid", Role.RM), new Player("Fab", Role.EL),
                new Player("Dahli", Role.GL));
        List<Player> synergy = Arrays.asList
                (new Player("Gaxxis", Role.ML), new Player("Trouble", Role.JG),
                new Player("Furius", Role.RM), new Player("Akashi", Role.GL),
                new Player("Joel", Role.EL));

        return Arrays.asList(new Team("Radiant", "", Country.PER, radiant),
                new Team("Synergy", "", Country.PER, synergy));
    }
}