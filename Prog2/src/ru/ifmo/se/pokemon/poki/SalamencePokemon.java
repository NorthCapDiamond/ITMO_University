package ru.ifmo.se.pokemon.poki;

import ru.ifmo.se.pokemon.*;
import ru.ifmo.se.pokemon.moves.Fire_Punch;
import ru.ifmo.se.pokemon.moves.Rest;
import ru.ifmo.se.pokemon.moves.Screech;
import ru.ifmo.se.pokemon.moves.Swagger;

public class SalamencePokemon extends Pokemon {
    private String name;
    private int level;

    public SalamencePokemon(String name, int level) {
        super(name, level);
        setType(Type.DRAGON, Type.FLYING);
        setStats(95, 135, 80, 110, 80, 100);
        setMove(new Rest(), new Swagger(), new Fire_Punch(), new Screech());
    }
}