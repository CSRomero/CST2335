package com.example.csromero.androidlabs;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    protected static final String ACTIVITY_NAME = "Login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.i(ACTIVITY_NAME, "In onCreate()");

        final EditText emailEdit = (EditText) findViewById(R.id.emailEditText);
        Button loginButton = (Button) findViewById(R.id.loginButton);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        loginButton.setOnClickListener(new View.OnClickListener() {
            // perform action on click
            public void onClick(View v) {
                // opens the shared preferences and writes the email edit's text value
                SharedPreferences sharedPrefs = getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor prefsEditor = sharedPrefs.edit();
                prefsEditor.putString(getString(R.string.emailPreference), emailEdit.getText().toString());
                prefsEditor.commit();
                // open startActivity with intent
                Intent intent = new Intent(LoginActivity.this, StartActivity.class);
                startActivity(intent);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    };

    protected void onResume(){
        super.onResume();
        Log.i(ACTIVITY_NAME, "In onResume()");
    };

    protected void onStart(){
        super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart()");
        // get the last stored email in the shared preferences and update the email edit text
        SharedPreferences sharedPrefs = getPreferences(Context.MODE_PRIVATE);
        String email = sharedPrefs.getString(getString(R.string.emailPreference), "email@domain.com");
        EditText emailEdit = (EditText) findViewById(R.id.emailEditText);
        emailEdit.setText(email);
    };

    protected void onPause(){
        super.onPause();
        Log.i(ACTIVITY_NAME, "In onPause()");
    };

    protected void onStop(){
        super.onStop();
        Log.i(ACTIVITY_NAME, "In onStop()");
    };

    protected void onDestroy(){
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "In onDestroy()");
    };
}
