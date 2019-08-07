import java.util.*;

public class BlackJack extends Game {

    public BlackJack(int decks, int players, ArrayList<String> names) {
        this.players = new ArrayList<Player>(players);
        for (int i = 0; i < players; i++) {
            this.players.add(new Player(names.get(i)));
        }
        dealer = new Dealer();
        deck = new GameDeck(decks);
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
            for (Player p : players) {
                dealer.deal(deck, p);
            }
            dealer.deal(deck, dealer);

            // ask each player for action until done
            turn:
            for (Player p : players) {
                int handValue = calculateHand(p);
                while (handValue < 21) {
                    System.out.println("You have: " + handValue + ".");
                    System.out.println("What would you like to do? H: hit, S: stand, X: split, R: surrender, D: double down");
                    String action = sc.nextLine();
                    action = action.toLowerCase();
                    switch (action) {
                        case "h":
                            dealer.deal(deck, p);
                            break;
                        case "s":
                            continue turn;
                        case "x":
                            // TODO: implement
                            break;
                        case "r":
                            // TODO: implement
                            break;
                        case "d":
                            // TODO: implement
                            break;
                        default:
                            System.out.println("Error: please choose a valid action.");
                            break;
                    }
                }
                handValue = calculateHand(p);
                if (handValue > 21) {
                    System.out.println("Dang! You went bust with a " + handValue + ".");
                }
            }
            // TODO: dealer turn (stand on soft 17)

            // TODO: deal out winnings
        }

    }
    // calculate the hand value
    private int calculateHand (Player p) {
        int handValue = 0;
        int numAces = 0;
        for (Card c : p.hand) {
            if (c.getRank().equals("Ace")) {
                numAces++;
            }
            handValue += cardValue(c);
        }
        // handle aces by switching their values to 1 until the total is below 21
        for (int i = 0; handValue > 21 && i < numAces; i++) {
            handValue -= 10;
        }
        return handValue;
    }

    private int cardValue(Card c) {
        HashMap<String, Integer> values = new HashMap<String, Integer>();
        values.put("Ace", 11);
        values.put("Two", 2);
        values.put("Three", 3);
        values.put("Four", 4);
        values.put("Five", 5);
        values.put("Six", 6);
        values.put("Seven", 7);
        values.put("Eight", 8);
        values.put("Nine", 9);
        values.put("Ten", 10);
        values.put("Jack", 10);
        values.put("Queen", 10);
        values.put("King", 10);
        return values.get(c.getRank());
    }
}
