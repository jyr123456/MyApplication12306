package com.example.lmy.ticketreservationpractice.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lmy.ticketreservationpractice.R;

import java.util.Calendar;

public class SearchActivity extends AppCompatActivity {
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    EditText editText_train_number;
    DatePicker datePicker;
    Button button_search;
    //datepicker
    private ImageView imageView_datepicker;
    private TextView textView_datepicker;
    private int Year;
    private int Month;
    private int Day;
    private Calendar cal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        textView1=(TextView)findViewById(R.id.toReservation);
        textView2=(TextView)findViewById(R.id.toSesrch);
        textView3=(TextView)findViewById(R.id.toInfo);
        textView4=(TextView)findViewById(R.id.toAbout);
        textView_datepicker = (TextView) findViewById(R.id.textView_datepicker);
        editText_train_number=(EditText)findViewById(R.id.editText_train_number);
        imageView_datepicker = (ImageView) findViewById(R.id.imageView_datepicker);
        button_search=(Button)findViewById(R.id.button_search);


        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SearchActivity.this,ReservationActivity.class);
                startActivity(i);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SearchActivity.this,InfoActivity.class);
                startActivity(i);
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(SearchActivity.this,AboutActivity.class);
                startActivity(i);
            }
        });
        button_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number=editText_train_number.getText().toString();
            }
        });
        //datepicker
        getDate();
        textView_datepicker.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                switch(view.getId()){
                    case R.id.textView_datepicker:
                        DatePickerDialog.OnDateSetListener listener=new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker arg0, int year, int month, int day) {
                                textView_datepicker.setText(year+"-"+(++month)+"-"+day);
                                //将选择的日期显示到TextView中,因为之前获取month直接使用，所以不需要+1，这个地方需要显示，所以+1
                            }
                        };
                        DatePickerDialog dialog=new DatePickerDialog(SearchActivity.this,
                                0,listener,Year,Month,Day);//后边三个参数为显示dialog时默认的日期，月份从0开始，0-11对应1-12个月
                        dialog.show();
                        break;
                    default:
                        break;
                }
            }
        });

    }
    private void getDate(){
        cal=Calendar.getInstance();
        Year=cal.get(Calendar.YEAR);
        Log.i("wxy","year"+Year);
        Month=cal.get(Calendar.MONTH);
        Day=cal.get(Calendar.DAY_OF_MONTH);
    }
}
