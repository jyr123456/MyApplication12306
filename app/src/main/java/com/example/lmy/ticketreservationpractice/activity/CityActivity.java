package com.example.lmy.ticketreservationpractice.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lmy.ticketreservationpractice.R;
import com.example.lmy.ticketreservationpractice.model.City;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class CityActivity extends AppCompatActivity {
    private TextView toReservation;
    private TextView toSesrch;
    private TextView toInfo;
    private TextView toAbout;
    private ImageView imageView_back;
    private SearchView searchView_city;
    private ListView listView_city;
    private List<String> cities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
init();
        //初始化
        initview();

        // 加载数据
        BmobQuery<City> query = new BmobQuery<City>();
        query.findObjects(new FindListener<City>() {
            @Override
            public void done(List<City> list, BmobException e) {
                if(list != null){
                    Log.i("get list size",list.size()+"");
                    for (City city:list){
                        cities.add(city.getCityname());
                    }
                    listView_city.setAdapter(new ArrayAdapter<String>(CityActivity.this, android.R.layout.simple_list_item_1, cities));

                }else {
                    Log.e("get list error:",e.getMessage());
                }
            }
        });

        //设置searchview\listview
//        listView_city.setAdapter(new ArrayAdapter<String>(this,android.R.layout.
//                simple_list_item_1,cities));
        listView_city.setTextFilterEnabled(true);
        listView_city.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(CityActivity.this,"clicked the "+i+" line",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(CityActivity.this,ReservationActivity.class);
                intent.putExtra("cityName", cities.get(i));
                setResult(ReservationActivity.fromRequestCode,intent);
                finish();
            }
        });


//        searchView_city.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            public boolean onQueryTextChange(String newText) {
//                if (!TextUtils.isEmpty(newText)){
//                    listView_city.setFilterText(newText);
//                }else{
//                    listView_city.clearTextFilter();
//                }
//                return false;
//            }
//        });
    }

    private void init() {
        cities = new ArrayList<>();
    }

    private void initview() {
        toReservation =(TextView)findViewById(R.id.toReservation);
        toSesrch =(TextView)findViewById(R.id.toSesrch);
        toInfo =(TextView)findViewById(R.id.toInfo);
        toAbout =(TextView)findViewById(R.id.toAbout);
        imageView_back=(ImageView)findViewById(R.id.imageView_back);
        searchView_city=(SearchView)findViewById(R.id.searchView_city);
        listView_city=(ListView)findViewById(R.id.listView_city);


        toReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(CityActivity.this,ReservationActivity.class);
                startActivity(i);
            }
        });
        toSesrch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(CityActivity.this,SearchActivity.class);
                startActivity(i);
            }
        });
        toInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(
                        CityActivity.this,InfoActivity.class);
                startActivity(i);
            }
        });
        toAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(CityActivity.this,AboutActivity.class);
                startActivity(i);
            }
        });
        imageView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(CityActivity.this,ReservationActivity.class);
                startActivity(i);
            }
        });
    }
}
