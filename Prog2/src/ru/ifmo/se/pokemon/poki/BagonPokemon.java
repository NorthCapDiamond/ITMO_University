package ru.ifmo.se.pokemon.poki;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;
import ru.ifmo.se.pokemon.moves.Rest;
import ru.ifmo.se.pokemon.moves.Swagger;

public class BagonPokemon extends Pokemon{
    private String name;
    private int level;
    public BagonPokemon(String name, int level) {
        super(name, level);
        setType(Type.DRAGON, Type.FLYING);
        setStats(45,75,60,40,30,50);
        setMove(new Rest(), new Swagger());
    }
}
