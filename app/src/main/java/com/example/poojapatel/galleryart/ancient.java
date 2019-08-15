package com.example.poojapatel.galleryart;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class ancient extends Activity {
private ImageView im1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ancient);
        im1 = (ImageView) findViewById(R.id.ancient1);
        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Addcart.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "select image", Toast.LENGTH_LONG).show();
            }
        });
    }}
