import java.util.ArrayList;

public class Game {
    ArrayList<Player> players;
    Dealer dealer;

    public Game() {
        players = new ArrayList<Player>();
        dealer = new Dealer();
    }
}
