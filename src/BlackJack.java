import java.util.*;

public class BlackJack extends Game {

    public BlackJack(int decks, int players, ArrayList<String> names) {
        this.players = new ArrayList<Player>(players);
        for (int i = 0; i < players; i++) {
            this.players.add(new Player(names.get(i)));
        }
        dealer = new Dealer();
        deck = new GameDeck(decks);
        cardValues();
        discardPile = new Stack<Card>();
        runGame();
    }

    public static void main (String [] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("How many players?");
            BlackJack game;
            try {
                int players = Integer.parseInt(sc.nextLine());
                ArrayList<String> names = new ArrayList<String>();
                for (int i = 0; i < players; i++) {
                    System.out.println("Player " + i + " name: ");
                    names.add(sc.nextLine());
                }
                System.out.println("How many decks?");
                int decks = System.in.read();
                game = new BlackJack(decks, players, names);
                System.out.println("Create another game? Y/N");
                if (!sc.nextLine().toLowerCase().equals("y")) {
                    break;
                }
            } catch (Exception e) {

            }
        }
    }

    private void runGame() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            // place bets
            for (Player p : players) {
                System.out.println(p.name + " bet:");
                while (!p.bet((sc.nextInt()))) {
                    System.out.println("Error: cannot bet more than you have in your wallet. You have: " + p.wallet);
                    System.out.println(p.name + " bet:");
                }
            }
            // deal first round of cards
            players.forEach(p -> dealer.deal(deck, p));
            dealer.deal(deck, dealer);

            // ask each player for action until done
            for (Player p : players) {
                System.out.println();
            }
            // deal out winnings
        }

    }
    // calculate the hand value
    private int calculateHand (Player p) {
        Map<String, Integer> values = cardValues();
        int handValue = 0;
        for (Card c : p.hand) {
            handValue += values.get(c.getRank());
        }
        return handValue;
    }

    private Map<String, Integer> cardValues() {
        Map<String, Integer> values = new HashMap<String, Integer>();
        values.add("Ace", 11);
        values.add("Two", 2);
        values.add("Three", 3);
        values.add("Four", 4);
        values.add("Five", 5);
        values.add("Six", 6);
        values.add("Seven", 7);
        values.add("Eight", 8);
        values.add("Nine", 9);
        values.add("Ten", 10);
        values.add("Jack", 10);
        values.add("Queen", 10);
        values.add("King", 10);
        return values;
    }
}
