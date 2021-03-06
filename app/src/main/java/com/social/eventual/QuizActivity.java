package com.social.eventual;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInstaller;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;


import com.facebook.AccessToken;
import com.facebook.login.LoginManager;

import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    ListView QuestionsList;
    Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        this.activity = this;

        Button logoutbtn = (Button) findViewById(R.id.logoutbtn);
        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logOut();
                Intent login = new Intent(v.getContext(), FacebookLoginActivity.class); /** Class name here */
                startActivityForResult(login, 0);
                Log.d(" logout :::: ", "successful");
            }
        });
      //  InitQuestions();


        new LoadList().execute();
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


    private class LoadList extends AsyncTask<Void,Void,List<Event>>
    {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

           /* //this method will be running on UI thread
            pdLoading.setMessage("\tLoading...");
            pdLoading.show();*/
        }
        @Override
        protected List<Event> doInBackground(Void... params) {

     // test


            SharedPreferences shr = getSharedPreferences("acc",MODE_PRIVATE);



           Log.d("AccessTokennnnn::", shr.getString("token",null)+"ss");
           VolleyClass volleyClass = new VolleyClass(getApplicationContext(), shr.getString("token",null),"3");
            volleyClass.volleyRun();

            Event event1 = new Event();
            Event event2 = new Event();

            event1.setLocation("Shiraz");
            event1.setTitle("Jamavarie Zobale");

            event2.setLocation("China");
            event2.setTitle(".......!!!");

            List<Event> eventsArr = new ArrayList<>();
            eventsArr.add(event1);
            eventsArr.add(event2);

            return eventsArr;
        }

        @Override
        protected void onPostExecute(List<Event> eventsArr) {
            super.onPostExecute(eventsArr);

            //this method will be running on UI thread

            //pdLoading.dismiss();

            EventsListViewAdapter eventsListView = new EventsListViewAdapter(activity,eventsArr);
            ListView listView = (ListView) findViewById(R.id.lstview);
            listView.setAdapter(eventsListView);


        }

    }
    }






