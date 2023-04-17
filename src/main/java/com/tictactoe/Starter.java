package com.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

public class Starter {

    // LinkedHashSet pour garder l'ordre lors de l'update
    // Set<String> set = new LinkedHashSet<String>();

    // systeme de tour avec X et O
    // + random tour ordi
    Map<Integer, String> map = new HashMap<Integer, String>();
    Integer round = 1;

    public void firstAffichage() {
        // dictionary
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");
        map.put(4, "4");
        map.put(5, "5");
        map.put(6, "6");
        map.put(7, "7");
        map.put(8, "8");
        map.put(9, "9");
        affichage(map);
    }

    public void affichage(Map<Integer, String> map) {

        System.out.println("--------------");
        for (Entry<Integer, String> entry : map.entrySet()) {

            Integer key = entry.getKey();
            String value = entry.getValue();

            //
            System.out.print(value + " | ");
            if (key.equals(3)) {
                System.out.println("");
                System.out.println("--------------");
            }
            if (key.equals(6)) {
                System.out.println("");
                System.out.println("--------------");
            }
        }
        System.out.println("");
        System.out.println("--------------");
        game();
    }

    void game() {
        System.out.println("");
        System.out.println("Click on 'q' for quit the game");
        System.out.println("value to modify (1 to 9) : ");
        Scanner scanner = new Scanner(System.in);
        String chaine = scanner.nextLine();
        // cle correspond a la valeurs à modifier
        int cle = Integer.parseInt(chaine);

        String crossOrCircle;
        // tant que le tableau contient 1 à 9 :
        if (map.containsKey(cle)) {
            // si valeur associé a la clé n'est pas égale a 123.. pas possible de le changer
            String valueOfTheKey = map.get(cle);
            if (valueOfTheKey == "X" || valueOfTheKey == "O") {
                System.out.println("this square is already playing. play in another square");
                affichage(map);
            }

            System.out.println(cle + " value ok");

            if (round % 2 == 0) {
                crossOrCircle = "O";
            } else {
                crossOrCircle = "X";
            }

            // MAJ DU TABLEAU
            map.put(cle, crossOrCircle);
            verifWin();
            round++;
            System.out.println("ROUND : " + round);
            affichage(map);
        }
        if (chaine.equals("q")) {
            quitGame();
        }
        if ((!map.containsKey(cle))) {
            System.out.println("please enter ONE value between 1 and 9 only for the next round");
            game();

        }

    }

    void quitGame() {
        round = 0;
        System.out.println("See you later !");
    }

    void verifWin() {
        // verification si il y a un winner
        if ((map.get(1).equals("X") || map.get(1).equals("O"))
                && map.get(1).equals(map.get(2))
                && map.get(2).equals(map.get(3))) {
            System.out.println("win");
            quitGame();
        }

    }

}
