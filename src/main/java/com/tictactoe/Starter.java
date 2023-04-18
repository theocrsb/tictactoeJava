package com.tictactoe;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class Starter {
    private Map<Integer, String> map = new HashMap<Integer, String>();

    Integer round = 1;

    public void start() {
        // metode d'affichage
        firstAffichage(map);
    }

    public void firstAffichage(Map<Integer, String> map) {
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
        affichage();
    }

    public void affichage() {

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

        RandomNumber numberGenerate = new RandomNumber();
        String crossOrCircle;

        // ----------------------------------------------------------

        if (round % 2 == 0) {
            // round ordi
            System.out.println("COMPUTEUR ROUND");
            crossOrCircle = "O";

            Integer cle = 0;
            cle = numberGenerate.randomNumber();
            String valueOfTheKey = map.get(cle);
            System.out.println(cle + " key");
            System.out.println(valueOfTheKey + " valueofthekey");

            if (valueOfTheKey == "X" || valueOfTheKey == "O") {
                System.out.println("this square is already playing");
                game();
            } else {

                System.out.println("the computer played square : " + cle);

                map.put(cle, crossOrCircle);
                verifWin(crossOrCircle);
                round++;
                affichage();
            }

        } else {
            // round joueur
            System.out.println("PLAYER ROUND");
            crossOrCircle = "X";
            System.out.println("");
            System.out.println("Click on 'q' for quit the game");
            System.out.println("value to modify (1 to 9) : ");
            Scanner scanner = new Scanner(System.in);
            String chaine = scanner.nextLine();
            if (chaine.equals("q")) {
                quitGame();
            }
            int cle = Integer.parseInt(chaine);
            String valueOfTheKey = map.get(cle);
            {

                if (map.containsKey(cle)) {
                    if (valueOfTheKey == "X" || valueOfTheKey == "O") {
                        System.out.println("this square is already playing. play in another square");
                        affichage();
                    }

                    System.out.println(cle + " value ok");

                    // MAJ DU TABLEAU
                    map.put(cle, crossOrCircle);
                    verifWin(crossOrCircle);
                    round++;
                    System.out.println("ROUND : " + round);
                    affichage();
                }

                if ((!map.containsKey(cle))) {
                    System.out.println("please enter ONE value between 1 and 9 only for the next round");
                    game();

                }
            }
        }
    }

    void quitGame() {
        round = 0;
        System.out.println("See you later !");
        System.exit(0);
    }

    void verifWin(String value) {
        // verification si il y a un winner

        if (map.get(1) == value && map.get(2) == value && map.get(3) == value) {
            System.out.println("Player of : " + value + " win on the first line !");
            quitGame();
        }

        if (map.get(4) == value && map.get(5) == value && map.get(6) == value) {
            System.out.println("Player of : " + value + " win on the second line !");
            quitGame();
        }

        if (map.get(7) == value && map.get(8) == value && map.get(9) == value) {
            System.out.println("Player of : " + value + " win on the third line !");
            quitGame();
        }
        if (map.get(1) == value && map.get(4) == value && map.get(7) == value) {
            System.out.println("Player of : " + value + " win on the first column !");
            quitGame();
        }

        if (map.get(2) == value && map.get(5) == value && map.get(8) == value) {
            System.out.println("Player of : " + value + " win on the second column !");
            quitGame();
        }

        if (map.get(3) == value && map.get(6) == value && map.get(9) == value) {
            System.out.println("Player of : " + value + " win on the third column !");
            quitGame();
        }

        if (map.get(1) == value && map.get(5) == value && map.get(9) == value) {
            System.out.println("Player of : " + value + " win on the first diagonal !");
            quitGame();
        }

        if (map.get(3) == value && map.get(5) == value && map.get(7) == value) {
            System.out.println("Player of : " + value + " win on the second diagonal !");
            quitGame();
        }
    }
}
