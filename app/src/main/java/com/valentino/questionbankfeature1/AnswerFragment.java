package com.valentino.questionbankfeature1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Rational;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.valentino.questionbankfeature1.model.Answer;
import com.valentino.questionbankfeature1.model.Question;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;

public class AnswerFragment extends Fragment implements View.OnClickListener {
    private static final String QUESTION_PARAM = "Question";
    private static final String SELECTED_ANSWER_PARAM = "SelectedAnswer";
    private static final String ALT_ANSWER_PARAM = "AlternativeAnswer";
    private static final String RATIONALE_PARAM = "Question";

    private Question question;
    private Answer selectedAnswer;
    private ArrayList<String> selectedRationales;
    private Answer alternativeAnswer;
    private ArrayList<String> alternativeRationales;
    private String writtenRationale;

    public AnswerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            question = (Question) getArguments().getSerializable(QUESTION_PARAM);
            selectedAnswer = (Answer) getArguments().getSerializable(SELECTED_ANSWER_PARAM);
            selectedRationales = selectedAnswer.getRationales();
            Collections.shuffle(selectedRationales);
            alternativeAnswer = (Answer) getArguments().getSerializable(ALT_ANSWER_PARAM);
            alternativeRationales = alternativeAnswer.getRationales();
            Collections.shuffle(alternativeRationales);
            writtenRationale = getArguments().getString(RATIONALE_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_answer, container, false);
        TextView questionText = root.findViewById(R.id.questionTextView);
        questionText.setText(question.getQuestion());
        // Selected Answer
        TextView selectedAnswerText = root.findViewById(R.id.selectAnswerTextView);
        selectedAnswerText.setText(selectedAnswer.getAnswer());
        selectedAnswerText.setOnClickListener(this);
        // Selected Rationale 1
        TextView selectedRational1Text = root.findViewById(R.id.selectAnswerRationale1);
        selectedRational1Text.setText(selectedRationales.get(0));
        // Selected Rationale 2
        TextView selectedRational2Text = root.findViewById(R.id.selectAnswerRationale2);
        selectedRational2Text.setText(selectedRationales.get(1));
        // Alternative Answer
        TextView alternativeAnswerText = root.findViewById(R.id.alternativeAnswerTextView);
        alternativeAnswerText.setText(alternativeAnswer.getAnswer());
        alternativeAnswerText.setOnClickListener(this);
        // Alternative Rationale 1
        TextView alternativeRational1Text = root.findViewById(R.id.alternativeAnswerRationale1);
        alternativeRational1Text.setText(alternativeRationales.get(0));
        // Alternative Rationale 2
        TextView alternativeRational2Text = root.findViewById(R.id.alternativeAnswerRationale2);
        alternativeRational2Text.setText(alternativeRationales.get(1));

        return root;
    }

    @Override
    public void onClick(View view) {
        Answer revisedAnswer = null;
        switch (view.getId()) {
            case R.id.selectAnswerTextView:
                revisedAnswer = selectedAnswer;
                break;
            case R.id.alternativeAnswerTextView:
                revisedAnswer = alternativeAnswer;
                break;
        }
        Bundle args = getArguments();
        args.putSerializable("RevisedAnswer", revisedAnswer);

        RatingFragment ratingFragment = new RatingFragment();
        ratingFragment.setArguments(args);
        getFragmentManager().beginTransaction()
                .replace(R.id.content_view, ratingFragment)
                .commit();
    }
}
