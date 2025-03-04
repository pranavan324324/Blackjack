package Blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Table {

    public static void main(String[] args) {

        System.out.println("Mit wie vielen Spielern möchtest du spielen?"):
        Scanner userInput = new Scanner(System.in);
        int numberOfPlayer = userInput.nextInt();
        List<Player> players = new ArrayList<>();


        for (int i =0;numberOfPlayer>i;i++){
            players.add(new Player(1500));
        }


    }
}