package trivia;

public class Player {
    private String name;
    private int place;
    private int coins;
    private boolean isInJail;

    public Player(String name) {
        this.name = name;
        this.place = 1;
        this.coins = 0;
        this.isInJail = false;
    }

    public void incrementPlace(int roll) {
        this.place += roll;
        if(this.place > 12) {
            this.place -= 12;
        }
    }

    public void setInJail(boolean inJail) {
        this.isInJail = inJail;
    }

    public void incrementCoins() {
        this.coins ++;
    }

    public String getName() {
        return name;
    }

    public int getPlace() {
        return place;
    }

    public int getCoins() {
        return coins;
    }

    public boolean isInJail() {
        return isInJail;
    }

    @Override
    public String toString() {
        return name;
    }
}
