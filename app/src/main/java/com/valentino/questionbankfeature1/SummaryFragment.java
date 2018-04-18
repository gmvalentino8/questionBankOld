package com.valentino.questionbankfeature1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.valentino.questionbankfeature1.model.Answer;
import com.valentino.questionbankfeature1.model.Question;

public class SummaryFragment extends Fragment {
    private static final String QUESTION_PARAM = "Question";
    private static final String SELECTED_ANSWER_PARAM = "SelectedAnswer";
    private static final String REVISED_ANSWER_PARAM = "RevisedAnswer";
    private static final String RATIONALE_PARAM = "Rationale";
    private static final String RATING1_PARAM = "Rating 1";
    private static final String RATING2_PARAM = "Rating 2";
    private static final String RATING3_PARAM = "Rating 3";
    private static final String RATING4_PARAM = "Rating 4";


    private Question question;
    private Answer selectedAnswer;
    private Answer revisedAnswer;
    private String writtenRationale;
    private int rating1;
    private int rating2;
    private int rating3;
    private int rating4;

    RatingBar ratingBar1;
    RatingBar ratingBar2;
    RatingBar ratingBar3;
    RatingBar ratingBar4;

    public SummaryFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (getArguments() != null) {
            question = (Question) args.getSerializable(QUESTION_PARAM);
            selectedAnswer = (Answer) args.getSerializable(SELECTED_ANSWER_PARAM);
            revisedAnswer = (Answer) args.getSerializable(REVISED_ANSWER_PARAM);
            writtenRationale = args.getString(RATIONALE_PARAM);
            rating1 = args.getInt(RATING1_PARAM);
            rating2 = args.getInt(RATING2_PARAM);
            rating3 = args.getInt(RATING3_PARAM);
            rating4 = args.getInt(RATING4_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_summary, container, false);

        TextView questionText = root.findViewById(R.id.summaryQuestionTextView);
        questionText.setText(question.getQuestion());

        TextView selectedAnswerText = root.findViewById(R.id.summarySelectedAnswerText);
        selectedAnswerText.setText(selectedAnswer.getAnswer());

        TextView rationaleText = root.findViewById(R.id.summaryWrittenRationale);
        rationaleText.setText(writtenRationale);

        TextView revisedAnswerText = root.findViewById(R.id.summaryRevisedAnswerText);
        revisedAnswerText.setText(revisedAnswer.getAnswer());

        TextView correctAnswerText = root.findViewById(R.id.summaryCorrectAnswerText);
        correctAnswerText.setText(question.getCorrectAnswer().getAnswer());

        ratingBar1 = root.findViewById(R.id.summaryRating1Bar);
        ratingBar1.setRating(rating1);
        ratingBar2 = root.findViewById(R.id.summaryRating2Bar);
        ratingBar2.setRating(rating2);
        ratingBar3 = root.findViewById(R.id.summaryRating3Bar);
        ratingBar3.setRating(rating3);
        ratingBar4 = root.findViewById(R.id.summaryRating4Bar);
        ratingBar4.setRating(rating4);

        return root;
    }

}
