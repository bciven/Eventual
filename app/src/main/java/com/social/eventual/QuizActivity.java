package com.social.eventual;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class QuizActivity extends AppCompatActivity {

    ListView QuestionsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        InitQuestions();
    }

    private void InitQuestions() {
        /*Questions = getResources().getStringArray(R.string.);

        String[] FromList = new String[] {"text1", "text2"};
        int[] ToList = new int[] {R.id.text1, R.id.text2};

        for (int i = 0; i < Locations.length; i++)
        {
            HashMap<String, String> M = new HashMap<String, String>();
            M.put("text1", Locations[i]);
            M.put("text2", "Row " + Integer.toString(i + 1));
            LocationAndTypeList.add(M);
        }

        QuestionsList = (ListView)findViewById(R.id.listViewQuestions);
        SimpleAdapter LocationListAdapter = new SimpleAdapter(this, LocationAndTypeList, R.layout.twolinelistitemrow, FromList, ToList);*/
    }
}
