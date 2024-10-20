package com.mlbb.system.models;

import com.mlbb.system.models.organization.Team;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Getter
@Setter
public class TeamComponent {

    private VBox vbox;
    private List<PlayerComponent> playerComponents;
    private List<BanComponent> banComponents;

    public TeamComponent(Team team, int bans, boolean isBlue) {
        HBox hBoxPlayers = new HBox();
        hBoxPlayers.setSpacing(1.6);
        this.playerComponents = new ArrayList<>();
        team.getPlayers().forEach(player -> {
            PlayerComponent playerComponent = new PlayerComponent(player);
            this.playerComponents.add(playerComponent);
            hBoxPlayers.getChildren().add(playerComponent.getVBox());
        });

        HBox hBoxBans = new HBox();
        hBoxBans.setSpacing(1);
        this.banComponents = new ArrayList<>();
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);
        if (!isBlue){
            createBansComponents(hBoxBans, bans);
            hBoxBans.getChildren().add(spacer);
        } else {
            hBoxBans.getChildren().add(spacer);
            createBansComponents(hBoxBans, bans);
        }
        this.vbox = new VBox();
        this.vbox.getChildren().addAll(hBoxBans, hBoxPlayers);
    }

    private void createBansComponents(HBox hBoxBans, int bans) {
        IntStream.range(0, bans).forEach(i -> {
            BanComponent banComponent = new BanComponent();
            this.banComponents.add(banComponent);
            hBoxBans.getChildren().add(banComponent.getImageView());
        });
    }
}
