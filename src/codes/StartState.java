package codes;

public class StartState extends GameState{
    StartState(Deck deck) {
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
