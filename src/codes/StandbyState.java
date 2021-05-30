package codes;

public class StandbyState extends GameState{
    StandbyState(Deck deck) {
        super(deck);
    }

    @Override
    public Card hit() throws Exception{
        throw new Exception("Your turn hasn't begun yet!");
    }

    @Override
    public void stand() {

    }
}
