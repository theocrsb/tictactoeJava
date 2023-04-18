package com.tictactoe;

import java.util.Random;

public class RandomNumber {

    public int randomNumber() {
        Random r = new Random();
        int low = 1;
        int high = 9;
        int result = r.nextInt(high - low) + low;
        // System.out.println(result + " random number after generate");
        return result;
    }

}