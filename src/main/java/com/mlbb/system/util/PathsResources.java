package com.mlbb.system.util;


public interface PathsResources {

    default String getPathButtonHero(String hero){
        return "/hero-buttons/" + hero + ".jpg";
    }

    default String getPathPickHero(String hero){
        return "/heroes/" + hero + ".gif";
    }

    default String getPathPlayer(){
        return "/heroes/player.jpg";
    }

    default String getPathPlayerRole(String role){ return "/roles/" + role + ".jpg"; }
}
