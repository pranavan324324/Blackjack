package Blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Table {


    public static void main(String[] args) {
        int repeat = 1;

        System.out.println("Mit wie vielen Spielern möchtest du spielen?");
        Scanner userInput = new Scanner(System.in);
        int numbersOfPlayer = userInput.nextInt();

        List<Player> players = new ArrayList<>();

        for (int i = 1; numbersOfPlayer >= i; i++) {
            System.out.println("Wie heisst du Spieler " + i + "?");
            String playerName = userInput.next();
            System.out.println(playerName + " mit wie viel Geld möchtest du spielen?");
            int playerBalance = userInput.nextInt();
            players.add(new Player(i, playerName, playerBalance));
        }
        do {
            var carddeck = new CardDeck();

            var cashier = new Cashier();
            var cashierCards = cashier.getCards();
            cashierCards.add(carddeck.drawCard());
            System.out.println("Cashier: Cards " + cashier.getCards() + " with value " + cashier.getCardsValuesSum());
            cashierCards.add(carddeck.drawCard());

            for (Player p : players) {
                var playerCards = p.getCards();
                playerCards.add(carddeck.drawCard());
            }

            for (Player p : players) {
                var playerCards = p.getCards();
                playerCards.add(carddeck.drawCard());
            }


//        for (Player p:players){
//            System.out.println(p.getName()+": " + p.getCards() + " with value " + p.getCardsValuesSum());
//        }
            for (Player p : players) {
                Player.playPlayer(p, carddeck);
            }

            System.out.println("Cashier: Cards " + cashier.getCards() + " with value " + cashier.getCardsValuesSum());
            cashier.dealerEndDraw(cashier, carddeck);

            System.out.println("Do you want to play another round?" + "\n1 - Play another round\n2 - Exit game");
            repeat = userInput.nextInt();

            for (Player p : players) {
                var playerCards = p.getCards();
                playerCards.clear();
            }

        } while (repeat == 1);


    }
}