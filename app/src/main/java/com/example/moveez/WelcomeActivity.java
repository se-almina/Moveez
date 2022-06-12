package com.example.moveez;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    private long id;
    public static long USER_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if(extras!=null) {
            id = extras.getLong(String.valueOf(LoginActivity.USER_ID));
            if (id == 0) {
                id = extras.getLong(String.valueOf(RegisterActivity.USER_ID));
            }
        }
    }


    public void onMain(View view) {
        Intent i=new Intent(this, MainPage.class);
        i.putExtra(String.valueOf(USER_ID), id);
        startActivity(i);
    }
}

