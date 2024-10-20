package com.mlbb.system.util;

public interface PathsResources {

    default String getPathButtonHero(String hero){
        return "/heroes/buttons/" + hero + ".jpg";
    }

    default String getPathPickHero(String hero){
        return "/heroes/slots/" + hero + ".gif";
    }

    default String getPathPickBanHero(String hero){
        return "/heroes/bans/" + hero + ".jpg";
    }

    default String getPathGenericResource(String resource){
        return "/generics/fields/" + resource + ".jpg";
    }

    default String getPathPlayerRole(String role){
        return "/generics/roles/" + role + ".jpg";
    }
}
