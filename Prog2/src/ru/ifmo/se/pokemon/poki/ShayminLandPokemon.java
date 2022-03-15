package ru.ifmo.se.pokemon.poki;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;
import ru.ifmo.se.pokemon.moves.Double_Team;
import ru.ifmo.se.pokemon.moves.Poison_Jab;
import ru.ifmo.se.pokemon.moves.Psychic;
import ru.ifmo.se.pokemon.moves.Scratch;

public class ShayminLandPokemon extends Pokemon {
    private String name;
    private int level;

    public ShayminLandPokemon(String name, int level) {
        super(name, level);
        setType(Type.GRASS);
        setStats(100, 100, 100, 100, 100, 100);
        setMove(new Scratch(), new Double_Team(), new Psychic(), new Poison_Jab());
    }
}