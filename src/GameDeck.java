import java.util.Stack;

public class GameDeck extends Deck {
    Stack<Card> cards;

    public GameDeck(int n) {
        for (int i = 0; i < n; i++) {
            for (Suit s : Suit.values()) {
                for (Rank r : Rank.values()) {
                    cards.add(new Card(s, r));
                }
            }
        }
    }
}
