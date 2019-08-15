package com.example.poojapatel.galleryart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePage extends AppCompatActivity {
private Button nb1,buttonn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        nb1 = (Button) findViewById(R.id.buttonnext);
        buttonn=(Button)findViewById(R.id.button8);

        nb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent  intent =new Intent(HomePage.this, categories.class);
                startActivity(intent);
            }
        });
        buttonn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent  intent =new Intent(HomePage.this,SignUpPage.class);
                startActivity(intent);
            }
        });

    }
}
