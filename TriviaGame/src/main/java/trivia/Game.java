package trivia;

public class Game implements IGame {
    private final String POP_THEME = "Pop";
    private final String SCIENCE_THEME = "Science";
    private final String SPORTS_THEME = "Sports";
    private final String ROCK_THEME = "Rock";

    private final PlayerList players = new PlayerList();
    private final QuestionList questions = new QuestionList(new String[] {POP_THEME, SCIENCE_THEME, SPORTS_THEME, ROCK_THEME});

    public boolean addPlayer(String playerName) {
        players.addPlayer(playerName);
        return true;
    }

    public void roll(int roll) {

        players.playerTurn(roll);

        if (!players.isCurrentPlayerInJail()) {
            System.out.println("The category is " + questions.getCurrentCategory(players.getCurrentPlayerPlace()));
            askQuestion();
        }
    }

    private void askQuestion() {
        questions.askQuestion(players.getCurrentPlayerPlace());
    }

    public boolean handleCorrectAnswer() {
        return players.correctAnswer();
    }

    public boolean handleWrongAnswer() {
        return players.wrongAnswer();
    }
}
