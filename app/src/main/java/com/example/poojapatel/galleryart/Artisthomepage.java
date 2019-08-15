package com.example.poojapatel.galleryart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Artisthomepage extends AppCompatActivity {
private Button btt1,btt2,btt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artisthomepage);
        btt1=(Button)findViewById(R.id.button3);
        btt2=(Button)findViewById(R.id.button6);
        btt3=(Button)findViewById(R.id.button7);
        btt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),ArtistRegistration.class);
                startActivity(intent);

            }

        });
        btt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Artistchoice.class);
                startActivity(intent);

            }

        }); btt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),Artistlogin.class);
                startActivity(intent);

            }

        });





    }
}
