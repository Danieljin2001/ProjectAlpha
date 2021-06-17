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
//        for (Player player: players) {
//            // player.changeState(new StandbyState(deck));
//        }
//        // executePlayerTurns();
//        if (allPlayersAreDone()) {
//            System.out.println("Dealers turn");
//            // dealer logic
//            determineWinners();
//        } else {
//            throw new Exception("Error: Not all players have finished their turn");
//        }
//        deck.getUsedDeckInfo();
        boolean cont = true;
        //asking if fold or no
        //if they do play: setup the hands, ask for initial bet
        while (cont) {
            setupNewRound();
            Test.playRound(players, dealer, menu);
            checkResetDeck();
            if(menu.askQuit()) {
                cont = false;
            }
        }
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

    private void setupNewRound() throws Exception {
        for (Player player: players) {
            player.changeState(new StandbyState(deck));
        }
        dealer.setup();
        for(Player player : players) {
            player.playOrNo(menu.askPlay(player));
            if(player.getPlay()) {
                player.setup();
                player.initialBet(menu.askInitialBet(player));
            }
        }
        //dealing out the cards
        //player first cards
        for(Player player : players) {
            if(player.getPlay()) {
                player.drawCard();
            }
        }
        //dealer first card
        System.out.println("\nDealer first drew: "+dealer.drawCard());
        //player second cards
        for(Player player : players) {
            if(player.getPlay()) {
                player.drawCard();
            }
        }
        //dealer second card
        System.out.println("Dealer Second card is hidden.\n");
        dealer.drawCard();
    }

    private void checkResetDeck() {
        if(deck.getPercentageOfUsed() > 50) {
            System.out.println("More than 50% of the deck was used.\nReshuffling deck...\n");
            deck.resetDeck();
        }
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
