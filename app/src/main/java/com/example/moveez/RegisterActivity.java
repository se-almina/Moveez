package com.example.moveez;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    EditText username, email, password;
    public static final String USER_ID = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        username = (EditText) findViewById(R.id.username_reg);
        email = (EditText) findViewById(R.id.email_reg);
        password = (EditText) findViewById(R.id.password_reg);

    }

    public void welcome(View view) {
        User newUser = new User(username.getText().toString(),
                email.getText().toString(),
                password.getText().toString());
        String user = email.getText().toString();
        User tempUser = MovieDatabase.getInstance(this).userDao().getUserByEmail(user);



        if(tempUser == null) {

            MovieDatabase.getInstance(this).userDao().addUser(newUser);
            Intent intent = new Intent(this, WelcomeActivity.class);
            long new_id = MovieDatabase.getInstance(this).userDao().getUserIDByEmail(newUser.getEmail());
            intent.putExtra(USER_ID, new_id);
            if(intent.resolveActivity(getPackageManager()) == null)
                Log.i("error", "No home activity");
            else startActivity(intent); Log.i("register","successfully registered");
        }else{
            Toast.makeText(this, "Email is already taken", Toast.LENGTH_SHORT).show();
        }
    }

    public void onLogin(View view) {
        Intent intent=new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}

