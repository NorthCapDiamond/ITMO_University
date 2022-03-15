package ru.ifmo.se.pokemon.moves;

import ru.ifmo.se.pokemon.*;
import ru.ifmo.se.pokemon.Randomiser.*;

public class Fire_Punch extends PhysicalMove {
    public Fire_Punch() {
        super(Type.FIRE, 75, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        Randomiser check = new Randomiser();
        if (check.Randomiserr(30))
            Effect.burn(p);
    }

    @Override
    protected String describe() {
        return "Использовал Fire Punch!";
    }
}
