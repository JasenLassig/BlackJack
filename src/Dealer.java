public class Dealer extends Player{

    public Dealer() {
        super();
    }

    public void deal(Deck d, Player p) {
        p.hand.add(d.draw());
    }
}
