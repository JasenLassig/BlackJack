import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Player {
    Hand hand;
    Double wallet;

    public Player() {
        hand = new Hand();
        wallet = 0.0;
    }

    public double bet(double bet) {
        if (bet > wallet) {
            throw new NotImplementedException();
        } else {
            return wallet -= bet;
        }
    }

    public double won(double winnings) {
        return wallet += winnings;
    }

    public Card play(Card c) {
        if (hand.remove(c)) {
            return c;
        } else {
            throw new NotImplementedException();
        }
    }
}
