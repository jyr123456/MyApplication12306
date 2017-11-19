package com.example.lmy.ticketreservationpractice.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lmy.ticketreservationpractice.R;
import com.example.lmy.ticketreservationpractice.model.User;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class MainActivity extends Activity {
    private EditText userNameInput;
    private EditText pwdInput;
    private CheckBox remmberPwdCheckBox;
    private CheckBox autoLoginCheckBox;
    private Button loginButton;
    private Button registerButton;
    private SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化
        initView();



    }

    private void initView() {
        userNameInput =(EditText)findViewById(R.id.editText_username);
        pwdInput =(EditText)findViewById(R.id.editText_password);
        remmberPwdCheckBox =(CheckBox)findViewById(R.id.checkBox_rem);
        autoLoginCheckBox =(CheckBox)findViewById(R.id.checkBox_auto);
        loginButton =(Button)findViewById(R.id.button_log);
        registerButton =(Button)findViewById(R.id.button_reg);

        loginButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                String username= userNameInput.getText().toString();
                String pwd= pwdInput.getText().toString();//获取输入的用户名、密码
                BmobQuery<User> query = new BmobQuery<User>();
                query.addWhereEqualTo("username",username);
                query.addWhereEqualTo("password",pwd);
                query.findObjects(new FindListener<User>() {
                    @Override
                    public void done(List<User> list, BmobException e) {
                        if (list != null){
                            User user=list.get(0);
                            Log.i("登录用户：", user.getUsername());
                            Toast.makeText(MainActivity.this,"登录成功！",Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(MainActivity.this,ReservationActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(MainActivity.this,"用户名或密码错误！",Toast.LENGTH_SHORT).show();
                        }
                    }
                });


            }
        });
        registerButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent i=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(i);
            }
        });
    }

}
