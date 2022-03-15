package ru.ifmo.se.pokemon.moves;

import ru.ifmo.se.pokemon.*;

public class Rest extends StatusMove {
    public Rest() {
        super(Type.PSYCHIC, 0, 0);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        p.restore();
        Effect effect1 = new Effect().turns(2).condition(Status.SLEEP);
        p.addEffect(effect1);
    }

    @Override
    protected String describe() {
        return "Использует REST!";
    }
}
