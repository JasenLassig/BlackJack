public class Card {
    private Deck.Suit suit;
    private Deck.Rank rank;

    public Card(Deck.Suit s, Deck.Rank r) {
        suit = s;
        rank = r;
    }

    public String getRank() {
        return rank.toString();
    }

    public String getSuit() {
        return suit.toString();
    }

    public String toString() {
        return rank + " of " + suit;
    }
}