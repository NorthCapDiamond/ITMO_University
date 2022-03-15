package ru.ifmo.se.pokemon;

public class Randomiser {
    public boolean Randomiserr(int prob) {
        int probability = (int) (Math.random() * 101);
        if (probability < prob + 1)
            return true;
        return false;
    }
}
