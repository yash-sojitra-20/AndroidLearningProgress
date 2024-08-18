package com.example.loginui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {

    Button logoutbtn;
    TextView tvwelcometxt;
    SharedPreferences sharedPreferences;
    private static final String PREFS_NAME = "LoginPrefs"; // Name for SharedPreferences

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        logoutbtn = findViewById(R.id.logoutbtn);
        tvwelcometxt = findViewById(R.id.tvwelcometxt);

        // Get the username from the intent
        Intent intent = getIntent();
        String uname = intent.getStringExtra("uname");

        // Set the welcome message with the username
        tvwelcometxt.setText("Welcome " + uname);

        // Set the logout button functionality
        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Home.this, "You are logged out", Toast.LENGTH_SHORT).show();

                // Clear the login status and username in SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("loggedIn", false);
                editor.putString("username", null);
                editor.apply(); // Apply the changes

                // Redirect to MainActivity
                Intent hometomain = new Intent(Home.this, MainActivity.class);
                hometomain.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(hometomain);
                finish();
            }
        });
    }
}
