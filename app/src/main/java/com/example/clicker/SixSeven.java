package com.example.clicker;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SixSeven extends AppCompatActivity {
    private static final String LOG_TAG = "ClickerSixSeven";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixseven);
        Log.i(LOG_TAG, "Пользователь открыл пасхалку");

        Button button = findViewById(R.id.buttonBack);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(LOG_TAG, "Пользователь вышел из посхалки");
                Toast.makeText(SixSeven.this, "Пока посхалка", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}