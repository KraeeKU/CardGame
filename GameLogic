import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;
    private int index = 0;

    public Deck() {
        cards = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
        int[] values = {2,3,4,5,6,7,8,9,10,11,12,13,14};

        for (String suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                cards.add(new Card(suit, ranks[i], values[i]));
            }
        }

        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(cards);
        index = 0;
    }

    public Card drawCard() {
        if (index >= cards.size()) {
            shuffle();
        }
        return cards.get(index++);
    }
}

