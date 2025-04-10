package com.procoloco.blackjack;

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
        var carddeck = new CardDeck();
        var cashier = new Cashier();
        var cashierCards = cashier.getCards();

        for (int i = 1; numbersOfPlayer >= i; i++) {
            System.out.println("Wie heisst du Spieler " + i + "?");
            String playerName = userInput.next();
            int playerBalance = 1500;
            players.add(new Player(i, playerName, playerBalance,0));

        }
        do {


            for (Player p:players){
                System.out.println("Dein Guthaben: "+ p.getBalance());

                System.out.println("Wie viel möchtest du einsetzen "+p.getName()+"?");
                p.setPlayerBet(userInput.nextInt());

                int playerBet = p.getPlayerBet();


                System.out.println();
                System.out.println(p.getName()+" hat "+ playerBet+" gesetzt");
                p.setBalance(p.getBalance()-playerBet);
                System.out.println("Restliches Guthaben: "+p.getBalance());
                System.out.println("");
            }


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


            for (Player p : players) {
                p.playPlayer(carddeck);
            }
            System.out.println(" ");
            System.out.println("Cashier: Cards " + cashier.getCards() + " with value " + cashier.getCardsValuesSum());
            cashier.dealerEndDraw(carddeck);

            for (Player p: players){
                cashier.detectWin(p);
            }

            System.out.println("");
            System.out.println("Do you want to play another round?" + "\n1 - Play another round\n2 - Exit game");
            repeat = userInput.nextInt();

            for (Player p : players) {
                var playerCards = p.getCards();
                playerCards.clear();
            }
            cashierCards=cashier.getCards();
            cashierCards.clear();

        } while (repeat == 1);


    }


}