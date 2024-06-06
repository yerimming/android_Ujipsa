package com.gachon.apptest3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Signup extends AppCompatActivity {
    TextView back;
    EditText name,id,nickname,pw,pw2,phone,birthdate;
    Button pwcheck,submit;


    Calendar myCalendar = Calendar.getInstance();

    DatePickerDialog.OnDateSetListener myDatePicker = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //뒤로 가기 버튼
        back = findViewById(R.id.back);
        back.setOnClickListener(v->onBackPressed());

        //가입 항목
        name = findViewById(R.id.signName);
        id=findViewById(R.id.signID);
        nickname=findViewById(R.id.signNickName);
        pw=findViewById(R.id.signPW);
        pw2=findViewById(R.id.signPW2);
        phone=findViewById(R.id.signPhone);
        birthdate=findViewById(R.id.signBirthDate);

        //-----------------------------------------------
        //DB에 이미 존재하는 아이디와 중복 체크하는 부분 구현 필요
        //-----------------------------------------------

        //--------------------------------------------
        //DB에 이미 존재하는 닉네임과 중복 체크 부분 구현 필요
        //--------------------------------------------

        //생년월일
        birthdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(Signup.this,myDatePicker,
                        myCalendar.get(Calendar.YEAR),
                        myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        //비밀번호 확인 버튼
        pwcheck = findViewById(R.id.pwcheckbutton);
        pwcheck.setOnClickListener(v -> {
            if(pw.getText().toString().equals(pw2.getText().toString())){
                pwcheck.setText("일치");
            }else{
                Toast.makeText(Signup.this, "비밀번호가 다릅니다.", Toast.LENGTH_LONG).show();
            }
        });

        //회원가입 완료 버튼
        submit = findViewById(R.id.signupbutton);
        submit.setOnClickListener(v -> {
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);

            //회원가입 창 새로고침한 후 다시 입력하게끔 유도...
            if(TextUtils.isEmpty(name.getText().toString())||TextUtils.isEmpty(id.getText().toString())
                    ||TextUtils.isEmpty(pw.getText().toString())||TextUtils.isEmpty(phone.getText().toString())
                    ||TextUtils.isEmpty(nickname.getText().toString())){
                Toast.makeText(Signup.this,"회원가입 실패",Toast.LENGTH_LONG).show();
            } else{
                Toast.makeText(this,"회원가입 성공!",Toast.LENGTH_LONG).show();

                //------------------------------
                //EditText가 입력한 부분을 DB에 저장
                //------------------------------
            }
        });
    }

    private void updateLabel() {
        String myFormat = "yyyy/MM/dd";    // 출력형식   2021/07/26
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.KOREA);

        EditText et_date = (EditText) findViewById(R.id.signBirthDate);
        et_date.setText(sdf.format(myCalendar.getTime()));
    }
}