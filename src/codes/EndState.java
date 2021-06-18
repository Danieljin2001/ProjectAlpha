package codes;

public class EndState extends GameState{
    EndState(Deck deck) {
        super(deck);
    }

    @Override
    public Card hit() throws Exception {
        throw new Exception("Your turn is over!");
    }

    @Override
    public void stand() {

    }
}
