package com.example.android_tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class Score extends AppCompatActivity {
    String value1;
    String value2;
    String sh1;
    String sh2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        SharedPreferences s1 = getSharedPreferences("MySharedPreferences", MODE_PRIVATE);
        TextView status1 = findViewById(R.id.score1);
        TextView status2 = findViewById(R.id.score2);

        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        if (bundle != null ) {
            value1 = bundle.getString("value1");
            value2 = bundle.getString("value2");


            SharedPreferences.Editor editor = s1.edit();
            editor.putString("val1", value1);
            editor.putString("val2", value2);
            editor.apply();



            sh1 = s1.getString("val1", "");
            sh2 = s1.getString("val2", "");



            status1.setText(sh1);

            status2.setText(sh2);
        }
        sh1 = s1.getString("val1", "");
        sh2 = s1.getString("val2", "");

        status1.setText(sh1);
        status2.setText(sh2);


    }
}