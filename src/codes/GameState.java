package codes;

public abstract class GameState {
    Deck deck;

    GameState(Deck deck) {
        this.deck = deck;
    }

    public abstract Card hit();
    public abstract void stand();

}
