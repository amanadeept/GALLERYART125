package com.example.poojapatel.galleryart;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class CustomerLogin extends Activity {
    private Button bb2, button, bu1;
    private EditText email, password;
    private FirebaseAuth Auth;
    private ProgressDialog pd;
    private CheckBox c1;


    // button_login

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_login);

//        pd.setCanceledOnTouchOutside(false);
        Auth = FirebaseAuth.getInstance();

//if (Auth.getCurrentUser()!=null){
//    Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
//    startActivity(intent);
//    finish();
//}
        email= findViewById(R.id.input_username);
        bb2 = (Button) findViewById(R.id.button_login);
        button = (Button) findViewById(R.id.button_register);
        bu1 = (Button) findViewById(R.id.button_forgot_password);
        c1 = findViewById(R.id.checkbox);
        password = findViewById(R.id.input_password);







        bb2.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {

                                       Intent intent = new Intent(getApplicationContext(), HomePage.class);
                                       startActivity(intent);
                                       finish();
                                   }

                               });

        bu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(),forgetpassword.class);
                startActivity(intent1);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignUpPage.class);

                startActivity(intent);


            }


        });

    }
}
