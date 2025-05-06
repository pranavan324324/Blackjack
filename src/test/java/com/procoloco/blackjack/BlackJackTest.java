package com.procoloco.blackjack;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class BlackJackTest {

    @Test
    public void detectBlackJack(){
        var player = new Player(1,"Pranavan",5000,400);
        var cashier = new Cashier();

        var card1 = new Card(Suit.HEARTS,Rank.KING);
        var card2 = new Card(Suit.DIAMONDS,Rank.ACE);
        var playerCards = new ArrayList<>(Arrays.asList(card1, card2));
        player.setCards(playerCards);

        cashier.detectWin(player,5000);
    }
}
