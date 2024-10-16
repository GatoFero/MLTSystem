package com.mlbb.pruebas.models;

import com.mlbb.pruebas.util.PathsResources;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import lombok.Getter;
import lombok.Setter;
import java.util.Objects;

@Getter
@Setter
public class HeroButton{
    private ImageView imageView;

    public HeroButton(String heroResource) {
        Image image = new Image(Objects.requireNonNull(getClass()
                .getResourceAsStream(PathsResources.getPathButtonHero(heroResource))));
        this.imageView = new ImageView(image);
        this.imageView.setFitHeight(140);
        this.imageView.setFitWidth(140);
    }

    public void setImage(String heroResource) {
        this.imageView.setImage(new Image(Objects.requireNonNull(getClass()
                .getResourceAsStream(PathsResources.getPathButtonHero(heroResource)))));
    }
}
