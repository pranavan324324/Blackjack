package com.procoloco.blackjack;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {

    @Test
    public void play_worksAsExpected() {
        var mockUserInputScanner = Mockito.mock(Scanner.class);
        var mockedCardDeck = Mockito.mock(CardDeck.class);
        var player = new Player(1, "TestPlayer", 1000, 100, mockUserInputScanner);

        var card1 = new Card(Suit.CLUBS, Rank.FIVE);
        var card2 = new Card(Suit.DIAMONDS, Rank.TEN);
        var playerCards = new ArrayList<>(Arrays.asList(card1, card2));
        player.setCards(playerCards);

        Mockito.when(mockUserInputScanner.nextInt()).thenReturn(1).thenReturn(2);
        Mockito.when(mockedCardDeck.drawCard()).thenReturn(new Card(Suit.HEARTS, Rank.SIX));

        player.play(mockedCardDeck);

        assertEquals(21, player.getCardsValuesSum());
    }
}
