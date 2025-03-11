package trivia;

public class Question {
    private final String question;

    public Question(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return question;
    }
}
