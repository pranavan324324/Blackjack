package Blackjack;

import java.lang.reflect.Array;
import java.util.*;

public class Carddeck {

    private Map<CardSymbol, List<CardValue>> deckCards = new HashMap<>();
    public enum CardValue { ONE(0), TWO(1), THREE(2), FOUR(3), FIVE(4), SIX(5), SEVEN(6), EIGHT(7), NINE(8), TEN(9), JACK(10), QUEEN(11), KING(12), ACE(13)
    public final int value;
    CardValue(int value){
        this.value = value;
    }
    public CardValue getByInt(int requestedValue){
        return Arrays.stream(CardValue.values()).filter(card -> card.value == requestedValue).findFirst().get();
    }
    }
    public enum CardSymbol {
        SPADES(0), HEARTS(1), CLUBS(2), DIAMONDS(3);
        public final int value;
        CardSymbol(int value) {
            this.value = value;
        }
        public CardSymbol getByInt(int requestedValue) {
            return Arrays.stream(CardSymbol.values()).filter(card -> card.value == requestedValue).findFirst().get();
        }
    }

    public Carddeck(){
        createAllCardsShuffled();


    }


    public void createAllCardsShuffled() {
        List<CardValue> cardValues = new ArrayList<>();
        for (CardValue cardValue : CardValue.values()) {
            cardValues.add(cardValue);
        }

        for (CardSymbol cardSymbol : CardSymbol.values()) {
            deckCards.put(cardSymbol,cardValues);
        }
        shuffleCard();
    }

    public Map<CardSymbol, List<CardValue>> shuffleCard(){
        List<Card> shuffledCards = new ArrayList<>();
        deckCards.get(CardSymbol.)


    }


}
