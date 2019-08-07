public class Dealer extends Player{

    public Dealer() {
        super("Dealer");
    }

    public Card deal(Deck d, Player p) {
        Card temp = d.draw();
        p.hand.add(temp);
        return temp;
    }


}
