package com.example.cropwatch;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the login button
        Button loginButton = findViewById(R.id.button);

        // Set an OnClickListener to handle the button click
        loginButton.setOnClickListener(v -> {
            // Create an Intent to start the HomePage activity
            Intent intent = new Intent(MainActivity.this, HomePage.class);
            startActivity(intent);  // Navigate to HomePage
        });
    }
}