package trivia;

import java.util.ArrayList;
import java.util.LinkedList;

// REFACTOR ME
public class Game implements IGame {
    private final String POP_THEME = "Pop";
    private final String SCIENCE_THEME = "Science";
    private final String SPORTS_THEME = "Sports";
    private final String ROCK_THEME = "Rock";
    ArrayList<String> players = new ArrayList<>();
    int[] places = new int[6];
    int[] purses = new int[6];
    boolean[] inPenaltyBox = new boolean[6];
    LinkedList<String> popQuestions = new LinkedList<>();
    LinkedList<String> scienceQuestions = new LinkedList<>();
    LinkedList<String> sportsQuestions = new LinkedList<>();
    LinkedList<String> rockQuestions = new LinkedList<>();
    int currentPlayer = 0;
    boolean isGettingOutOfPenaltyBox;

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

    public boolean isPlayable() {
        return (howManyPlayers() >= 2);
    }

    public boolean addPlayer(String playerName) {
        places[howManyPlayers()] = 1;
        purses[howManyPlayers()] = 0;
        inPenaltyBox[howManyPlayers()] = false;
        players.add(playerName);

        System.out.println(playerName + " was added");
        System.out.println("They are player number " + players.size());
        return true;
    }

    public int howManyPlayers() {
        return players.size();
    }

    public void roll(int roll) {
        System.out.println(players.get(currentPlayer) + " is the current player");
        System.out.println("They have rolled a " + roll);

        if (inPenaltyBox[currentPlayer]) {
            setIsGettingOutOfPenaltyBox(roll);

            if (!isGettingOutOfPenaltyBox) {
                return;
            }
        } else {
            movePlayer(roll);
        }

        System.out.println(players.get(currentPlayer)
                + "'s new location is "
                + places[currentPlayer]);

        System.out.println("The category is " + currentCategory());
        askQuestion();
    }

    private void movePlayer(int roll) {
        places[currentPlayer] += roll;
        if (places[currentPlayer] > 12) places[currentPlayer] = places[currentPlayer] - 12;
    }

    private void setIsGettingOutOfPenaltyBox(int roll) {
        if (roll % 2 == 0) {
            System.out.println(players.get(currentPlayer) + " is not getting out of the penalty box");
            isGettingOutOfPenaltyBox = false;
            return;
        }

        isGettingOutOfPenaltyBox = true;

        System.out.println(players.get(currentPlayer) + " is getting out of the penalty box");
        places[currentPlayer] = places[currentPlayer] + roll;
        if (places[currentPlayer] > 12) places[currentPlayer] = places[currentPlayer] - 12;
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
        return switch ((places[currentPlayer] - 1) % 4) {
            case 0 -> POP_THEME;
            case 1 -> SCIENCE_THEME;
            case 2 -> SPORTS_THEME;
            default -> ROCK_THEME;
        };
    }

    public boolean handleCorrectAnswer() {

        if (!isGettingOutOfPenaltyBox && inPenaltyBox[currentPlayer]) {
            currentPlayer++;
            if (currentPlayer == players.size()) currentPlayer = 0;
            return true;
        }

        System.out.println("Answer was correct!!!!");
        purses[currentPlayer]++;
        System.out.println(players.get(currentPlayer)
                + " now has "
                + purses[currentPlayer]
                + " Gold Coins.");

        boolean winner = didPlayerWin();
        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;

        return winner;

    }

    public boolean handleWrongAnswer() {
        System.out.println("Question was incorrectly answered");
        System.out.println(players.get(currentPlayer) + " was sent to the penalty box");
        inPenaltyBox[currentPlayer] = true;

        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;
        return true;
    }

    private boolean didPlayerWin() {
        return !(purses[currentPlayer] == 6);
    }
}
