package com.procoloco.blackjack;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
    @Test
        var card1 = new Card(Suit.CLUBS, Rank.FIVE);
        var card2 = new Card(Suit.DIAMONDS, Rank.TEN);
        var playerCards = new ArrayList<>(Arrays.asList(card1, card2));
        player.setCards(playerCards);

    }
}
