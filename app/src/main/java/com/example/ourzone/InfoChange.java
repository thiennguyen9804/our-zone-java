package com.example.ourzone;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InfoChange extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_info_change);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnChangeTheme = findViewById(R.id.btnChangeTheme);
        btnChangeTheme.setOnClickListener(v -> {
            Intent intent = new Intent(this, ChangeTheme.class);
            startActivity(intent);
        });

        Button btnEditName = findViewById(R.id.btnEditName);
        btnEditName.setOnClickListener(v -> {
            Intent intent = new Intent(this, EditName.class);
            startActivity(intent);
        });

        Button btnChangePhoneNumber = findViewById(R.id.btnChangePhoneNumber);
        btnChangePhoneNumber.setOnClickListener(v -> {
            Intent intent = new Intent(this, ChangePhoneNumber.class);
            startActivity(intent);
        });

        Button btnChangeEmail = findViewById(R.id.btnChangeEmail);
        btnChangeEmail.setOnClickListener(v -> {
            Intent intent = new Intent(this, ChangeEmail.class);
            startActivity(intent);
        });

        Button btnChangePassword = findViewById(R.id.btnChangePassword);
        btnChangePassword.setOnClickListener(v -> {
            Intent intent = new Intent(this, ChangePassword.class);
            startActivity(intent);
        });

        Button btnReport = findViewById(R.id.btnReport);
        btnReport.setOnClickListener(v -> {
            Intent intent = new Intent(this, Report.class);
            startActivity(intent);
        });

        ImageView btnBack = findViewById(R.id.imgBack);
        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        });
    }
}