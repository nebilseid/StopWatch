package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

import javax.xml.datatype.Duration;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    TextView tvResult;
    long startTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnStart = findViewById(R.id.btn_start);
        final Button btnStop = findViewById(R.id.btn_stop);
        final Button btnReset = findViewById(R.id.btn_reset);
        final long time;
        final TextClock timer = findViewById(R.id.tc_counter);
        final TextView tvResult = findViewById(R.id.tv_duration);



        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnStart.setVisibility(View.GONE);
                btnStop.setVisibility(View.VISIBLE);
                startTime = System.currentTimeMillis();

            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnReset.setVisibility(View.VISIBLE);
                tvResult.setVisibility(View.VISIBLE);
                long stopTime = System.currentTimeMillis();
                long diff = startTime - stopTime;

                String duration = String.valueOf(stopTime - startTime);
                String result = getString(R.string.duration_result,duration);
                TextView tvResult = findViewById(R.id.tv_duration);
                tvResult.setText(result);
                btnStop.setVisibility(View.GONE);
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnStart.setVisibility(View.VISIBLE);
                btnStop.setVisibility(View.GONE);
                btnReset.setVisibility(View.INVISIBLE);
                tvResult.setVisibility(View.GONE);

            }
        });
    }

}
