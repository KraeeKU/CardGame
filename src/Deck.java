import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

public class Deck implements CardCollection {
    private final List<Card> cards = new ArrayList<>();

    public Deck() { this(new Random()); }

    public Deck(Random random) {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) cards.add(new Card(rank, suit));
        }
        Collections.shuffle(cards, random);
    }

    public Card draw() {
        if (isEmpty()) throw new NoSuchElementException("The deck is empty");
        return cards.remove(cards.size() - 1);
    }

    @Override public String deckPeak() {
        return isEmpty() ? "Deck is empty" : cards.get(cards.size() - 1).toString();
    }
    @Override public boolean isEmpty() { return cards.isEmpty(); }
    @Override public Integer noCards() { return cards.size(); }
}
