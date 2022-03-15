package ru.ifmo.se.pokemon.moves;

import ru.ifmo.se.pokemon.*;
import ru.ifmo.se.pokemon.Randomiser;

public class Poison_Jab extends PhysicalMove {
    public Poison_Jab() {
        super(Type.POISON, 80, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        Randomiser check = new Randomiser();
        if (check.Randomiserr(30)) {
            Effect.poison(p);
        }
    }

    @Override
    protected String describe() {
        return "Использовал Poison Jab";
    }

}
