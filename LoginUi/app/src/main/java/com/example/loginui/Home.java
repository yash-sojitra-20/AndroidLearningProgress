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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sharedPreferences = getSharedPreferences("LoginPrefs", MODE_PRIVATE);

        logoutbtn = (Button) findViewById(R.id.logoutbtn);
        Intent tvwelcometxtintent = getIntent();
        String uname = tvwelcometxtintent.getStringExtra("uname");
        tvwelcometxt = (TextView) findViewById(R.id.tvwelcometxt);
        tvwelcometxt.setText("welcome "+uname);
        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Home.this,"you are Logout",Toast.LENGTH_SHORT).show();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("isLoggedIn", false);
                editor.apply();

                Intent hometomain = new Intent(Home.this, MainActivity.class);
                startActivity(hometomain);
                finish();
            }
        });
    }
}