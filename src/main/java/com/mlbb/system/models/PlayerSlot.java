package com.mlbb.system.models;

import com.mlbb.system.util.PathsResources;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class PlayerSlot implements PathsResources {

    private Text text;
    private ImageView imageView;
    private StackPane stackPane;

    public PlayerSlot(String role) {
        Image image = new Image(Objects.requireNonNull(getClass()
                .getResourceAsStream(getPathPlayerRole(role))));
        this.imageView = new ImageView(image);
        this.imageView.setFitWidth(Screen.getPrimary().getVisualBounds().getWidth() / 13);
        this.imageView.setFitHeight((Screen.getPrimary().getBounds().getHeight() / 2.8) * 0.6);
        this.text = new Text();
        this.text.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        this.text.setFill(Color.WHITE);
        this.stackPane = new StackPane();
        this.stackPane.getChildren().addAll(this.imageView, this.text);
    }

    public void heroPickSelect(String resource){
        this.text.setText(resource);
        this.imageView.setImage(new Image(Objects.requireNonNull(getClass()
                .getResourceAsStream(getPathPickHero(resource)))));
    }
}
