package com.mlbb.system.models;

import com.mlbb.system.util.PathsResources;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class HeroButton implements PathsResources {

    private String resource;
    private ImageView imageView;
    private Button button;

    public HeroButton(String heroResource) {
        this.resource = heroResource;
        Image image = new Image(Objects.requireNonNull(getClass()
                .getResourceAsStream(getPathButtonHero(heroResource))));
        this.imageView = new ImageView(image);
        this.imageView.setFitHeight(92);
        this.imageView.setFitWidth(120);
        this.button = new Button();
        this.button.setGraphic(this.imageView);
    }
}
