package com.example.loginui;

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
                    etuname.setText("");
                    etpassword.setText("");
                }else{
                    Toast.makeText(MainActivity.this, "Please enter UserName and Password", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}