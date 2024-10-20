package com.mlbb.system.util;

import javafx.stage.Screen;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Measures {

    private double width;
    private double height;

    public Measures(double fractionHeight, double fractionWidth) {
        this.height = ((Screen.getPrimary().getBounds().getHeight() / 2.8) * 0.6) / fractionHeight;
        this.width = (Screen.getPrimary().getVisualBounds().getWidth() / 12.5) / fractionWidth;
    }
}
