package com.example.utindergui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;


public class activity_after_login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);

        final Button backToLogin = findViewById(R.id.button);
        backToLogin.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                Intent back_to_login_intent = new Intent(activity_after_login.this, MainActivity.class);
                startActivity(back_to_login_intent);
                finish();
            }
        });
    }
}