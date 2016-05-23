package com.social.eventual;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by SetarehN on 1/13/2016.
 */
public class VolleyClass {

    private Context context;

    private String accessToken;
    private String page;


        public VolleyClass(Context context,String accessToken,String page) {

            this.context = context;
            this.accessToken = accessToken;
            this.page = page;
    }


// Login //  send UserName + Password
    // receive all data related to user
    //1 firstname , lastname , linkedIn , email , point, skills
    //2 list of my problems and response in format of private seeing(msg)
    //3 list of otherz problemz depending on my skills!





    public void volleyRun() {

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(context);
        String url = "127.0.0.1:8080/EventualServer/"+this.page+"/"+this.accessToken;

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        //   mTextView.setText("Response is: " + response.substring(0, 500));
                        JSONObject jso;
                        Toast.makeText(context,"connected to server.....",Toast.LENGTH_LONG);
                        JSONArray ja = null;
                        try {
                            ja = new JSONArray(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        try {
                            jso = ja.getJSONObject(0);
                            Log.d(" response ", jso.getString("response"));
                            Toast.makeText(context,jso.getString("response"),Toast.LENGTH_LONG);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //   mTextView.setText("That didn't work!");
            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest);


    }




















}
