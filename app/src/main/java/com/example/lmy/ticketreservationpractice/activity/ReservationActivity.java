package com.example.lmy.ticketreservationpractice.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lmy.ticketreservationpractice.R;
import com.example.lmy.ticketreservationpractice.model.CityToCity;

import java.util.Calendar;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class ReservationActivity extends AppCompatActivity {
    private TextView toReservation;
    private TextView toSesrch;
    private TextView toInfo;
    private TextView toAbout;
    private TextView textView_from;
    private TextView textView_to;
    private Button buttonQuery;
    private ImageView imageViewExchange;
    private String date;
    public static final Integer fromRequestCode = 101;
    public static final Integer toRequestCode = 201;


    //datepicker
    private ImageView imageView_datepicker;
    private TextView textView_datepicker;
    private int Year;
    private int Month;
    private int Day;
    private Calendar cal;
    private String cityName;
    private String cityNameTo;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        init();
        //初始化
        initview();
        initListener();


    }

    private void init() {
        intent = getIntent();
        cityName = intent.getStringExtra("cityName");


    }


    private void initview() {

        toReservation = (TextView) findViewById(R.id.toReservation);
        toSesrch = (TextView) findViewById(R.id.toSesrch);
        toInfo = (TextView) findViewById(R.id.toInfo);
        toAbout = (TextView) findViewById(R.id.toAbout);
        textView_from = (TextView) findViewById(R.id.textView_from);
        textView_to = (TextView) findViewById(R.id.textView_to);
        if (cityNameTo != null) {
            textView_to.setText(cityNameTo);
        }
        textView_datepicker = (TextView) findViewById(R.id.textView_datepicker);
        imageViewExchange = (ImageView) findViewById(R.id.imageView_exchange);
        imageView_datepicker = (ImageView) findViewById(R.id.imageView_datepicker);
        buttonQuery = (Button) findViewById(R.id.button_search);

        //datepicker
        getDate();
        textView_datepicker.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.textView_datepicker:
                        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker arg0, int year, int month, int day) {
                                date = year + "-" + (++month) + "-" + day;
                                textView_datepicker.setText(date);
                                //将选择的日期显示到TextView中,因为之前获取month直接使用，所以不需要+1，这个地方需要显示，所以+1


                            }
                        };
                        DatePickerDialog dialog = new DatePickerDialog(ReservationActivity.this,
                                0, listener, Year, Month, Day);//后边三个参数为显示dialog时默认的日期，月份从0开始，0-11对应1-12个月
                        dialog.show();
                        break;
                    default:
                        break;
                }
            }
        });
    }

    private void initListener() {

        toSesrch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ReservationActivity.this, SearchActivity.class);
                startActivity(i);
            }
        });
        toInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ReservationActivity.this, InfoActivity.class);
                startActivity(i);
            }
        });
        toAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ReservationActivity.this, AboutActivity.class);
                startActivity(i);
            }
        });
        textView_from.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ReservationActivity.this, CityActivity.class);
                startActivityForResult(i, fromRequestCode);
            }
        });
        textView_to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ReservationActivity.this, CityActivity.class);
                startActivityForResult(i, toRequestCode);
            }
        });
        buttonQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (date == null) {
                    //如果用户还没有选择日期 不允许查询
                    Toast.makeText(ReservationActivity.this, "还没有选择日期！", Toast.LENGTH_SHORT).show();
                } else {
                    //创建query
                    BmobQuery<CityToCity> query = new BmobQuery<CityToCity>();
                    // 查询data表中对应车票信息
                    String start = textView_from.getText().toString();
                    String end = textView_to.getText().toString();
                    query.addWhereEqualTo("city_start",start);
                    query.addWhereEqualTo("city_end",end);
                    query.findObjects(new FindListener<CityToCity>() {
                        @Override
                        public void done(List<CityToCity> list, BmobException e) {
                            if (list == null) {
                                Log.e("查询票信息错误:", e.getMessage());
                            } else {
                                CityToCity cityToCity = list.get(0);
                                Log.e("查询票信息成功:", cityToCity.toString());
                                // 把CityToCity对象和date传给TicketActivity
                                Intent i = new Intent(ReservationActivity.this, TicketActivity.class);
                                i.putExtra("date", date);
                                i.putExtra("cityToCity", cityToCity);
                                startActivity(i);

                            }
                        }
                    });



                }
            }
        });
        imageViewExchange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String from = textView_from.getText().toString();
                String to = textView_to.getText().toString();
                textView_from.setText(to);
                textView_to.setText(from);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == fromRequestCode) {
            // 填充到from控件
            textView_from.setText(data.getStringExtra("cityName"));
        }
        if (requestCode == toRequestCode) {
            // 填充到to控件
            textView_to.setText(data.getStringExtra("cityName"));
        }
    }


    private void getDate() {
        cal = Calendar.getInstance();
        Year = cal.get(Calendar.YEAR);
        Log.i("wxy", "year" + Year);
        Month = cal.get(Calendar.MONTH);
        Day = cal.get(Calendar.DAY_OF_MONTH);
    }
}


