package com.procoloco.blackjack;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
    @Test
    public void getCardsValuesSum_worksAsExpected() {
        var card1 = new Card(Suit.CLUBS, Rank.FIVE);
        var card2 = new Card(Suit.DIAMONDS, Rank.TEN);
        var playerCards = new ArrayList<>(Arrays.asList(card1, card2));

        Player player = new Player(1,"Pranavan",1500,500);
        player.setCards(playerCards);

        assertEquals(15, player.getCardsValuesSum());
    }
}
