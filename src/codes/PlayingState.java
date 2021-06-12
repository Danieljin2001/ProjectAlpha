package codes;

public class PlayingState extends GameState{
    PlayingState(Deck deck) {
        super(deck);
    }

    @Override
    public Card hit() {
        Card hitCard = deck.drawCard();
        //System.out.println(hitCard.toString());
        return hitCard;
    }

    @Override
    public void stand() {

    }
}
