package com.example.clicker;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private int clicksTotalAmount = 0;
    private int clicksTodayAmount = 0;
    private static final String LOG_TAG = "ClickerMainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(LOG_TAG, "Базовая настройка завершена");

        Button button = findViewById(R.id.button);
        TextView clicksTotal = findViewById(R.id.clicksTotal);
        TextView clicksToday = findViewById(R.id.clicksToday);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(LOG_TAG, "Клик");
                ++clicksTodayAmount;
                ++clicksTotalAmount;

                clicksTotal.setText(Integer.toString(clicksTodayAmount));
                clicksToday.setText(Integer.toString(clicksTodayAmount));
            }
        });
    }
}