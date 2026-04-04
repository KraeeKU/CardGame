import java.util.Scanner;

public class GameLogic {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Deck deck = new Deck();

        System.out.print("Enter your name: ");
        Player player = new Player(input.nextLine());

        System.out.println("Choose a mode:");
        System.out.println("1. Streak Mode");
        System.out.println("2. Score Mode");
        System.out.print("Enter 1 or 2: ");
        int mode = input.nextInt();

        Card current = deck.drawCard();
        System.out.println("Starting card: " + current);

        boolean playing = true;

        while (playing) {
            System.out.print("Higher or Lower? (h/l): ");
            char guess = input.next().toLowerCase().charAt(0);

            Card next = deck.drawCard();
            System.out.println("Next card: " + next);

            boolean correct = (guess == 'h' && next.getValue() > current.getValue()) ||
                              (guess == 'l' && next.getValue() < current.getValue());

            if (correct) {
                System.out.println("Correct!");

                if (mode == 1) {
                    player.increaseStreak();
                    System.out.println("Streak: " + player.getStreak());
                } else {
                    player.increaseScore();
                    System.out.println("Score: " + player.getScore());
                }

                current = next;
            } else {
                System.out.println("Wrong!");
                playing = false;
            }
        }

        System.out.println("\nGame Over!");

        if (mode == 1) {
            System.out.println("Final streak: " + player.getStreak());
        } else {
            System.out.println("Final score: " + player.getScore());
        }

        input.close();
    }
}

