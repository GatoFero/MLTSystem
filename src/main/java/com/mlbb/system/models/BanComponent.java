package com.mlbb.system.models;

import com.mlbb.system.util.Measures;
import com.mlbb.system.util.PathsResources;
import com.mlbb.system.util.PickComponent;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class BanComponent implements PathsResources, PickComponent {

    private ImageView imageView;

    public BanComponent() {
        Image image = new Image(Objects.requireNonNull(getClass()
                .getResourceAsStream(getPathGenericResource("ban"))));
        this.imageView = new ImageView(image);
        Measures measures = new Measures(4,1.5);
        this.imageView.setFitWidth(measures.getWidth());
        this.imageView.setFitHeight(measures.getHeight());
    }

    @Override
    public void selectHero(String resource) {
        this.imageView.setImage(new Image(Objects.requireNonNull(getClass()
                .getResourceAsStream(getPathPickBanHero(resource)))));
        ColorAdjust colorAdjust = new ColorAdjust();
        colorAdjust.setSaturation(-1);
        this.imageView.setEffect(colorAdjust);
    }
}