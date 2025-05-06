package com.procoloco.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Cashier {
    private List<Card> cards = new ArrayList<>();

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Cashier() {

    }

    public int getCardsValuesSum() {
        var cardsValuesSum = cards.stream().mapToInt(Card::getValue).sum();
        if (cardsValuesSum <= 21) {
            return cardsValuesSum;
        }
        var numberOfAces = cards.stream().filter(card -> card.getRank().equals(Rank.ACE)).count();
        for (int i = 0; i < numberOfAces; i++) {
            if (cardsValuesSum > 21) {
                cardsValuesSum += 1 - 11;
            }
        }
        return cardsValuesSum;
    }

    public void dealerEndDraw(CardDeck cardDeck){
        var cardsValueSum = getCardsValuesSum();
        while (cardsValueSum<17){
            this.cards.add(cardDeck.drawCard());
            System.out.println(" ");
            System.out.println("Card: " + this.getCards().getLast());
            cardsValueSum = this.getCardsValuesSum();
            System.out.println(getCards());
            System.out.println("Neuer Wert: "+cardsValueSum);
        }
    }

    public void detectWin(Player p,double playerBet){
        var cashierCardsSum = this.getCardsValuesSum();
        var playerCardsSum = p.getCardsValuesSum();
        double playerBalance = p.getBalance();
        double playerWinAmount = 0;
        System.out.println("");
        System.out.println(p.getName());

        if (playerCardsSum>cashierCardsSum && playerCardsSum<=21){
            System.out.println("You win!");
            playerWinAmount = playerBet*1.5;
            System.out.println("Payout: "+playerWinAmount);
        } else if (playerCardsSum<=21 && cashierCardsSum > 21) {
            System.out.println("cashier busted, you win!");
            playerWinAmount = playerBet*1.5;
            System.out.println("Payout: "+playerWinAmount);
        } else if (cashierCardsSum==playerCardsSum && playerCardsSum<=21) {
            System.out.println("Push");
            playerWinAmount = playerBet;
            System.out.println("Payout: "+playerWinAmount);
        } else if (p.checkIfBlackJack() && this.checkIfBlackJack()) {
            System.out.println("Push");
            playerWinAmount = playerBet;
        } else if (p.checkIfBlackJack()) {
            System.out.println("You had a Blackjack!");
            playerWinAmount=playerBet*2;
            System.out.println("Payout:"+playerWinAmount);
        } else if (this.checkIfBlackJack()) {
            System.out.println("Cashier has Blackjack, you loose");
            playerWinAmount = 0;

        } else if (playerCardsSum > 21) {
            System.out.println("You bust, you loose");
            playerWinAmount = 0;
            System.out.println("Payout: "+0);
        } else {
            System.out.println("Cashier wins!");
        }
        p.setBalance(playerBalance+playerWinAmount);
    }

    public boolean checkIfBlackJack(){
        var cardSum =this.getCardsValuesSum();

        if (cardSum==21){
            System.out.println("Blackjack");
            return true;
        }
        else {
            return false;
        }

    }

}
