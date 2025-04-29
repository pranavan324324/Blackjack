package com.procoloco.blackjack;

import java.util.*;

public class Player {
    private int position;
    private String name;
    private double balance;
    private List<Card> cards = new ArrayList<>();
    private double playerBet;
    private Scanner userInputScanner;

    public double getPlayerBet() {
        return playerBet;
    }

    public void setPlayerBet(int playerBet) {
        this.playerBet = playerBet;
    }

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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public Player(int position, String name, int balance, int bet) {
        this.position = position;
        this.name = name;
        this.balance = balance;
        this.playerBet = bet;
        this.userInputScanner = new Scanner(System.in);
    }

    public Player(int position, String name, int balance, int bet, Scanner userInputScanner) {
        this.position = position;
        this.name = name;
        this.balance = balance;
        this.playerBet = bet;
        this.userInputScanner = userInputScanner;
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

    public void play(CardDeck cardDeck) {
        int drawOrPass;
        var cardSum = this.getCardsValuesSum();
        System.out.println(this.getName()+", deine Karten: " + this.getCards() + " dein Wert: " + this.getCardsValuesSum());
        do {
            System.out.println("Möchtest du eine weitere Karte ziehen oder passen?\n1 - weitere Karte ziehen\n2 - passen");
            drawOrPass = userInputScanner.nextInt();

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
                System.out.println("");
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

    public void getPlayerBets(){
        System.out.println("Dein Guthaben: "+ this.getBalance());

        Scanner userInput = new Scanner(System.in);
        System.out.println("Wie viel möchtest du einsetzen "+this.getName()+"?");
        this.setPlayerBet(userInput.nextInt());

        checkPlayerBetToHigh();

    }

    public void checkPlayerBetToHigh(){
        var playerBet = this.getPlayerBet();
        var playerBalance = this.getBalance();
        if(playerBet>playerBalance){
            System.out.println("Balance to low try again...\n");
            Scanner userInput = new Scanner(System.in);
            System.out.println("Wie viel möchtest du einsetzen "+this.getName()+"?");
            this.setPlayerBet(userInput.nextInt());
            playerBet = this.getPlayerBet();
            System.out.println();
            System.out.println(this.getName()+" hat "+ playerBet+" gesetzt");
            this.setBalance(this.getBalance()-playerBet);
            System.out.println("Restliches Guthaben: "+this.getBalance());
            System.out.println("");
        }else {
            playerBet = this.getPlayerBet();


            System.out.println();
            System.out.println(this.getName()+" hat "+ playerBet+" gesetzt");
            this.setBalance(this.getBalance()-playerBet);
            System.out.println("Restliches Guthaben: "+this.getBalance());
            System.out.println("");
        }

    }





}

