import java.util.ArrayList;

public class Game {
    ArrayList<Player> players;
    Dealer dealer;
    ArrayList<Deck> decks;

    public Game() {
        players = new ArrayList<Player>();
        dealer = new Dealer();
        decks = new ArrayList<Deck>();
    }
}
