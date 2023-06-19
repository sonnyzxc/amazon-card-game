import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {
  private static final int INITIAL_NUMBER_OF_CARDS = 3;

  private static boolean is_prime(int n) {
    if (n < 2) {
      return false;
    }

    if (n == 2) {
      return true;
    }

    for (int i = 3; i < (int)Math.sqrt(n); i += 2) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  private static int checkWinner(Card[][] playerCards) {
    for (int i = 0; i < playerCards.length; i++) {
      int sum = 0;
      for (int j = 0; i < playerCards[i].length; j++) {
        sum += playerCards[i][j].getPoints();
      }

      if (is_prime(sum)) {
        return i;
      }
    }
    return -1;
  }

  // PRE: user inputs number of players through argument of main
  public static void main(String[] args) {

    int playerCount = Integer.parseInt(args[0]);
    assert(playerCount >= 2 && playerCount <= 8);

    Deck deck = new Deck();
    deck.cards = Deck.createShuffledDeck();

    List<List<Card>> playerCards = new ArrayList<>();

    // initialise player cards
    for (int i = 0; i < playerCount; i++) {
      for (int j = 0; j < INITIAL_NUMBER_OF_CARDS; j++) {
        playerCards.get(i).add(deck.draw());
      }
    }

    /*
    while (drawnCards.size() != Deck.DECK_SIZE && checkWinner(playerCards) == -1) {
      for (int i = 0; i < playerCount; i++) {
        // PRE: assume this function works
        Card newCard = drawCard();
      }
    }

    // TODO(): display what cards the winner had
    return drawnCards.size() == 52 ? "Draw!" : "Player " + checkWinner " has won!";
     */
  }
}
