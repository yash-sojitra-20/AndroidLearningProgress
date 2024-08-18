package com.example.loginui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button loginbtn;
    EditText etuname;
    EditText etpassword;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        sharedPreferences = getSharedPreferences("LoginPrefs", MODE_PRIVATE);

        if (sharedPreferences.getBoolean("isLoggedIn", false)) {
            Intent maintohome = new Intent(MainActivity.this, Home.class);
            startActivity(maintohome);
            finish();
        }

        loginbtn = (Button) findViewById(R.id.loginbtn);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etuname = (EditText) findViewById(R.id.etuname);
                etpassword = (EditText) findViewById(R.id.etpassword);
                String uname = etuname.getText().toString();
                String pass = etpassword.getText().toString();
                if(!uname.equals("") && !pass.equals("")){
                    Toast.makeText(MainActivity.this, "you are Logined as "+uname, Toast.LENGTH_LONG).show();

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("isLoggedIn", true);
                    editor.apply();

                    Intent maintohome = new Intent(MainActivity.this, Home.class);
                    maintohome.putExtra("uname",uname);
                    etuname.setText("");
                    etpassword.setText("");
                    startActivity(maintohome);
                    finish();
                }else{
                    Toast.makeText(MainActivity.this, "Please enter UserName and Password", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}