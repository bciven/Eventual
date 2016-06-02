package com.social.eventual;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;



/**
 * Created by user on 5/12/2016.
 */
public class FacebookLoginActivity extends AppCompatActivity {


    Button changeButton;
    LoginButton loginButton;
    CallbackManager callbackManager;
    FacebookLoginActivity thisActivity;


    // Sets the Facebook login.
    private void setupFacebookLogin() {

        // Create the callbackManager and add functionality to it.
        callbackManager = CallbackManager.Factory.create();
        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions("user_likes");

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                Intent intent = new Intent(getApplicationContext(),QuizActivity.class);

                SharedPreferences.Editor editor = getSharedPreferences("acc",MODE_PRIVATE).edit();
                editor.putString("token",loginResult.getAccessToken().getToken());
                editor.commit();
                Log.d("Token :: ",loginResult.getAccessToken().getToken());
                Log.d("access :: ",loginResult.getAccessToken().toString());
                Log.d("access1 :: ",AccessToken.getCurrentAccessToken().toString());
                startActivity(intent);
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException e) {

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        thisActivity = this;
        // Set the current layout to main.

        // Initialize Facebook SDK.
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_login);
        setupFacebookLogin();


    }

    @Nullable
    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);
    }

/*
    @Override
    protected void onResume() {
        super.onResume();
        AppEventsLogger.activateApp(this);
    }
    @Override
    public void onPause() {
        super.onPause();
        AppEventsLogger.deactivateApp(this);
    }*/

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }*/

  /*  @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onResume() {
        super.onResume();

        AccessToken.refreshCurrentAccessTokenAsync();

        if(isFacebookLoggedIn())
        {
            Log.d("Login Status ::::::"," Already Logged In");
            Intent intent = new Intent(getApplicationContext(),QuizActivity.class);

            startActivity(intent);
        }
    }

    public boolean isFacebookLoggedIn(){

        return AccessToken.getCurrentAccessToken() != null;
    }
}



