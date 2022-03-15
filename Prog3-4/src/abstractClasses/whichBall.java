package abstractClasses;

import components.Ichose;

public abstract class whichBall implements Ichose {

    private boolean isGift;

    public whichBall(boolean isGift) {
        this.isGift = isGift;
    }

    protected whichBall() {
    }

    @Override
    public boolean isGift() {
        return isGift;
    }
}
