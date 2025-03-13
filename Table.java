package Blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Table {

    public static void main(String[] args) {

        System.out.println("Mit wie vielen Spielern möchtest du spielen?");
        Scanner userInput = new Scanner(System.in);
        int numbersOfPlayer = userInput.nextInt();

        List<Player> players = new ArrayList<>();

        for (int i = 1; numbersOfPlayer >= i; i++){
            System.out.println("Wie heisst du Spieler " + i + "?");
            String playerName = userInput.next();
            System.out.println(playerName + " mit wie viel Geld möchtest du spielen?");
            int playerBalance = userInput.nextInt();
            players.add(new Player(i, playerName, playerBalance));
        }

        var carddeck = new CardDeck();

        var cashier = new Cashier();
        var cashierCards = cashier.getCards();
        cashierCards.add(carddeck.drawCard());
        cashierCards.add(carddeck.drawCard());

        for (Player p:players){
            var playerCards = p.getCards();
            playerCards.add(carddeck.drawCard());
        }

        for (Player p:players){
            var playerCards = p.getCards();
            playerCards.add(carddeck.drawCard());
        }

        System.out.println("Cashiercards"+ cashier.getCards().stream().mapToInt(Card::getValue).sum());

        for (Player p:players){
            System.out.println(p.getName()+": "+p.getCards().stream().mapToInt(Card::getValue).sum());
        }
    }
}