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
            for (Player p : players) {
                var playerCards = p.getCards();
                playerCards.clear();
            }
            cashierCards=cashier.getCards();
            cashierCards.clear();

            for (Player p:players){
                p.getPlayerBets();
            }


            cashierCards.add(carddeck.drawCard());
            System.out.println("Cashier: Cards " + cashier.getCards() + " with value " + cashier.getCardsValuesSum());
            cashierCards.add(carddeck.drawCard());

            for (Player p : players) {
                var playerCards = p.getCards();
                playerCards.add(carddeck.drawCard());
                p.checkIfBlackJack();
            }

            for (Player p : players) {
                var playerCards = p.getCards();
                playerCards.add(carddeck.drawCard());
            }


            for (Player p : players) {
                p.play(carddeck);
            }
            System.out.println(" ");
            System.out.println("Cashier: Cards " + cashier.getCards() + " with value " + cashier.getCardsValuesSum());
            cashier.dealerEndDraw(carddeck);

            for (Player p: players){
                double playerBet = p.getPlayerBet();
                cashier.detectWin(p,playerBet);
            }
            List<Player> playersToRemove = new ArrayList<>();

            for (Player p:players){
                var balance = p.getBalance();
                if (balance<=0){
                    System.out.println("Game over");
                    playersToRemove.add(p);
                }
            }
            for (Player p: playersToRemove) {
                players.remove(p);
            }

            if(players.isEmpty()){
                System.out.println("No players left, GAME OVER!");
                break;
            }

            System.out.println("");
            System.out.println("Do you want to play another round?" + "\n1 - Play another round\n2 - Exit game");
            repeat = userInput.nextInt();



        } while (repeat == 1);

        System.out.println("Game finished!");

    }


}