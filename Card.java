import java.util.Objects;

public class Card {
    private final Suit suit;
    private final Rank rank;

    public Card(Rank rank, Suit suit) {
        this.rank = Objects.requireNonNull(rank);
        this.suit = Objects.requireNonNull(suit);
    }

    public Rank getRank() { return rank; }
    public Suit getSuit() { return suit; }

    @Override
    public String toString() { return rank + " of " + suit; }
}
