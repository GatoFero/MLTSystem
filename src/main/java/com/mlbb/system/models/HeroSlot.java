package com.mlbb.system.models;

import com.mlbb.system.util.PathsResources;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class HeroSlot {
    private ImageView imageView;

    public HeroSlot() {
        Image image = new Image(Objects.requireNonNull(getClass()
                .getResourceAsStream(PathsResources.getPathPlayer())));
        this.imageView = new ImageView(image);
        this.imageView.setFitHeight(250);
        this.imageView.setFitWidth(140);
    }

    public void heroPickSelect(Image image){
        this.imageView.setImage(image);
    }
}
