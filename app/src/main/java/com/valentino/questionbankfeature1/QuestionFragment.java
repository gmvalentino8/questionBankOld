package com.valentino.questionbankfeature1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.valentino.questionbankfeature1.model.Answer;
import com.valentino.questionbankfeature1.model.Question;

import java.util.Random;

public class QuestionFragment extends Fragment implements View.OnClickListener {

    Question question;
    Answer answerA;
    Answer answerB;
    Answer answerC;
    Answer answerD;
    Answer selectedAnswer = null;

    TextView questionText;
    TextView answerAText;
    TextView answerBText;
    TextView answerCText;
    TextView answerDText;
    Button submitButton;
    EditText rationaleText;

    public QuestionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        question = new Question();
        answerA = question.getAnswers().get(0);
        answerB = question.getAnswers().get(1);
        answerC = question.getAnswers().get(2);
        answerD = question.getAnswers().get(3);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_question, container, false);
        questionText = root.findViewById(R.id.questionTextView);
        questionText.setText(question.getQuestion());

        answerAText = root.findViewById(R.id.answerATextView);
        answerAText.setText("A: " + answerA.getAnswer());
        answerAText.setOnClickListener(this);

        answerBText = root.findViewById(R.id.answerBTextView);
        answerBText.setText("B: " + answerB.getAnswer());
        answerBText.setOnClickListener(this);

        answerCText = root.findViewById(R.id.answerCTextView);
        answerCText.setText("C: " + answerC.getAnswer());
        answerCText.setOnClickListener(this);

        answerDText = root.findViewById(R.id.answerDTextView);
        answerDText.setText("D: " + answerD.getAnswer());
        answerDText.setOnClickListener(this);

        submitButton = root.findViewById(R.id.submitButton);
        submitButton.setOnClickListener(this);
        rationaleText = root.findViewById(R.id.rationaleEditText);

        return root;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Bundle args = new Bundle();
        switch(id) {
            case R.id.answerATextView:
                deselectAnswers();
                answerAText.setBackgroundResource(R.drawable.answer_select_textview_shape);
                selectedAnswer = answerA;
                break;
            case R.id.answerBTextView:
                deselectAnswers();
                answerBText.setBackgroundResource(R.drawable.answer_select_textview_shape);
                selectedAnswer = answerB;
                break;
            case R.id.answerCTextView:
                deselectAnswers();
                answerCText.setBackgroundResource(R.drawable.answer_select_textview_shape);
                selectedAnswer = answerC;
                break;
            case R.id.answerDTextView:
                deselectAnswers();
                answerDText.setBackgroundResource(R.drawable.answer_select_textview_shape);
                selectedAnswer = answerD;
                break;
            case R.id.submitButton:
                if (selectedAnswer == null || rationaleText.getText() == null) {
                    break;
                }
                Answer alternativeAnswer = null;
                if (selectedAnswer != question.getCorrectAnswer()) {
                    alternativeAnswer = question.getCorrectAnswer();
                }
                else {
                    while (alternativeAnswer == null) {
                        Answer randomAnswer = question.getAnswers().get((int) (Math.random() * 4));
                        if (randomAnswer != selectedAnswer) {
                            alternativeAnswer = randomAnswer;
                        }

                    }
                }
                args.putSerializable("Question", question);
                args.putSerializable("SelectedAnswer", selectedAnswer);
                args.putString("Rationale", rationaleText.getText().toString());
                args.putSerializable("AlternativeAnswer", alternativeAnswer);
                AnswerFragment answerFragment = new AnswerFragment();
                answerFragment.setArguments(args);
                getFragmentManager().beginTransaction()
                        .replace(R.id.content_view, answerFragment)
                        .commit();
                break;
            default:
                Log.d("SelectedAnswer", "Error");
                selectedAnswer = question.getCorrectAnswer();
        }
    }

    public void deselectAnswers() {
        answerAText.setBackgroundResource(R.drawable.answer_textview_shape);
        answerBText.setBackgroundResource(R.drawable.answer_textview_shape);
        answerCText.setBackgroundResource(R.drawable.answer_textview_shape);
        answerDText.setBackgroundResource(R.drawable.answer_textview_shape);
    }
}
