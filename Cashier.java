package Blackjack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cashier {
    private List<Card> cards = new ArrayList<>();

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Cashier() {}

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
}
