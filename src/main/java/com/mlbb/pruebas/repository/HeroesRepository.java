package com.mlbb.pruebas.repository;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public class HeroesRepository {
    List<String> heroes;

    public HeroesRepository() {
        this.heroes = Arrays.asList("akai", "alice", "alucard", "balmond", "bane", "bruno",
                "clint", "eudora", "fanny", "franco", "granger", "hayabusa", "karina", "layla",
                "lolita", "minotauro", "miya", "nana", "rafaela", "saber", "tigreal", "zilong"
        );
    }

    public String getHero(int index){
        if (index < heroes.size())
            return heroes.get(index);
        return "player";
    }
}
