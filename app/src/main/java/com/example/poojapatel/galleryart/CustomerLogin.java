package com.example.poojapatel.galleryart;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL; import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {
    private EditText email_et,password_et;
    //String username;
    private ProgressDialog pd;
    String email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_login);
        email_et=findViewById(R.id.input_username);
        password_et=findViewById(R.id.input_password);
        pd = new ProgressDialog(this);
        pd.setMessage("please wait....");
        pd.setTitle("loading");
    }

    public void do_login(View view){
        email=email_et.getText().toString();
        password=password_et.getText().toString();
        if (Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            Toast.makeText(Login.this,"Please check your email",Toast.LENGTH_SHORT).show();
            return;
        }
        if (password.length()<8)
        {
            Toast.makeText(Login.this,"Password atleast 8 characters",Toast.LENGTH_SHORT).show();
            return;
        }

        new MyTask().execute();

    }
    public void signup(View view){

        Intent i =getIntent();
        Bundle bundle=i.getExtras();
        email=bundle.getString("type");
        Intent in=new Intent(Login.this,Home.class);
        in.putExtra("type",email);
        startActivity(in);
    }
    private class MyTask extends AsyncTask<Void,Void,Void> {
        int fulluid;
        String user_status;

        public String getUser_status() {
            return user_status;
        }

        public void setUser_status(String user_status) {
            this.user_status = user_status;
        }

        public int getFulluid() {
            return fulluid;
        }

        public void setFulluid(int fulluid) {
            this.fulluid = fulluid;
        }

        @Override
        protected Void doInBackground(Void... params) {
            URL url = null;
            try {
                url = new URL("http://localhost:8080/WebApplication5/webresources/mobile/Login&" + email + "&" + password);
                HttpURLConnection client = null;
                client = (HttpURLConnection) url.openConnection();
                client.setRequestMethod("GET");
                int resonseCode = client.getResponseCode();
                System.out.println("\n Sending 'GET' request to URL : " + url);
                System.out.println("Response code :" + resonseCode);
                InputStreamReader myInput = new InputStreamReader(client.getInputStream());
                BufferedReader in = new BufferedReader(myInput);
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                System.out.println(response.toString());
                JSONObject object = new JSONObject(response.toString());

                user_status = object.getString("status");
                setUser_status(user_status);
                int userid = object.getInt("USER_ID");
                Da datamodel=Datamodel.geInstance();
                datamodel.setUser_id(userid);

                datamodel.setEmail(object.getLong("EMAIL_ID"));

            }catch (MalformedURLException e){
                e.printStackTrace();
            }catch (ProtocolException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }catch (JSONException e){
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void result){
            super.onPostExecute(result);
            System.out.println("pyy"+getUser_status()+email);
            if (getUser_status().equals("ok")) {
                Intent bridge = new Intent(getApplicationContext(), HomePage.class);
                Toast.makeText(getApplicationContext(), "You are successfully", Toast.LENGTH_SHORT).show();
                startActivity(bridge);
            }else {
                Toast.makeText(getApplicationContext(),"please recheck your email and password",Toast.LENGTH_LONG).show();
            }

        }
    }}