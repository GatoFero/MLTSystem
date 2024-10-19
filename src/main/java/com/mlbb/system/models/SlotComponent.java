package com.mlbb.system.models;

import com.mlbb.system.models.organization.Player;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SlotComponent {

    private VBox vBox;
    private Player player;
    private Text nickname;
    private PlayerSlot playerSlot;

    public SlotComponent(Player player) {
        this.player = player;
        this.nickname = new Text(player.nickname());
        this.nickname.setFont(Font.font("Arial", FontWeight.BOLD, 17));
        this.nickname.setFill(Color.WHITE);
        this.playerSlot = new PlayerSlot(player.role().getRole());
        this.vBox = new VBox(10);
        this.vBox.setAlignment(Pos.CENTER);
        this.vBox.getChildren().addAll(this.playerSlot.getStackPane(), this.nickname);
    }
}
