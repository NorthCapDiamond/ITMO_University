package mainClasses;

import Exc.UncheckExt;

import java.util.Random;

public class RandomGuy {
    private String name;
    private int height;
    Random random = new Random();
    public RandomGuy(String name){
        this.name = name;
        this.height = random.nextInt() * 1000;
        if (this.height>500){
            throw new UncheckExt(height);
        }
    }

}
