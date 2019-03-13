import java.util.ArrayList;

public class Hand {
    ArrayList<Card> cards;

    public Hand() {
        cards  = new ArrayList<Card>();
    }

    public boolean remove(Card c) {
        return cards.remove(c);
    }

    public boolean add(Card c) {
        return cards.add(c);
    }
}
