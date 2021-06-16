package codes;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Game {
    private Deck deck;
    private Menu menu;
    private Dealer dealer;
    private ArrayList<Player> players;

    Game() throws Exception {
        this.menu = new Menu(); // initialize new Menu
        menu.welcome();
        this.deck = new Deck(menu.askDeckNumber());

        this.players = createPlayers();
        this.dealer = new Dealer(deck);
    }

    public void play() throws Exception {
        for (Player player: players) {
            // player.changeState(new StandbyState(deck));
        }
        // executePlayerTurns();
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

    private ArrayList<Player> createPlayers() {
        ArrayList<Player> players = new ArrayList<>();

        int numPlayers = menu.askTotalPlayer();
        for(int i = 0; i < numPlayers; i++) {
            System.out.print("\nPlayer" + (i+1) + " ");
            players.add(new HumanPlayer(deck, menu.askName(), menu.askMoney()));
        }

        return players;
    }

   //  public void executePlayerTurns() {
        // for (Player player: players) {
            // System.out.println(player.getNAME() + " is now playing");
            // player.changeState(new PlayingState(deck));
           //  if (player.isHUMAN()) {
            //     // player / user input logic
           //  } else {
           //      // AI logic
          //  }
            // player.hit();
            // player.changeState(new EndState(deck));
      //   }
    // }

    public boolean allPlayersAreDone() {
        for (Player player: players) {
           //  if (player.getState().getClass() != EndState.class) {
           //      return false;
           //  }
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
