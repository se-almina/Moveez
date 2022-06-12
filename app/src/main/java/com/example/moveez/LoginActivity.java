package com.example.moveez;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity {
    EditText email, password;
    public static final String USER_ID = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        email = findViewById(R.id.email_reg);
        password = findViewById(R.id.password_reg);
    }

    public void login(View view) {
        // first check if exists
        User user = MovieDatabase.getInstance(this).userDao().checkIfLoginLegit(email.getText().toString(), password.getText().toString());

        if (user == null) {
            Toast.makeText(this, "User doesn't exist or the entered password is not correct", Toast.LENGTH_SHORT).show();
        } else {

            Intent intent = new Intent(this, MainPage.class);
            intent.putExtra(USER_ID, user.getId());
            startActivity(intent);
            Log.d("error", " ");
        }
    }

    public void onRegister(View view) {
        Intent intent=new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}

