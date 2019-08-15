package com.example.poojapatel.galleryart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;

public class Addcart extends AppCompatActivity {
//    int quantity = 0;
//    private ImageButton m1;
//    private Button bb1;
//    private Button bb2;
//    private Button bb3;
//    private Button bb4;
    private  Button cartt1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcart);
cartt1=(Button)findViewById(R.id.cart1);
cartt1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent=new Intent(getApplicationContext(),Cart.class);
        startActivity(intent);
    }
});
//        bb3 = (Button) findViewById(R.id.checkout);
//        bb3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//                Intent intent = new Intent(Addcart.this, Payment.class);
//                startActivity(intent);
//            }
//        });
//        bb4 = (Button) findViewById(R.id.back);
//        bb4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//                Intent intent = new Intent(Addcart.this, Payment.class);
//                startActivity(intent);
//            }
//        });
//
//    }
//
//    public void increment(View view) {
//        quantity = quantity + 1;
//        display(quantity);
//    }
//
//    public void decrement(View view) {
//        quantity = quantity - 1;
//        display(quantity);
//    }
//
//    private void display(int number) {
//        TextView quantityTextView = (TextView) findViewById(R.id.quantity);
//        quantityTextView.setText(" " + number);
//    }
//
//    private void displayPrice(int number) {
//        TextView priceTextView = (TextView) findViewById(R.id.price);
//        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
//
//    }
//
//    private void displayMessage(String message) {
//        TextView priceTextView = (TextView) findViewById(R.id.price);
//        priceTextView.setText(message);
//    }


    }
}
