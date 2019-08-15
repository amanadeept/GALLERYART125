package com.example.poojapatel.galleryart;
import android.content.Intent;
import android.os.AsyncTask;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
//        import android.content.Intent;
//
     import androidx.appcompat.app.AppCompatActivity;
//
//        import android.os.Bundle;
//        import android.view.Menu;
//        import android.view.View;
//        import android.widget.Button;
//        import android.widget.CheckBox;
//        import android.widget.EditText;
//        import android.widget.RadioButton;
//
//        import android.widget.RadioGroup;
//        import android.widget.Toast;




public class CustomerRegistration extends AppCompatActivity {

    private EditText Fn, Ln, email, address, password, confpass, contact;


    private RadioButton r1, r2;
    private CheckBox r3;
    private Button bb1;

    String First_Name, Last_Name, Address, Password, ConfirmPassword, Email;
    String sex = "", user = "", Contact;
    RadioGroup rg1;
    RadioGroup rg2;

//    EditText t,t1, t2, t3, t4, t5;
//    String type, username, firstname, password, lastname, email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regiscustomer);

        Fn = findViewById(R.id.input_fullName);
        Ln = findViewById(R.id.input_lastName);
        email = findViewById(R.id.Em1);
        address = findViewById(R.id.inputaddress);
        password = findViewById(R.id.input_password);
        confpass = findViewById(R.id.input_password_confirm);
        contact = findViewById(R.id.inputcontact);

        rg1 = (RadioGroup) findViewById(R.id.rg);


        r1 = findViewById(R.id.radio);
        r2 = findViewById(R.id.radio1);
        r3 = findViewById(R.id.checkbox);


        bb1 = findViewById(R.id.button_register_singnupPage);


        bb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitForm();

            }

        });


    }

        private void submitForm() {


        int sexRadio = rg1.getCheckedRadioButtonId();

        // If nothing is selected from Radio Group, then it return -1
        if (sexRadio != -1) {

            RadioButton selectedRadioButton = (RadioButton) findViewById(sexRadio);
            sex = selectedRadioButton.getText().toString();
        } else {
            sex = "Male";
        }




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
            confpass.setError("Please confirm password");
            confpass.requestFocus();
            return;
        }
        if (!password.getText().toString().equals(confpass.getText().toString())) {
            confpass.setError("Password Not matched");
            confpass.requestFocus();

        }
        if (password.getText().toString().length() < 8) {
            password.setError("Password should be atleast of 8 charactors");
            password.requestFocus();

        }

        First_Name = Fn.getText().toString().trim();
        Last_Name = Ln.getText().toString();
        Address = address.getText().toString();
        Email = email.getText().toString();

        Contact = contact.getText().toString();
        Password = password.getText().toString();
        ConfirmPassword = confpass.getText().toString();
        r1.setChecked(true);


        if (r1.isChecked()) {
            sex = r1.getText().toString();

        } else if (r2.isChecked()) {
            sex = r2.getText().toString();
        } else {
            Toast.makeText(getApplicationContext(), "ERROR Please select the gender!!", Toast.LENGTH_LONG);
            return;
        }

        Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_LONG).show();


        Intent i = new Intent(getApplicationContext(),CustomerLogin.class);
        startActivity(i);


        }
    }





         public void register(View view) {
//
//                type=t.getText().toString();
//                username = t1.getText().toString();
//                password = t2.getText().toString();
//                firstname = t3.getText().toString();
//                lastname = t4.getText().toString();
//                email = t5.getText().toString();
                System.out.println("Print something"+ First_Name);

                new CustomerRegistration().MyTask().execute();











//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//
//
//    }
//
//
//

    private void MyTask() extends AsyncTask<Void, Void, String> {
                 {


                 @Override
                 protected String doInBackground(Void... params) {
                     StringBuffer response = new StringBuffer();
                     URL url = null;


                     try {

                         url = new URL("http://10.0.2.2:27897/WebApplication1/Myapp/main/registration&"+ ""+type+""+"&"+"" + username + "" + "&" + "" + password + "" + "&" + "" + firstname + ""
                                 + "&" + "" + lastname + "" + "&" + "" + email + "");

                         // url = new URL("http://10.0.2.2:27897/WebApplication1/Myapp/main/login&"+ "'" + uname + "'"+ "&" +"'"+pass+"'");
              /* url = new URL("http://10.0.2.2:27897/WebApplication1/Myapp/main/registration&101"+"&" + "'"+type+"'"+"&"+"'" + username + "'" + "&" + "'" + password + "'" + "&" + "'" + firstname + "'"
                      + "&" + "'" + lastname + "'" + "&" + "'" + email + "'");
*/
                         //url = new URL("http://10.0.2.2:27897/WebApplication1/Myapp/main/Addoffers_travels&1012"+ "'" +  file.getAbsolutePath()+ "'"+
                         // "&"+"'"+description+"'"+"&"+"'"+offer+"'"+"&"+"'"+Expiration_date+"'");



                         // url = new URL("http://10.0.2.2:27897/WebApplication1/Myapp/main/Registration&"+type+"&"+username+"&"+password+"&"+lastname+"&"+firstname+"&"+email+"");
                         // url = new URL("http://10.0.2.2:27897/WebApplication1/Myapp/main/Registration&"+ "'" +type+ "'"+ "&" + "'" +username+ "'" + "&" + "'" +password+ "'" + "&"
                         //   + "'" +lastname+ "'" + "&" + "'" +firstname+ "'" + "& "+ "'"+email+"'");

                         HttpURLConnection client = null;
                         client = (HttpURLConnection) url.openConnection();
                         client.setRequestMethod("GET");
                         int responseCode = client.getResponseCode();
                         System.out.println("\n Sending 'GET' request to URL : " + url);
                         System.out.println("Response Code : " + responseCode);
                         InputStreamReader myInput = new InputStreamReader(client.getInputStream());
                         BufferedReader in = new BufferedReader(myInput);
                         String inputLine;


                         while ((inputLine = in.readLine()) != null) {
                             response.append(inputLine);
                         }
                         in.close();

                         // print result
                         System.out.println("The response is " + response.toString());


                     } catch (ProtocolException e) {
                         e.printStackTrace();
                     } catch (MalformedURLException e) {
                         e.printStackTrace();
                     } catch (IOException e) {
                         e.printStackTrace();
                     } catch (Exception e) {
                     }

                     return response.toString();
                 }

                 protected void onPostExecute(String result) {

                     super.onPostExecute(result);
                     if (result.equalsIgnoreCase("wrong")) {
                         Toast.makeText(getApplication(), "error occured while registering, please try again", Toast.LENGTH_LONG).show();

                     } else {
                         Intent launchActivity1 = new Intent(getApplicationContext(),CustomerLogin.class);
                         startActivity(launchActivity1);

                     }
                 }

             }
         }









             }
    }