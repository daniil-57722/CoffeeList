package com.example.coffeelist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Map<String, String> coffeesMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coffeesMap.put("Эспрессо", "Здесь могла бы быть информация про Эспрессо");
        coffeesMap.put("Американо", "Здесь могла бы быть информация про Американо");
        coffeesMap.put("Капучино", "Здесь могла бы быть информация про Капучино");
        coffeesMap.put("Латте", "Здесь могла бы быть информация про Латте");
        coffeesMap.put("Гляссе", "Здесь могла бы быть информация про Гляссе");
        coffeesMap.put("Мокко", "Здесь могла бы быть информация про Мокко");
        coffeesMap.put("Флэт Уайт", "Здесь могла бы быть информация про Флэт Уайт");
        coffeesMap.put("Раф", "Здесь могла бы быть информация про Раф");
        coffeesMap.put("Макиато", "Здесь могла бы быть информация про Макиато");
        coffeesMap.put("Латте макиато", "Здесь могла бы быть информация про Латте макиато");

        ListView coffeesListView = (ListView) findViewById(R.id.coffeesListView);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                coffeesMap.keySet().toArray()
        );

        coffeesListView.setAdapter(arrayAdapter);

        coffeesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textView = (TextView) view;
                String selectedItem = (String) textView.getText();
                String selectedInfo = coffeesMap.get(selectedItem);

                Intent intent = new Intent(getApplicationContext(), Coffee.class);
                intent.putExtra("coffeeName", selectedItem);
                intent.putExtra("coffeeInfo", selectedInfo);
                startActivity(intent);

                //замена для второго лейаута
//                Toast.makeText(getApplicationContext(), selectedInfo, Toast.LENGTH_LONG).show();
            }
        });
    }

}