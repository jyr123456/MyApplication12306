package com.example.lmy.ticketreservationpractice.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lmy.ticketreservationpractice.R;
import com.example.lmy.ticketreservationpractice.model.User;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class RegisterActivity extends AppCompatActivity {
    EditText editTextUsername;
    EditText editTextPassword;
    EditText editTextAffirm;
    EditText editTextName;
    EditText editTextPhone;
    Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //初始化
        initView();
    }


    private void initView() {
        editTextUsername = (EditText) findViewById(R.id.editText_username);
        editTextPassword = (EditText) findViewById(R.id.editText_password);
        editTextAffirm = (EditText) findViewById(R.id.editText_affirm);
        editTextName = (EditText) findViewById(R.id.editText_name);
        editTextPhone = (EditText) findViewById(R.id.editText_phone);
        buttonRegister = (Button) findViewById(R.id.button_reg);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editTextUsername.getText().toString();
                String password = editTextPassword.getText().toString();
                String affirm = editTextAffirm.getText().toString();
                String name = editTextName.getText().toString();
                String phone = editTextPhone.getText().toString();
                if (username == null | password == null | affirm == null | name == null | phone == null) {
                    Toast.makeText(RegisterActivity.this, "请将注册信息填写完整",
                            Toast.LENGTH_SHORT).show();
                }
                else if(username.matches("[A-Za-z0-9_]{1,16}")!=true){
                    Toast.makeText(RegisterActivity.this,"用户名只能由数字、英文字母以及下划线组成",
                            Toast.LENGTH_SHORT).show();
                }
                else if(password.matches("[0-9]{6}")!=true){
                    Toast.makeText(RegisterActivity.this,"密码只能由6位数字组成",
                            Toast.LENGTH_SHORT).show();
                }else if(!password.equals(affirm)){
                    Toast.makeText(RegisterActivity.this,"两次输入密码不一致",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    // 如果服务器返回成功，再走下面的流程
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    user.setName(name);
                    user.setMobilePhoneNumber(phone);
                    user.signUp(new SaveListener<User>() {
                        @Override
                        public void done(User User, BmobException e) {
                            if (e == null) {
                                Toast.makeText(RegisterActivity.this,"注册成功！",
                                        Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(RegisterActivity.this,MainActivity.class);
                                startActivity(intent);
                            }else {
                                Log.e("异常：",e.getMessage());
                            }
                        }
                    });
                }
            }
        });
    }
}