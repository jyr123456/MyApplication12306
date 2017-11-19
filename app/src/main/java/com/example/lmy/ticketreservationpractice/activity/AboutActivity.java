package com.example.lmy.ticketreservationpractice.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.lmy.ticketreservationpractice.R;

public class AboutActivity extends AppCompatActivity {
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        textView1=(TextView)findViewById(R.id.toReservation);
        textView2=(TextView)findViewById(R.id.toSesrch);
        textView3=(TextView)findViewById(R.id.toInfo);
        textView4=(TextView)findViewById(R.id.toAbout);

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(AboutActivity.this,ReservationActivity.class);
                startActivity(i);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(AboutActivity.this,SearchActivity.class);
                startActivity(i);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(AboutActivity.this,InfoActivity.class);
                startActivity(i);
            }
        });
    }
}
