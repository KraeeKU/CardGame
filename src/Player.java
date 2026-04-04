public class Player {
    private String name;
    private int score = 0;
    private int streak = 0;

    public Player(String name) {
        this.name = name;
    }

    public void increaseScore() {
        score++;
    }

    public void increaseStreak() {
        streak++;
    }

    public void resetStreak() {
        streak = 0;
    }

    public int getScore() {
        return score;
    }

    public int getStreak() {
        return streak;
    }

    public String getName() {
        return name;
    }
}

