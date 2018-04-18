package com.valentino.questionbankfeature1.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by mac on 2/27/18.
 */

public class Answer implements Serializable {
    private String answer;
    private ArrayList<String> rationales = new ArrayList<>();

    public Answer(String answer, ArrayList<String> rationales) {
        this.answer = answer;
        this.rationales = rationales;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public ArrayList<String> getRationales() {
        return rationales;
    }

    public void setRationales(ArrayList<String> rationales) {
        this.rationales = rationales;
    }


}
