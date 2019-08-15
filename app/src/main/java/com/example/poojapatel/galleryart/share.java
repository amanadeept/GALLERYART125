package com.example.poojapatel.galleryart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class share extends AppCompatActivity {
    private Button sharee;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share);
        sharee=(Button)findViewById(R.id.share1);
        sharee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),HomePage.class);
                startActivity(intent);
            }
        });
    }
}
