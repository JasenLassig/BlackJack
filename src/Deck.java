import java.util.ArrayList;

public class Deck {
    ArrayList<Card> cards;

    public enum Suit {
        Hearts, Clubs, Spaces, Diamonds
    }
    public enum Rank {
        Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King
    }

    public Deck() {
        cards = new ArrayList<Card>(52);
        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                cards.add(new Card(s, r));
            }
        }
    }
}
