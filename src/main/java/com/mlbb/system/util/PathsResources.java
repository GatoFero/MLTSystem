package com.mlbb.system.util;

public interface PathsResources {

    static String getPathButtonHero(String hero){
        return "/hero-buttons/" + hero + ".jpg";
    }

    static String getPathPickHero(String hero){
        return "/heroes/" + hero + ".jpg";
    }

    static String getPathPlayer(){
        return "/heroes/player.jpg";
    }
}
