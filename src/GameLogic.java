import java.util.Scanner;

/** Guess whether the next card will be higher or lower than the visible card. */
public class GameLogic {
    public static int compareCards(Card first, Card second) {
        return Integer.compare(first.getRank().getValue(), second.getRank().getValue());
    }

    public static boolean correctGuess(Card current, Card next, String guess) {
        int comparison = compareCards(next, current);
        return (comparison > 0 && guess.equals("h")) || (comparison < 0 && guess.equals("l"));
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean again = true;
            System.out.println("HIGHER OR LOWER — Ace low, King high");
            while (again) {
                Deck deck = new Deck();
                Card current = deck.draw();
                int score = 0;
                int bestStreak = 0;
                int streak = 0;
                System.out.println("Starting card: " + current);
                while (!deck.isEmpty()) {
                    System.out.print("Next card: (h)igher, (l)ower, or (q)uit? ");
                    if (!scanner.hasNextLine()) return;
                    String guess = scanner.nextLine().trim().toLowerCase();
                    if (guess.equals("q")) break;
                    if (!guess.equals("h") && !guess.equals("l")) {
                        System.out.println("Please enter h, l or q.");
                        continue;
                    }
                    Card next = deck.draw();
                    int comparison = compareCards(next, current);
                    System.out.println("Next card was: " + next);
                    if (comparison == 0) {
                        System.out.println("Tie! No points lost or gained.");
                    } else if (correctGuess(current, next, guess)) {
                        score++;
                        streak++;
                        bestStreak = Math.max(bestStreak, streak);
                        System.out.println("Correct!");
                    } else {
                        streak = 0;
                        System.out.println("Incorrect. Streak reset.");
                    }
                    current = next;
                    System.out.println("Score: " + score + " | Streak: " + streak + " | Best streak: " + bestStreak + " | Cards left: " + deck.noCards());
                }
                System.out.println("Game over. Final score: " + score + ", best streak: " + bestStreak);
                System.out.print("Play again? (y/n): ");
                again = scanner.hasNextLine() && scanner.nextLine().trim().equalsIgnoreCase("y");
            }
            System.out.println("Thanks for playing!");
        }
    }
}
