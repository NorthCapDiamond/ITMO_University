package mainClasses;

import abstractClasses.whichBall;
import components.ballColors;
import components.ballSizes;

public class ball extends whichBall {
    public ballColors bcolor = ballColors.Зеленый;
    public ballSizes bsize = ballSizes.Большой;
    private String name = bsize + " " + bcolor + " " + "шарик";

    public ball() {
        super(false);
    }

    public ball(ballColors color) {
        super(false);
        this.bcolor = color;
    }

    public ball(ballSizes size) {
        super(false);
        this.bsize = size;
        name = bsize + " " + bcolor + " " + "шарик";
    }

    public ball(ballColors color, ballSizes size) {
        super(false);
        this.bcolor = color;
        this.bsize = size;
        this.name = bsize + " " + bcolor + " " + "шарик";

    }

    public ball(ballColors color, ballSizes size, boolean isGift) {
        super(isGift);
        this.bcolor = color;
        this.bsize = size;
        this.name = bsize + " " + bcolor + " " + "шарик";
    }

    @Override
    public String toString() {
        return bsize + " " + bcolor + " " + "шарик";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj instanceof ball) {
            return (name.equals(((ball) obj).Get()) && isGift() == ((ball) obj).isGift());
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        if (isGift()) {
            return name.hashCode() + name.length();
        } else {
            return name.hashCode();
        }
    }

    @Override
    public String Get() {
        if (name != null) {
            return name;
        } else {
            return "";
        }
    }
}
