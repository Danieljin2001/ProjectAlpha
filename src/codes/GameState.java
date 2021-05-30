package codes;

public abstract class GameState {
    Deck deck;

    GameState(Deck deck) {
        this.deck = deck;
    }

    public abstract Card hit() throws Exception;
    public abstract void stand();

}
