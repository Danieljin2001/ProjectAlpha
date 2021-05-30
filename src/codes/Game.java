package codes;

import javafx.scene.SnapshotParameters;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Game {
    private Deck deck;
    private Menu menu;
    private Dealer dealer;
    private ArrayList<Player> players;

    Game() throws Exception {
        this.menu = new Menu(); // initialize new Menu
        menu.askName();
        menu.askPlayerNumber();
        menu.askMoney();
        menu.askDeckNumber();
        this.deck = new Deck(menu.getDECK_NUMBER());
        this.players = createPlayers(deck, menu.getMONEY(), menu.getNAME());
        this.dealer = new Dealer();
    }

    public void play() throws Exception {
        for (Player player: players) {
            player.changeState(new StandbyState(deck));
        }
        executePlayerTurns();
        if (allPlayersAreDone()) {
            System.out.println("Dealers turn");
            // dealer logic
            determineWinners();
        } else {
            throw new Exception("Error: Not all players have finished their turn");
        }
        deck.getUsedDeckInfo();
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    private ArrayList<Player> createPlayers(Deck deck, int startMoney, String name) {
        ArrayList<Player> players = new ArrayList<>();

        players.add(new HumanPlayer(deck, startMoney, name));
        for (int x = 1; x < menu.getPLAYER_NUMBER(); x++) {
            players.add(new HumanPlayer(deck, startMoney, "AI" + x));
        }

        return players;
    }

    public void executePlayerTurns() {
        for (Player player: players) {
            System.out.println(player.getNAME() + " is now playing");
            player.changeState(new PlayingState(deck));
            if (player.isHUMAN()) {
                // player / user input logic
            } else {
                // AI logic
            }
            player.hit();
            player.changeState(new EndState(deck));
        }
    }

    public boolean allPlayersAreDone() {
        for (Player player: players) {
            if (player.getState().getClass() != EndState.class) {
                return false;
            }
        }
        return true;
    }

    public void determineWinners() {

    }

    public Deck getDeck() {
        return deck;
    }

    public Menu getMenu() {
        return menu;
    }

    public Dealer getDealer() {
        return dealer;
    }

}
