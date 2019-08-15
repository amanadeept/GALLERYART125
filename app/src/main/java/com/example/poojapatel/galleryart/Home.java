package com.example.poojapatel.galleryart;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends Activity {
    private Button b1,mm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        b1 = (Button)findViewById(R.id.Customer);
mm=(Button)findViewById(R.id.kk);
    b1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i= new Intent(getApplicationContext(),CustomerLogin.class);
            startActivity(i);

        }
    });
mm.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i= new Intent(getApplicationContext(),Artistlogin.class);
        startActivity(i);
    }
});

        }

    }

