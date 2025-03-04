package Blackjack;

import java.util.*;

public class General {
    public static int card;


    public static int serveCards(Map<String,Integer> map) {
      Random random = new Random();
      var randomSymbol = random.nextInt(4-0+1)+0;
        var cardValues = Carddeck.deckCards.get(Carddeck.elements[randomSymbol]);
      var cardNumber = cardValues.get(random.nextInt(11-2+1)+2);
      Card playerCard = new Card(Carddeck.elements[randomSymbol],cardNumber);
        ArrayList.add(card);
        if (ArrayList == Player.PlayerCards) {
            playerSummarizeCards();
        } else {
            cashierSummarizeCards();
        }
        return card;
    }

    public static int drawCards(ArrayList<Integer> ArrayList) {
        card = Carddeck.deckCards[(int) (Math.random() * 13)];
        System.out.println("Card: " + card);
        ArrayList.add(card);
        if (ArrayList == Player.PlayerCards) {
            playerSummarizeCards();
            System.out.println(Player.cardSummaryPlayer);
            if (bust(playerSummarizeCards())) {
                System.out.println("You are Busted! " + playerSummarizeCards());
            }
        } else {
            cashierSummarizeCards();
            System.out.println(Cashier.cardSummaryCashier);
            if (bust(cashierSummarizeCards())) {
                System.out.println("Cashier is Busted " + cashierSummarizeCards());
            }
        }

        return card;
    }

    public static int playerSummarizeCards() {
        Player.cardSummaryPlayer = 0;
        for (Integer i : Player.PlayerCards) {
            Player.cardSummaryPlayer = Player.cardSummaryPlayer + i;
        }
        return Player.cardSummaryPlayer;
    }

    public static int cashierSummarizeCards() {
        Cashier.cardSummaryCashier = 0;
        for (Integer i : Cashier.cashierCards) {
            Cashier.cardSummaryCashier = Cashier.cardSummaryCashier + i;
        }

        return Cashier.cardSummaryCashier;
    }


    public static boolean bust(int cardSummary) {
        if (cardSummary > 21) {
            return true;
        } else {
            return false;
        }
    }

    public static void getWinner(int playerSum, int cashierSum) {
        if (playerSum > 21) {
            System.out.println("Player looses, as he is busted");
            Player.playerBet = 0;
        } else if (cashierSum > 21) {
            System.out.println("Player wins, as cashier is busted");
            Player.playerBet = Player.playerBet * 2;
        } else if (playerSum > cashierSum) {
            System.out.println("Player wins as he has: " + Player.cardSummaryPlayer + " ,and cashier has: " + Cashier.cardSummaryCashier);
            Player.playerBet = Player.playerBet * 2;
        } else if (cashierSum > playerSum) {
            System.out.println("Cashier wins as he has: " + Cashier.cardSummaryCashier + " ,and you have: " + Player.cardSummaryPlayer);
            Player.playerBet = 0;
        } else {
            System.out.println("Push, both have: " + Cashier.cardSummaryCashier);
        }

    }

    public static boolean blackJack(int playSum) {
        if (playSum == 21) {
            System.out.println("Blackjack :)");
            if (Player.cardSummaryPlayer == 21) {
                System.out.println("Player wins, as he has blackjack");
                Player.playerBet=Player.playerBet*2.5;
            }
            else {
                Player.playerBet=0;
            }
            return true;

        } else return false;
    }

}

