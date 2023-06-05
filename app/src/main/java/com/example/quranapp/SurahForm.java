package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SurahForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surahform);
        String selectedSurahName=getIntent().getStringExtra("selectedSurah");

        TextView surahName=findViewById(R.id.surahNames);
        surahName.setText(selectedSurahName);
    }
}