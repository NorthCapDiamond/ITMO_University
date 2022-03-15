package ru.ifmo.se.pokemon.moves;

import ru.ifmo.se.pokemon.*;

public class Swagger extends StatusMove {
    public Swagger() {
        super(Type.NORMAL, 0, 85);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        Effect.confuse(p);
        double i = p.getStat(Stat.ATTACK);
        if (i < 6)
            i++;
        p.setMod(Stat.ATTACK, (int) i);
    }

    @Override
    protected String describe() {
        return "Использовал Swagger!";
    }
}

