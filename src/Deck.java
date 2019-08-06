import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Deck {
    Stack<Card> cards;

    public enum Suit {
        Hearts, Clubs, Spaces, Diamonds
    }
    public enum Rank {
        Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King
    }

    public Deck() {
        cards = new Stack<Card>();
        for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                cards.add(new Card(s, r));
            }
        }
    }

    public void empty() {
        cards = new Stack<Card>();
    }

    public void Shuffle() {
        Collections.shuffle(cards);
    }

    public boolean add(Card c) {
        return cards.add(c);
    }

    public Card draw() {
        if (cards.size() > 0) {
            return cards.pop();
        } else {
            throw new NotImplementedException();
        }
    }
}
