package com.example.quranapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView surahNames;
    QDH obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        obj = new QDH();

        surahNames = findViewById(R.id.surahList);


        ArrayList<String> urduSurahNames = obj.GetSurahNames();
        ArrayList<String> EnglishSurahNames=obj.GetEnglishSurahNames();


       ArrayList<String> combinedList= new ArrayList<>();

       int size=Math.min(urduSurahNames.size(),EnglishSurahNames.size());


       for(int i=0;i<size;i++){
           String urduSurahName=urduSurahNames.get(i);
           String EnglishSurahName=EnglishSurahNames.get(i);
           String combinedItem=String.format("%-90s %s", EnglishSurahName,urduSurahName);
           combinedList.add(combinedItem);
       }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, combinedList);
        surahNames.setAdapter(adapter);

        surahNames.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem=(String) parent.getItemAtPosition(position);
                Intent intent= new Intent(MainActivity.this,Surahs.class);
                intent.putExtra("selectedSurah",selectedItem);
                startActivity(intent);

            }
        });

    }
}
