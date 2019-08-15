
    package com.example.poojapatel.galleryart;


    import android.content.Intent;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.AdapterView;
    import android.widget.ArrayAdapter;
    import android.widget.Button;
    import android.widget.Spinner;

    import androidx.appcompat.app.AppCompatActivity;

    public class categories extends AppCompatActivity {




        Spinner spinner;
        String[] SPINNERVALUES = {"Ancient","Modern"};
        String SpinnerValue;
        Button GOTO;
        Intent intent;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.categories);

            spinner = (Spinner) findViewById(R.id.spinner1);

            GOTO = (Button) findViewById(R.id.button1);

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(categories.this, android.R.layout.simple_list_item_1, SPINNERVALUES);

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

                    switch (SpinnerValue) {

                        case "Ancient":
                            intent = new Intent(categories.this, ancient.class);
                            startActivity(intent);
                            break;

                        case "Modern":
                            intent = new Intent(categories.this, modern.class);
                            startActivity(intent);
                            break;


                    }
                }
            });

        }}
