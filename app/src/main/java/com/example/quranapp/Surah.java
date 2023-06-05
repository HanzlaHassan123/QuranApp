package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Surah extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah);

        String surahContent=getIntent().getStringExtra("surahContent");
        TextView text=findViewById(R.id.SurahAyat);
        text.setText(surahContent);



    }
}