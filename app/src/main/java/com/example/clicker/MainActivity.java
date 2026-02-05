    package com.example.clicker;

    import android.content.Context;
    import android.content.Intent;
    import android.content.SharedPreferences;
    import android.os.Bundle;
    import android.util.Log;
    import android.view.View;
    import android.widget.Button;
    import android.widget.TextView;
    import android.widget.Toast;

    import androidx.appcompat.app.AppCompatActivity;

    import java.io.File;
    import java.io.FileWriter;
    import java.io.IOException;
    import java.io.PrintWriter;
    import java.util.Scanner;

    public class MainActivity extends AppCompatActivity {
        private static final String LOG_TAG = "ClickerMainActivity";
        private static final String PREF_NAME = "clicker_data";
        private static final String KEY_TOTAL = "total_clicks";

        private int clicksTotalAmount = 0;
        private int clicksTodayAmount = 0;

        private SharedPreferences prefs;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            Log.i(LOG_TAG, "Базовая настройка завершена");

            Button button = findViewById(R.id.button);
            TextView clicksTotal = findViewById(R.id.clicksTotal);
            TextView clicksToday = findViewById(R.id.clicksToday);

            prefs = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
            clicksTotalAmount = prefs.getInt(KEY_TOTAL, 0);
            clicksTotal.setText(Integer.toString(clicksTotalAmount));
            Log.i(LOG_TAG, "Загружено: total=" + clicksTotalAmount);


            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i(LOG_TAG, "Клик");
                    ++clicksTodayAmount;
                    ++clicksTotalAmount;

                    if (clicksTodayAmount == 67 && clicksTotalAmount % 67 == 0) {
                        Log.i(LOG_TAG, "Пользователь вошел в посхалку");
                        Toast.makeText(MainActivity.this, "Посхалачка", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(MainActivity.this, SixSeven.class);
                        startActivity(intent);
                    }

                    clicksTotal.setText(Integer.toString(clicksTotalAmount));
                    clicksToday.setText(Integer.toString(clicksTodayAmount));
                }
            });
        }

        @Override
        protected void onPause() {
            super.onPause();
            prefs.edit().putInt(KEY_TOTAL, clicksTotalAmount).apply();
            Log.i(LOG_TAG, "Сохранение результатов.");
        }
    }