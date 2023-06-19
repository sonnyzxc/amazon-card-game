import java.util.Objects;

public class Card {
  private final Suit suit;
  private final Rank rank;

  public Card(Suit suit, Rank rank) {
    this.suit = suit;
    this.rank = rank;
  }

  public int getPoints() {
    return rank.getPoints();
  }

  @Override
  public String toString() {
    return this.rank.toString() + " " + this.suit.toString();
  }

  @Override
  public boolean equals(Object other) {
    if (other instanceof Card card) {
      return card.suit == this.suit && card.rank == this.rank;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(suit, rank);
  }
}
