package com.mlbb.system.models.enums;

import lombok.Getter;

@Getter
public enum View {
    DashboardHeroesView("dashboard-heroes-view", "Dashboard"),
    SlotsView("slots-view", "Picks");

    final private String view;
    final private String nameView;

    View(String view, String nameView) {
        this.view = view + ".fxml";
        this.nameView = nameView;
    }
}
