package codes;

public class EndState extends GameState{
    EndState(Deck deck) {
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
