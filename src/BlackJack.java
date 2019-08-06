import java.util.ArrayList;
import java.util.Stack;
import java.util.Scanner;

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
        while (true) {
            // place bets
            // deal first round of cards
            players.forEach(p -> dealer.deal(deck, p));
            dealer.deal(deck, dealer);

            // ask each player for action until done
            // deal out winnings
        }
    }
}
