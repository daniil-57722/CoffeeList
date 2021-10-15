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
        coffeesMap.put("Эспрессо", getString(R.string.espresso));
        coffeesMap.put("Американо", getString(R.string.americano));
        coffeesMap.put("Капучино", getString(R.string.capuchino));
        coffeesMap.put("Латте", getString(R.string.latte));
        coffeesMap.put("Гляссе", getString(R.string.glasse));
        coffeesMap.put("Мокко", getString(R.string.mokko));
        coffeesMap.put("Флэт Уайт", getString(R.string.flat_white));
        coffeesMap.put("Раф", getString(R.string.raph));
        coffeesMap.put("Макиато", getString(R.string.makiato));
        coffeesMap.put("Латте макиато", getString(R.string.latte_makiato));

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