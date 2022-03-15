package Exc;

import java.io.IOException;

public class CheckExt extends IOException {
    public CheckExt(String name){
        super("Wrong input "+name);
    }
}