package com.procoloco.blackjack;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CashierTest {

     @Test
     public void getCardsValuesSum_worksAsExpected() {
        var card1 = new Card(Suit.CLUBS, Rank.FIVE);
        var card2 = new Card(Suit.DIAMONDS, Rank.TEN);
        var cashierCards = new ArrayList<>(Arrays.asList(card1, card2));

         Cashier cashier = new Cashier();
         cashier.setCards(cashierCards);

         var actualResult = cashier.getCardsValuesSum();

         assertEquals(15, actualResult);
     }

    @Test
    public void getCardsValuesSum_worksAsExpectedForAces() {
        var card1 = new Card(Suit.CLUBS, Rank.ACE);
        var card2 = new Card(Suit.DIAMONDS, Rank.ACE);
        var card3 = new Card(Suit.HEARTS, Rank.ACE);
        var card4 = new Card(Suit.SPADES, Rank.ACE);
        var cashierCards = new ArrayList<>(Arrays.asList(card1, card2, card3, card4));

        Cashier cashier = new Cashier();
        cashier.setCards(cashierCards);

        assertEquals(14, cashier.getCardsValuesSum());
    }
}
