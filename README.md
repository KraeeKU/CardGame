# CardGame — Higher or Lower

A Java terminal game where you see a playing card and predict whether the next card will be **higher** or **lower**.

## Requirements

Java JDK 8 or later. No third-party dependencies.

## Run

From the repository root:

```bash
javac -d out src/*.java
java -cp out GameLogic
```

On Windows, run the same commands in PowerShell (create the `out` directory first if needed).

## Rules

- A standard 52-card deck is shuffled at the start of each game.
- You see the first card, then choose `h` for higher or `l` for lower.
- Ace is lowest (1), King is highest (13); suits do not affect rank.
- Correct guesses earn a point and increase your streak. Incorrect guesses reset the streak, but your total points remain.
- Equal ranks are ties: no point and no streak change.
- Enter `q` to end a game early. When the deck runs out, the game ends automatically.
- At the end, you can start a fresh game.

## Source files

- `Card.java`: immutable card model
- `Rank.java`, `Suit.java`: enums
- `Deck.java`: shuffled deck and card drawing
- `CardCollection.java`: deck interface
- `Player.java`: player model reserved for future modes
- `GameLogic.java`: terminal gameplay and scorekeeping

## Planned improvements

Java Swing GUI, saved high scores, automated unit tests, and probability calculations using the remaining cards.

## Project history

This version completes the original unfinished Java card project with a playable Higher or Lower terminal game.
