package com.example.lmy.ticketreservationpractice.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lmy.ticketreservationpractice.R;

public class EditActivity extends AppCompatActivity {
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    EditText editText_username;
    EditText editText_password;
    EditText editText_affirm;
    EditText editText_name;
    EditText editText_phone;
    Button button_save;
    ImageView imageView_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        textView1=(TextView)findViewById(R.id.toReservation);
        textView2=(TextView)findViewById(R.id.toSesrch);
        textView3=(TextView)findViewById(R.id.toInfo);
        textView4=(TextView)findViewById(R.id.toAbout);
        editText_username=(EditText)findViewById(R.id.editText_username);
        editText_password=(EditText)findViewById(R.id.editText_password);
        editText_affirm=(EditText)findViewById(R.id.editText_affirm);
        editText_name=(EditText)findViewById(R.id.editText_name);
        editText_phone=(EditText)findViewById(R.id.editText_phone);
        button_save=(Button)findViewById(R.id.button_save);
        imageView_back=(ImageView)findViewById(R.id.imageView_back);

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(EditActivity.this,ReservationActivity.class);
                startActivity(i);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(EditActivity.this,SearchActivity.class);
                startActivity(i);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(EditActivity.this,InfoActivity.class);
                startActivity(i);
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(EditActivity.this,AboutActivity.class);
                startActivity(i);
            }
        });

        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=editText_username.getText().toString();
                String password=editText_password.getText().toString();
                String affirm=editText_affirm.getText().toString();
                String name=editText_name.getText().toString();
                String phone=editText_phone.getText().toString();
                if(username==null|password==null|affirm==null|name==null|phone==null){
                    Toast.makeText(EditActivity.this,"请将注册信息填写完整",
                            Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(EditActivity.this,"修改成功",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(EditActivity.this,InfoActivity.class);
                    startActivity(intent);
                }
            }
        });

        imageView_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EditActivity.this,InfoActivity.class);
                startActivity(intent);
            }
        });
    }
}
