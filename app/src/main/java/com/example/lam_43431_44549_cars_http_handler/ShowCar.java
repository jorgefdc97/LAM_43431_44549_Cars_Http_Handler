package com.example.lam_43431_44549_cars_http_handler;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.os.HandlerCompat;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShowCar extends AppCompatActivity {
    ExecutorService executorService;
    Handler mainThreadHandler;
    TextView textView;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand_description);

        executorService = Executors.newFixedThreadPool(4);
        mainThreadHandler = HandlerCompat.createAsync(Looper.getMainLooper());

        textView = findViewById(R.id.textView5);
        textView.setMovementMethod(new ScrollingMovementMethod());
        Intent intent = getIntent();
        String brand = intent.getStringExtra(MainActivity.keyBrand);
        int logo = intent.getIntExtra(MainActivity.keyLogo,0);
        ImageView imageView = findViewById(R.id.imageView3);
        imageView.setImageResource(logo);
        url=getResources().getString(R.string.url);
        url+=brand.toLowerCase()+".html";
        System.out.println(url);
        new ExecutorTask(executorService,mainThreadHandler,textView,url);
    }

    public void onClick(View v){
        finish();
    }
}
