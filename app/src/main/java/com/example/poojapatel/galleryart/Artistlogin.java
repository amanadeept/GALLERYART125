package com.example.poojapatel.galleryart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Artistlogin extends AppCompatActivity {
private Button new1,new2,new3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artistlogin);

        new1=(Button)findViewById(R.id.login);
        new2=(Button)findViewById(R.id.signin);
        new3=(Button)findViewById(R.id.forget_password);


        new1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Artisthomepage.class);
                startActivity(i);
            }
        });


        new2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getApplicationContext(),ArtistRegistration.class);
                startActivity(intent);

            }
        });
        new3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), forgetpassword.class);
                startActivity(intent);

            }
        });
    }
}
