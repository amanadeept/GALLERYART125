package com.example.poojapatel.galleryart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class SignUpPage extends AppCompatActivity {




    private EditText Fn, Ln, email, address, password, confpass, contact;
    private RadioButton r1, r2;
    private Button bb1;
private CheckBox ch;
String Occupation;
    String First_Name, Last_Name, Address, Password, ConfirmPassword, Email;
    String sex = "", user = "", Contact;
    RadioGroup rg1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regiscustomer);



        Fn = findViewById(R.id.input_fullName);
        // FN = fn+"#ARTIST;
        Ln = findViewById(R.id.input_lastName);
        email = findViewById(R.id.Em1);
        address = findViewById(R.id.inputaddress);
        password = findViewById(R.id.input_password);
        confpass = findViewById(R.id.input_password_confirm);
        contact = findViewById(R.id.inputcontact);

        rg1 = (RadioGroup) findViewById(R.id.rg);


        r1 = findViewById(R.id.radio);
        r2 = findViewById(R.id.radio1);


        bb1 = findViewById(R.id.button_register_singnupPage);

        //test();
        bb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit();
            }
        });
    }

//    private void test() {
//        Fn.setText("Pooja ");
//        Ln.setText("Patel");
//        address.setText("ncsils");
//        email.setText("abc00gmail.com");
//        r1.setChecked(true);
//        contact.setText("9878956489");
//        password.setText("Pooja2908");
//        confpass.setText("Pooja2908");
//
//    }

    public void submit(){

        //  COLLECT DATA FROM UI HERE
        First_Name=Fn.getText().toString();
        Last_Name=Ln.getText().toString();
        Address=address.getText().toString();
        Email=email.getText().toString();
        Contact=contact.getText().toString();
        Password=password.getText().toString();
/*
if(ch.isChecked()){
    Email = Email+"#Artist#";
    Occupation = "Artist";
}else{
    Email = Email+"#Customer#";
    Occupation = "Customer";
}
*/


        // PUT VALIDATION HERE

        if (Fn.getText().toString().isEmpty()) {
            Fn.setError("First name not entered");

            Fn.requestFocus();

            return;
        }
        if (Ln.getText().toString().isEmpty()) {
            Ln.setError("Last name not entered");
            Ln.requestFocus();
            return;

        }

        if (address.getText().toString().isEmpty()) {
            address.setError("Address is Required");
            address.requestFocus();
            return;
        }
        if (password.getText().toString().isEmpty()) {
            password.setError("Password not entered");
            password.requestFocus();
            return;
        }
        if (contact.getText().toString().isEmpty()) {
            contact.setError("Required");
            contact.requestFocus();
            return;
        }

        if (confpass.getText().toString().isEmpty()) {
            confpass.setError("Please ENTER password");
            confpass.requestFocus();
            return;
        }
        if (!password.getText().toString().equals(confpass.getText().toString())) {
            confpass.setError("Password Not matched");
            confpass.requestFocus();
            return;
        }
        if (password.getText().toString().length() < 8) {
            password.setError("Password should be atleast of 8 charactors");
            password.requestFocus();
            return;
        }


        //  ADD ALL COLLECTED DATA IN HASHMAP

        HashMap<String, String> data = new HashMap<>();

        data.put("first_name", First_Name);
        data.put("last_name", Last_Name);
       // data.put("sex", sex);
       // data.put("user", user);
        data.put("address", Address);
        data.put("contact", Contact);
        data.put("email", Email);
        data.put("Password", Password);
        data.put("Confirmpassword.",ConfirmPassword);
//data.put("Confirm_pass", ConfirmPassword);

        //  THAT'S IT.
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("GalleryArt");
        ref.child(First_Name).setValue(data).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {

                FirebaseAuth auth = FirebaseAuth.getInstance();
                auth.createUserWithEmailAndPassword(Email,Password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {

                    }
                });

                SignUpPage.this.finish();
            }
        });


    }
}
