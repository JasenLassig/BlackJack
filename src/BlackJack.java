import java.util.ArrayList;
import java.util.Stack;

public class BlackJack extends Game {

    public BlackJack(int decks, int players) {
        this.players = new ArrayList<Player>(players);
        for (int i = 0; i < players; i++) {
            this.players.add(new Player());
        }
        dealer = new Dealer();
        deck = new GameDeck(decks);
        discardPile = new Stack<Card>();
    }

    public static void main (String [] args) {
        System.out.println("How many players?");
        BlackJack game;
        try {
            int players = System.in.read();
            System.out.println("How many decks?");
            int decks = System.in.read();
            game = new BlackJack(decks, players);
        } catch (Exception e) {

        }
        while (true) {

        }
    }
}
