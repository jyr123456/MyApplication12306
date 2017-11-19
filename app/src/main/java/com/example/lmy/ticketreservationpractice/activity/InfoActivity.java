package com.example.lmy.ticketreservationpractice.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lmy.ticketreservationpractice.R;

public class InfoActivity extends AppCompatActivity {
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView_username;
    TextView textView_password;
    TextView textView_name;
    TextView textView_phone;
    TextView textView_order;
    TextView textView_edit;
    ImageView imageView_order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        textView1=(TextView)findViewById(R.id.toReservation);
        textView2=(TextView)findViewById(R.id.toSesrch);
        textView3=(TextView)findViewById(R.id.toInfo);
        textView4=(TextView)findViewById(R.id.toAbout);
        textView_username=(TextView)findViewById(R.id.textView_username);
        textView_password=(TextView)findViewById(R.id.textView_password);
        textView_name=(TextView)findViewById(R.id.textView_name);
        textView_phone=(TextView)findViewById(R.id.textView_phone);
        textView_order=(TextView)findViewById(R.id.textView_order);
        textView_edit=(TextView)findViewById(R.id.textView_edit);
        imageView_order=(ImageView)findViewById(R.id.imageView_order);

        textView_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(InfoActivity.this,EditActivity.class);
                startActivity(i);
            }
        });

        textView_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(InfoActivity.this,OrderActivity.class);
                startActivity(i);
            }
        });
        imageView_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(InfoActivity.this,OrderActivity.class);
                startActivity(i);
            }
        });
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(InfoActivity.this,ReservationActivity.class);
                startActivity(i);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(InfoActivity.this,SearchActivity.class);
                startActivity(i);
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(InfoActivity.this,AboutActivity.class);
                startActivity(i);
            }
        });

    }
}
