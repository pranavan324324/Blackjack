package Blackjack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Player {
    private int playerBalance = 1500;
    private static double playerBet;
    private static int cardSummaryPlayer;
    private static Map<String,Integer> PlayerCards = new HashMap<>();

    public Player(int playerBalance){
        this.playerBalance=playerBalance;
    }

}
