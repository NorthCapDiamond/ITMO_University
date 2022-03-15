package ru.ifmo.se.pokemon.poki;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;
import ru.ifmo.se.pokemon.moves.Calm_Mind;
import ru.ifmo.se.pokemon.moves.Focus_Blast;
import ru.ifmo.se.pokemon.moves.Rest;
import ru.ifmo.se.pokemon.moves.Thunder_Wave;

public class StarmiePokemon extends Pokemon {
    private String name;
    private int level;

    public StarmiePokemon(String name, int level) {
        super(name, level);
        setType(Type.PSYCHIC, Type.WATER);
        setStats(60, 75, 85, 100, 85, 115);
        setMove(new Rest(), new Thunder_Wave(), new Calm_Mind(), new Focus_Blast());
    }
}