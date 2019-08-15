package com.example.poojapatel.galleryart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Artistchoice extends AppCompatActivity {
    Spinner spinner;
    String[] SPINNERVALUES = {"Ancient","Modern"};
    String SpinnerValue;
    Button GOTO;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artistchoice);


        spinner = (Spinner) findViewById(R.id.spinner2);

        GOTO = (Button) findViewById(R.id.choice1);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Artistchoice.this, android.R.layout.simple_list_item_1, SPINNERVALUES);

        spinner.setAdapter(adapter);

        //Adding setOnItemSelectedListener method on spinner.
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                SpinnerValue = (String) spinner.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });

        GOTO.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                //switch (SpinnerValue) {

                    //case "Ancient":
                        intent = new Intent(Artistchoice.this, UploadActivity.class);
                        startActivity(intent);
                        //break;

                   // case "Modern":
                        //intent = new Intent(Artistchoice.this, UploadActivity.class);
                       // startActivity(intent);
                       // break;


                //}
            }
        });

    }}
