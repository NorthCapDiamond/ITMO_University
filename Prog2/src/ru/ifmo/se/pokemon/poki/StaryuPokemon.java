package ru.ifmo.se.pokemon.poki;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;
import ru.ifmo.se.pokemon.moves.Calm_Mind;
import ru.ifmo.se.pokemon.moves.Rest;
import ru.ifmo.se.pokemon.moves.Thunder_Wave;

public class StaryuPokemon extends Pokemon {
    private String name;
    private int level;

    public StaryuPokemon(String name, int level) {
        super(name, level);
        setType(Type.WATER);
        setStats(30, 45, 55, 70, 55, 85);
        setMove(new Rest(), new Thunder_Wave(), new Calm_Mind());
    }
}
