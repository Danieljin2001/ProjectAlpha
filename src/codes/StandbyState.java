package codes;

public class StandbyState extends GameState{
    StandbyState(Deck deck) {
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
