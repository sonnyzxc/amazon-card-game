import java.util.ArrayList;
import java.util.List;

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

  private static int checkWinner(List<List<Card>> playerCards) {
    for (int i = 0; i < playerCards.size(); i++) {
      int sum = 0;
      for (int j = 0; j < playerCards.get(i).size(); j++) {
        sum += playerCards.get(i).get(j).getPoints();
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

    for (int i = 0; i < playerCount; i++) {
      playerCards.add(new ArrayList<>());
    }

    // initialise player cards
    for (int i = 0; i < playerCount; i++) {
      for (int j = 0; j < INITIAL_NUMBER_OF_CARDS; j++) {
        playerCards.get(i).add(deck.draw());
      }
    }

    while (!deck.cards.isEmpty()  && checkWinner(playerCards) == -1) {
      for (int i = 0; i < playerCount; i++) {
        Card newCard = deck.draw();
        playerCards.get(i).add(newCard);
      }
    }

    // TODO(): display what cards the winner(s) had
    int winner = checkWinner(playerCards);
    System.out.println(deck.cards.isEmpty() || winner == -1 ? "There is a draw!" : "Player " + (winner + 1)
        + " has won!");
  }
}
