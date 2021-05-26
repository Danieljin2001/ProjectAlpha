package codes;

public class DealerState extends GameState{
    DealerState(Deck deck) {
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
