package codes;

public class PlayingState extends GameState{
    PlayingState(Deck deck) {
        super(deck);
    }

    @Override
    public Card hit() {
        return null;
    }

    @Override
    public void stand() {

    }
}
