package ru.ifmo.se.pokemon;

import ru.ifmo.se.pokemon.poki.*;

public class Main {
    public static void main(String[] args) {
        Battle b = new Battle();
        Pokemon p1 = new Pokemon("Чужой", 1);
        Pokemon p2 = new Pokemon("Хищник", 1);
        BagonPokemon p3 = new BagonPokemon("Bagon", 1);
        SalamencePokemon p4 = new SalamencePokemon("Salamence", 1);
        ShayminLandPokemon p5 = new ShayminLandPokemon("Shaymin-Land", 1);
        ShelgonPokemon p6 = new ShelgonPokemon("Shelgon", 1);
        StarmiePokemon p7 = new StarmiePokemon("Starmine", 1);
        StaryuPokemon p8 = new StaryuPokemon("Staryu", 1);
        b.addAlly(p1);
        b.addFoe(p2);
        b.addAlly(p3);
        b.addFoe(p4);
        b.addAlly(p5);
        b.addFoe(p6);
        b.addAlly(p7);
        b.addAlly(p8);
        b.go();
    }
}
