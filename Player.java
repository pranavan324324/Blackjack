package Blackjack;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Player {
    private int position;
    private String name;
    private int balance;
    private List<Card> cards = new ArrayList<>();

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Player(int position, String name, int balance) {
        this.position = position;
        this.name = name;
        this.balance = balance;
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

    public void playPlayer(CardDeck cardDeck) {
        Scanner userInput = new Scanner(System.in);

        int drawOrPass;
        var cardSum = this.getCardsValuesSum();
        System.out.println(this.getName()+", deine Karten: " + this.getCards() + " dein Wert: " + this.getCardsValuesSum());
            do {
                System.out.println("Möchtest du eine weitere Karte ziehen oder passen?\n1 - weitere Karte ziehen\n2 - passen");
                drawOrPass = userInput.nextInt();

                if (drawOrPass == 1){
                    var playerCards = this.getCards();
                    playerCards.add(cardDeck.drawCard());
                    System.out.println("");
                    System.out.println("Card: "+this.getCards().getLast());
                    cardSum= this.getCardsValuesSum();
                    System.out.println("Cards: "+getCards());
                    System.out.println("Neuer Wert: "+cardSum);
                    System.out.println("");

                } else if (drawOrPass == 2) {
                    System.out.println("pass");
                    break;
                }
                else {
                    System.out.println("Input invalid!");
                }

                if (cardSum>21){
                    System.out.println(this.getName()+ ", You are busted, you have: "+cardSum);
                    System.out.println(" ");
                    break;
                }

            }while(drawOrPass==1);





    }




}


