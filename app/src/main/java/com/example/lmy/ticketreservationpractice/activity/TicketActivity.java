package com.example.lmy.ticketreservationpractice.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lmy.ticketreservationpractice.R;
import com.example.lmy.ticketreservationpractice.model.CityToCity;

public class TicketActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView infoFrom;
    private TextView infoTo;
    private TextView dateTextView;
    private TextView infoPrice;
    private TextView trainNumber;
    private Button button_buy;
    private ImageView imageView_back;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);

        init();
        //初始化
        initView();
        initListener();




    }

    private void init() {
        intent = getIntent();
    }


    private void initView() {
        textView1=(TextView)findViewById(R.id.toReservation);
        textView2=(TextView)findViewById(R.id.toSesrch);
        textView3=(TextView)findViewById(R.id.toInfo);
        textView4=(TextView)findViewById(R.id.toAbout);
        infoFrom =(TextView)findViewById(R.id.textView_from);
        infoPrice =(TextView)findViewById(R.id.textView_price);
        infoTo =(TextView)findViewById(R.id.textView_to);
        trainNumber =(TextView)findViewById(R.id.textView_remain);
        button_buy=(Button)findViewById(R.id.button_buy);
        imageView_back=(ImageView)findViewById(R.id.imageView_back);

        CityToCity cityToCity=(CityToCity) intent.getSerializableExtra("cityToCity");
        if (cityToCity != null) {
            infoFrom.setText(cityToCity.getCity_start());
            infoTo.setText(cityToCity.getCity_end());
            infoPrice.setText(cityToCity.getPrice());
            trainNumber.setText(cityToCity.getTrain_namber());
        }
        dateTextView =(TextView)findViewById(R.id.textView_date);
        String date = intent.getStringExtra("date");
        if (date!= null) {
            dateTextView.setText(date);
        }
    }

    private void initListener() {
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(TicketActivity.this,ReservationActivity.class);
                startActivity(i);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(TicketActivity.this,SearchActivity.class);
                startActivity(i);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(TicketActivity.this,InfoActivity.class);
                startActivity(i);
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(TicketActivity.this,AboutActivity.class);
                startActivity(i);
            }
        });
        imageView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(TicketActivity.this,ReservationActivity.class);
                startActivity(i);
            }
        });
        button_buy.setOnClickListener(this);
    }


    //设置AlertDialog

    public void onClick(View v){
        switch(v.getId()){
            case R.id.button_buy:
                AlertDialog.Builder dialog=new AlertDialog.Builder(TicketActivity.this);
                dialog.setTitle("确认购买");
                dialog.setMessage("确认购买车票？");
                dialog.setCancelable(false);
                dialog.setPositiveButton("确认",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog,int which){
                        Intent i =new Intent(TicketActivity.this,OrderActivity.class);
                        startActivity(i);
                    }
                });
                dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dialog.show();
                break;
            default:
                break;
        }
    }

}
