package trivia;

import java.util.ArrayList;
import java.util.LinkedList;

// REFACTOR ME
public class Game implements IGame {
    private final String POP_THEME = "Pop";
    private final String SCIENCE_THEME = "Science";
    private final String SPORTS_THEME = "Sports";
    private final String ROCK_THEME = "Rock";
    private final PlayerList players = new PlayerList();
    LinkedList<String> popQuestions = new LinkedList<>();
    LinkedList<String> scienceQuestions = new LinkedList<>();
    LinkedList<String> sportsQuestions = new LinkedList<>();
    LinkedList<String> rockQuestions = new LinkedList<>();

    public Game() {
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast(createPopQuestion(i));
            scienceQuestions.addLast(createScienceQuestion(i));
            sportsQuestions.addLast(createSportsQuestion(i));
            rockQuestions.addLast(createRockQuestion(i));
        }
    }

    public String createPopQuestion(int index) {
        return POP_THEME + " Question " + index;
    }

    public String createScienceQuestion(int index) {
        return SCIENCE_THEME + " Question " + index;
    }

    public String createSportsQuestion(int index) {
        return SPORTS_THEME + " Question " + index;
    }

    public String createRockQuestion(int index) {
        return ROCK_THEME + " Question " + index;
    }

    public boolean addPlayer(String playerName) {
        players.addPlayer(playerName);
        return true;
    }

    public void roll(int roll) {

        players.playerTurn(roll);

        if (!players.isCurrentPlayerInJail()) {
            System.out.println("The category is " + currentCategory());
            askQuestion();
        }
    }

    private void askQuestion() {
        switch (currentCategory()) {
            case POP_THEME -> System.out.println(popQuestions.removeFirst());
            case SCIENCE_THEME -> System.out.println(scienceQuestions.removeFirst());
            case SPORTS_THEME -> System.out.println(sportsQuestions.removeFirst());
            case ROCK_THEME -> System.out.println(rockQuestions.removeFirst());
            default -> throw new IllegalArgumentException("Catégorie inconnue : " + currentCategory());
        }
    }

    private String currentCategory() {
        return switch ((players.getCurrentPlayerPlace() - 1) % 4) {
            case 0 -> POP_THEME;
            case 1 -> SCIENCE_THEME;
            case 2 -> SPORTS_THEME;
            default -> ROCK_THEME;
        };
    }

    public boolean handleCorrectAnswer() {
        return players.correctAnswer();
    }

    public boolean handleWrongAnswer() {
        return players.wrongAnswer();
    }
}
