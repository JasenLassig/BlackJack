import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

public class Hand implements Iterable<Card> {
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

    @Override
    public Iterator<Card> iterator() {
        return cards.iterator();
    }
}
