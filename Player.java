import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {
    private int position;
    private String name;
    private int balance;
    private List<Card> cards;


    public Player(int position, String name, int balance) {
        this.position = position;
        this.name = name;
        this.balance = balance;
    }

}
