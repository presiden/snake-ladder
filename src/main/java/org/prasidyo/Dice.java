package org.prasidyo;

import java.util.Random;

public class Dice {

    Random random = new Random();
    int min = 1;
    int max = 6;

    public int shuffle(){
        return random.nextInt((max - min) + 1) + min;
    }

}
