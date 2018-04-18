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

import com.valentino.questionbankfeature1.model.Answer;
import com.valentino.questionbankfeature1.model.Question;

import java.util.ArrayList;

public class RatingFragment extends Fragment implements View.OnClickListener {
    RatingBar ratingBar1;
    RatingBar ratingBar2;
    RatingBar ratingBar3;
    RatingBar ratingBar4;
    Button submitButton;

    public RatingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_rating, container, false);

        ratingBar1 = root.findViewById(R.id.Rating1Bar);
        ratingBar2 = root.findViewById(R.id.Rating2Bar);
        ratingBar3 = root.findViewById(R.id.Rating3Bar);
        ratingBar4 = root.findViewById(R.id.Rating4Bar);
        submitButton = root.findViewById(R.id.SubmitRatingButton);
        submitButton.setOnClickListener(this);

        return root;
    }


    @Override
    public void onClick(View view) {
        Bundle args = getArguments();
        switch (view.getId()) {
            case R.id.SubmitRatingButton:
                args.putInt("Rating 1", (int) ratingBar1.getRating());
                args.putInt("Rating 2", (int) ratingBar2.getRating());
                args.putInt("Rating 3", (int) ratingBar3.getRating());
                args.putInt("Rating 4", (int) ratingBar4.getRating());
                SummaryFragment summaryFragment = new SummaryFragment();
                summaryFragment.setArguments(args);
                getFragmentManager().beginTransaction()
                        .replace(R.id.content_view, summaryFragment)
                        .commit();
                break;
        }
    }
}
