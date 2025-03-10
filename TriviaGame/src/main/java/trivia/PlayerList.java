package trivia;

import java.util.ArrayList;

public class PlayerList {
    private final ArrayList<Player> players;
    private Player currentPlayer;

    public PlayerList() {
        players = new ArrayList<>();
    }

    public void addPlayer(String playerName) {
        Player newPlayer = new Player(playerName);
        players.add(newPlayer);
        if(currentPlayer == null) {
            currentPlayer = newPlayer;
        }
        System.out.println(playerName + " was added");
        System.out.println("They are player number " + players.size());
    }

    public void playerTurn(int roll) {
        System.out.println(currentPlayer + " is the current player");
        System.out.println("They have rolled a " + roll);

        if (currentPlayer.isInJail()) {
            setIsGettingOutOfPenaltyBox(roll);
            return;
        }
        movePlayer(roll);
    }

    private void setIsGettingOutOfPenaltyBox(int roll) {
        if (roll % 2 == 0) {
            currentPlayer.setInJail(true);
            System.out.println(currentPlayer + " is not getting out of the penalty box");
            return;
        }

        currentPlayer.setInJail(false);

        System.out.println(currentPlayer + " is getting out of the penalty box");
        movePlayer(roll);
    }

    private void movePlayer(int roll) {
        currentPlayer.incrementPlace(roll);

        System.out.println(currentPlayer
                + "'s new location is "
                + currentPlayer.getPlace());
    }

    public boolean isCurrentPlayerInJail() {
        return currentPlayer.isInJail();
    }

    public int getCurrentPlayerPlace() {
        return currentPlayer.getPlace();
    }

    public void nextPlayer() {
        currentPlayer = players.get((players.indexOf(currentPlayer) + 1) % players.size());
    }

    public boolean correctAnswer() {
        if(currentPlayer.isInJail()) {
            nextPlayer();
            return true;
        }

        System.out.println("Answer was correct!!!!");
        currentPlayer.incrementCoins();
        System.out.println(currentPlayer
                + " now has "
                + currentPlayer.getCoins()
                + " Gold Coins.");

        boolean winner = (currentPlayer.getCoins() != 6);
        nextPlayer();

        return winner;
    }

    public boolean wrongAnswer() {
        System.out.println("Question was incorrectly answered");
        System.out.println(currentPlayer + " was sent to the penalty box");
        currentPlayer.setInJail(true);

        nextPlayer();
        return true;
    }
}
