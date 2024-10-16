package com.mlbb.system.models;

import com.mlbb.system.util.PathsResources;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import lombok.Getter;
import lombok.Setter;
import java.util.Objects;

@Getter
@Setter
public class HeroButton{
    private ImageView imageView;
    private Button button;

    public HeroButton(String heroResource) {
        Image image = new Image(Objects.requireNonNull(getClass()
                .getResourceAsStream(PathsResources.getPathPickHero(heroResource))));
        this.imageView = new ImageView(image);
        this.imageView.setFitHeight(140);
        this.imageView.setFitWidth(140);
        this.button = new Button();
        this.button.setGraphic(this.imageView);
    }

    public void setImage(String heroResource) {
        this.imageView.setImage(new Image(Objects.requireNonNull(getClass()
                .getResourceAsStream(PathsResources.getPathButtonHero(heroResource)))));
    }

    public Image getImage() {
        return this.imageView.getImage();
    }
}
