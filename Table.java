import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Table {

    public static void main(String[] args) {

        System.out.println("Mit wie vielen Spielern möchtest du spielen?");
        Scanner userInput = new Scanner(System.in);
        int numbersOfPlayer = userInput.nextInt();

        List<Player> players = new ArrayList<>();

        for (int i = 1; numbersOfPlayer >= i; i++){
            System.out.println("Wie heisst du Spieler " + i + "?");
            String playerName = userInput.next();
            System.out.println(playerName + " mit wie viel Geld möchtest du spielen?");
            int playerBalance = userInput.nextInt();
            players.add(new Player(i, playerName, playerBalance));
        }
    }
}