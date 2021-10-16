package com.example.coffeelist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class Coffee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee);

        TextView coffeeNameTextView = (TextView) findViewById(R.id.headline);
        WebView CoffeeInfo = (WebView) findViewById(R.id.textCoffeeInfo);
        CoffeeInfo.setWebViewClient(new WebViewClient());
        String coffeeNameString = getIntent().getExtras().getString("coffeeName");
        String coffeeInfoString = getIntent().getExtras().getString("coffeeInfo");

        coffeeNameTextView.setText(coffeeNameString);
        CoffeeInfo.loadUrl(coffeeInfoString);
    }
}