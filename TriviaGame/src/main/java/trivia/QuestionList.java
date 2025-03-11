package trivia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QuestionList {
    private final HashMap<String, ArrayList<Question>> questions;
    private final ArrayList<String> themes;

    public QuestionList(String[] themes, int num) {
        questions = new HashMap<>();
        this.themes = new ArrayList<>(List.of(themes));
        for(String theme : themes) {
            questions.put(theme, new ArrayList<>());
            generateQuestions(theme, num);
        }
    }

    public QuestionList(String[] themes) {
        questions = new HashMap<>();
        this.themes = new ArrayList<>(List.of(themes));
        for(String theme : themes) {
            questions.put(theme, new ArrayList<>());
            generateQuestions(theme, 50);
        }
    }

    private void generateQuestions(String theme, int num) {
        for (int i = 0; i < num; i++) {
            questions.get(theme).addLast(createQuestion(theme, i));
        }
    }

    private Question createQuestion(String theme, int index) {
        return new Question(theme + " Question " + index);
    }

    public void askQuestion(int place) {
        System.out.println(questions.get(getCurrentCategory(place)).removeFirst());
    }

    public String getCurrentCategory(int place) {
        return themes.get((place-1) % questions.size());
    }
}
