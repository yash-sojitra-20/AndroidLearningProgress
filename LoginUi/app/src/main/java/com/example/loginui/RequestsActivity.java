package com.example.loginui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.LinearLayout;

public class RequestsActivity extends AppCompatActivity {

    private LinearLayout maintenanceRequest, foodRequest, leaveRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requests);

        // Initialize UI elements
        maintenanceRequest = findViewById(R.id.maintenanceRequest);
        foodRequest = findViewById(R.id.foodRequest);
        leaveRequest = findViewById(R.id.leaveRequest);

        // Set click listeners
        maintenanceRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement maintenance request functionality here
            }
        });

        foodRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement food request functionality here
            }
        });

        leaveRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement leave request functionality here
            }
        });
    }
}
