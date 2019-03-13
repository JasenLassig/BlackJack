import java.util.ArrayList;
import java.util.Stack;

public class Game {
    ArrayList<Player> players;
    Dealer dealer;
    GameDeck deck;
    Stack<Card> discardPile;

    public Game() {
        players = new ArrayList<Player>();
        dealer = new Dealer();
        deck = new GameDeck(1);
        discardPile = new Stack<Card>();
    }
}
