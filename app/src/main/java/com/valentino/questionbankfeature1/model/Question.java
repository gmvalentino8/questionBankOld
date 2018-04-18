package com.valentino.questionbankfeature1.model;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by mac on 2/27/18.
 */

public class Question implements Serializable {
    private String creator;
    private String question;
    private ArrayList<Answer> answers = new ArrayList<>();
    private Answer correctAnswer;
    private ArrayList<Integer> rating = new ArrayList<>();

    public Question() {
        creator = "Marco Valentino";
        question = "Why is ESPY590 the best class at UIUC?";

        ArrayList<String> rationale1 = new ArrayList<String>();
        rationale1.add("He makes a 3 hour class fly by so fast");
        rationale1.add("He always tells interesting yet relevant stories");
        answers.add(new Answer("Chad is the best professor in the world", rationale1));
        ArrayList<String> rationale2 = new ArrayList<String>();
        rationale2.add("AppInventor is so cool to use");
        rationale2.add("Even though I'm not a CS major, I'm so happy that I can make a mobile app!");
        answers.add(new Answer("You learn how to make cool mobile apps", rationale2));
        ArrayList<String> rationale3 = new ArrayList<String>();
        rationale3.add("We played JackBox games as a classs... it was awesome!");
        rationale3.add("We tried different 'educational' apps and discuss the pros and cons of them as a group");
        answers.add(new Answer("You play games in class and discuss them afterwards", rationale3));
        ArrayList<String> rationale4 = new ArrayList<String>();
        rationale4.add("Isn't it obvious?");
        rationale4.add("I can't eliminate any of the above... so it has to be this");
        answers.add(new Answer("All of the above", rationale4));

        correctAnswer = answers.get(3);
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }

    public Answer getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(Answer correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public ArrayList<Integer> getRating() {
        return rating;
    }

    public void setRating(ArrayList<Integer> rating) {
        this.rating = rating;
    }

}
