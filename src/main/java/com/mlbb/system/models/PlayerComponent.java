package com.mlbb.system.models;

import com.mlbb.system.models.organization.Player;
import com.mlbb.system.util.Measures;
import com.mlbb.system.util.PathsResources;
import com.mlbb.system.util.PickComponent;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlayerComponent implements PathsResources, PickComponent {

    private VBox vBox;
    private Label nickname;
    private Player player;

    private Label textHero;
    private ImageView viewHero;
    private StackPane stackPane;

    public PlayerComponent(Player player) {
        this.player = player;
        Measures measures = new Measures(1,1);
        this.viewHero = new ImageView(new Image(Objects.requireNonNull(getClass()
                .getResourceAsStream(getPathPlayerRole(player.role().getRole())))));
        this.viewHero.setFitWidth(measures.getWidth());
        this.viewHero.setPreserveRatio(true);

        this.textHero = new Label();
        this.textHero.setPadding(new Insets(10,0,10,0));
        this.textHero.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        this.textHero.setTextFill(Color.WHITE);
        this.stackPane = new StackPane();
        this.stackPane.setMaxSize(measures.getWidth(), measures.getHeight());
        Rectangle clip = new Rectangle(measures.getWidth(), measures.getHeight());
        this.stackPane.setClip(clip);
        this.stackPane.setAlignment(Pos.CENTER);
        this.stackPane.getChildren().addAll(this.viewHero, this.textHero);

        this.nickname = new Label(player.nickname());
        this.nickname.setPadding(new Insets(-20,0,10,0));
        this.nickname.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        this.nickname.setTextFill(Color.WHITE);

        this.vBox = new VBox();
        this.vBox.setSpacing(this.viewHero.getFitHeight() - this.stackPane.getHeight());
        this.vBox.setAlignment(Pos.CENTER);
        this.vBox.getChildren().addAll(this.stackPane, this.nickname);
    }

    @Override
    public void selectHero(String resource){
        this.textHero.setText(resource);
        this.viewHero.setImage(new Image(Objects.requireNonNull(getClass()
                .getResourceAsStream(getPathPickHero(resource)))));
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(3.5), this.viewHero);
        translateTransition.setFromY(0);
        translateTransition.setToY(-12);
        translateTransition.setCycleCount(TranslateTransition.INDEFINITE);
        translateTransition.setAutoReverse(true);
        translateTransition.play();
        AudioClip sound = new AudioClip(Objects.requireNonNull(getClass().getResource("/sounds/sound.wav")).toString());
        sound.setVolume(0.5);
        sound.play();
    }
}
