package com.gachon.apptest3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity {
    TextView sign;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //회원가입 버튼
        sign = findViewById(R.id.signin);
        //로그인 버튼
        login = findViewById(R.id.loginbutton);

        //----------------------------------------------------------------
        //DB에 저장된 아이디와 비밀번호가 editID & editPassword와 일치하는 지 체크
        // (코드 구현 필요)
        //----------------------------------------------------------------


        //로그인 버튼 클릭시, 마이페이지로 이동
        login.setOnClickListener(v -> {
            //----------------------------------------------------------------
            //1. DB에 저장된 아이디와 비밀번호와 불일치하면 (코드 구현 필요),
            //Toast msg로 회원이 아닙니다! 출력
            //Toast.makeText(this,"회원이 아닙니다!",Toast.LENGTH_LONG).show();
            //----------------------------------------------------------------


            //----------------------------------------------------
            //2. DB에 저장된 아이디와 비밀번호와 일치하면, MyPage로 이동!가 아니라 서랍창으로 이동해야할듯!
            // (코드 구현 필요)
            //----------------------------------------------------
            Intent main_intent = new Intent(this, MainActivity.class);
            startActivity(main_intent);
        });

        //회원가입 버튼 클릭시, 회원가입 페이지로 이동
        sign.setOnClickListener(v -> {
            Intent sign_intent = new Intent(this, Signup.class);
            startActivity(sign_intent);
        });
    }
}