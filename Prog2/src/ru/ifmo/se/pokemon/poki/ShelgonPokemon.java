package ru.ifmo.se.pokemon.poki;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;
import ru.ifmo.se.pokemon.moves.Fire_Punch;
import ru.ifmo.se.pokemon.moves.Rest;
import ru.ifmo.se.pokemon.moves.Swagger;

public class ShelgonPokemon extends Pokemon {
    private String name;
    private int level;

    public ShelgonPokemon(String name, int level) {
        super(name, level);
        setType(Type.DRAGON);
        setStats(65, 95, 100, 60, 50, 50);
        setMove(new Rest(), new Swagger(), new Fire_Punch());
    }
}
