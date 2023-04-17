package com.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("do you want to play the game of noughts and crosses ? (y or n) : ");
        String str = br.readLine();

        if (str.equals("y")) {
            System.out.println("You start and you play the crosses !");

            // game start
            Starter starter = new Starter();
            starter.firstAffichage();
        } else {
            System.out.print(" No problem, another time");
            // end
        }
    }
}
