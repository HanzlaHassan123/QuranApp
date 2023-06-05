package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SurahForm extends AppCompatActivity {
    QDH qdh;
    TextView RANGE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surahform);
        qdh = new QDH();

        String selectedSurahName = getIntent().getStringExtra("selectedSurah");
        int surahNumber = getIntent().getIntExtra("SurahNumber", 0);

        TextView surahName = findViewById(R.id.surahNames);
        surahName.setText(selectedSurahName);

        EditText fromAyatofSurah = findViewById(R.id.editTextTextPersonName);
        EditText toAyatofSurah = findViewById(R.id.editTextTextPersonName2);

        Button btn = findViewById(R.id.button);

        int surahStart = qdh.getSurahStart(surahNumber);
        int surahCount = qdh.getSurahCount(surahNumber);

        int totalsurahSize = surahCount + surahStart;


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fromAyatText = fromAyatofSurah.getText().toString().trim();
                String toAyatText = toAyatofSurah.getText().toString().trim();

                if (!fromAyatText.isEmpty() && !toAyatText.isEmpty()) {
                    try {
                        int fromAyat = Integer.parseInt(fromAyatText);
                        fromAyat = fromAyat + surahStart;
                        int toAyat = Integer.parseInt(toAyatText);
                        toAyat = toAyat + surahStart;
                        if (fromAyat > surahStart && toAyat <= totalsurahSize) {
                            QuranArabicText quranArabicText = new QuranArabicText();
                            Intent intent = new Intent(SurahForm.this, Surah.class);
                            String content = "";
                            for (int i = fromAyat - 1; i < toAyat; i++) {
                                content += quranArabicText.QuranArabicText[i];
                            }
                            intent.putExtra("surahContent", content);
                            startActivity(intent);
                        } else {
                            Toast.makeText(SurahForm.this, "Please write a valid range of Ayat in this surah", Toast.LENGTH_SHORT).show();
                        }
                    } catch (NumberFormatException e) {
                        Toast.makeText(SurahForm.this, "Invalid input for Ayat range", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(SurahForm.this, "Please enter both from and to Ayat", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
