package ru.ifmo.se.pokemon.moves;

import ru.ifmo.se.pokemon.*;

public class Double_Team extends StatusMove {
    public Double_Team() {
        super(Type.NORMAL, 0, 0);
    }

    @Override
    protected void applySelfEffects(Pokemon p) {
        int i = (int) p.getStat(Stat.EVASION);
        if (i < 6)
            i++;
        p.setMod(Stat.EVASION, i);
    }

    @Override
    protected String describe() {
        return "Использует Double Team";
    }
}
