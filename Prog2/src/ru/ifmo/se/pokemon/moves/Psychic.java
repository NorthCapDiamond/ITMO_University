package ru.ifmo.se.pokemon.moves;

import ru.ifmo.se.pokemon.*;
import ru.ifmo.se.pokemon.Randomiser;

public class Psychic extends SpecialMove {
    public Psychic() {
        super(Type.PSYCHIC, 90, 100);
    }

    @Override
    protected void applyOppEffects(Pokemon p) {
        Randomiser check = new Randomiser();
        if (check.Randomiserr(10)) {
            double i = p.getStat(Stat.SPECIAL_DEFENSE);
            if (i > -6)
                i--;
            p.setMod(Stat.SPECIAL_DEFENSE, (int) i);
        }
    }

    @Override
    protected String describe() {
        return "Использовал Psychic!";
    }
}
