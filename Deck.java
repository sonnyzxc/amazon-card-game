import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.Random;

public class Deck {
  public static final int DECK_SIZE = 52;
  private static final List<Card> cardList = Arrays.asList(
      new Card(Suit.CLUBS, Rank.ACE), new Card(Suit.DIAMONDS, Rank.ACE),
      new Card(Suit.HEARTS, Rank.ACE), new Card(Suit.SPADES, Rank.ACE),
      new Card(Suit.CLUBS, Rank.TWO), new Card(Suit.DIAMONDS, Rank.TWO),
      new Card(Suit.HEARTS, Rank.TWO), new Card(Suit.SPADES, Rank.TWO),
      new Card(Suit.CLUBS, Rank.THREE), new Card(Suit.DIAMONDS, Rank.THREE),
      new Card(Suit.HEARTS, Rank.THREE), new Card(Suit.SPADES, Rank.THREE),
      new Card(Suit.CLUBS, Rank.FOUR), new Card(Suit.DIAMONDS, Rank.FOUR),
      new Card(Suit.HEARTS, Rank.FOUR), new Card(Suit.SPADES, Rank.FOUR),
      new Card(Suit.CLUBS, Rank.FIVE), new Card(Suit.DIAMONDS, Rank.FIVE),
      new Card(Suit.HEARTS, Rank.FIVE), new Card(Suit.SPADES, Rank.FIVE),
      new Card(Suit.CLUBS, Rank.SIX), new Card(Suit.DIAMONDS, Rank.SIX),
      new Card(Suit.HEARTS, Rank.SIX), new Card(Suit.SPADES, Rank.SIX),
      new Card(Suit.CLUBS, Rank.SEVEN), new Card(Suit.DIAMONDS, Rank.SEVEN),
      new Card(Suit.HEARTS, Rank.SEVEN), new Card(Suit.SPADES, Rank.SEVEN),
      new Card(Suit.CLUBS, Rank.EIGHT), new Card(Suit.DIAMONDS, Rank.EIGHT),
      new Card(Suit.HEARTS, Rank.EIGHT), new Card(Suit.SPADES, Rank.EIGHT),
      new Card(Suit.CLUBS, Rank.NINE), new Card(Suit.DIAMONDS, Rank.NINE),
      new Card(Suit.HEARTS, Rank.NINE), new Card(Suit.SPADES, Rank.NINE),
      new Card(Suit.CLUBS, Rank.TEN), new Card(Suit.DIAMONDS, Rank.TEN),
      new Card(Suit.HEARTS, Rank.TEN), new Card(Suit.SPADES, Rank.TEN),
      new Card(Suit.CLUBS, Rank.JACK), new Card(Suit.DIAMONDS, Rank.JACK),
      new Card(Suit.HEARTS, Rank.JACK), new Card(Suit.SPADES, Rank.JACK),
      new Card(Suit.CLUBS, Rank.QUEEN), new Card(Suit.DIAMONDS, Rank.QUEEN),
      new Card(Suit.HEARTS, Rank.QUEEN), new Card(Suit.SPADES, Rank.QUEEN),
      new Card(Suit.CLUBS, Rank.KING), new Card(Suit.DIAMONDS, Rank.KING),
      new Card(Suit.HEARTS, Rank.KING), new Card(Suit.SPADES, Rank.KING)
  );
  Stack<Card> cards;

  public Deck() {
    cards = new Stack<>();
  }

  public static Stack<Card> createShuffledDeck() {
    Stack<Card> returnDeck = new Stack<>();

    Random rand = new Random();
    for (int i = 0; i < DECK_SIZE; i++) {
      int index = rand.nextInt(DECK_SIZE - 1 - i);
      Card card = cardList.get(index);
      cardList.remove(index);

      System.out.println(cardList.size());
      returnDeck.push(card);
    }

    return returnDeck;
  }

  public Card draw() {
    return cards.pop();
  }
}

