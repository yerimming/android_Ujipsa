package com.gachon.apptest3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ModifyInfo extends AppCompatActivity {
    TextView OriginalNickname,OriginalPSW,OriginalPhone;
    EditText ModifyNickname,ModifyPSW,ModifyPhone;
    Button FinishButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_info);

        FinishButton = findViewById(R.id.finish);
        ModifyNickname = (EditText) findViewById(R.id.modifynickname);
        ModifyPSW = (EditText) findViewById(R.id.modifypsw);
        ModifyPhone = (EditText) findViewById(R.id.modifyphone);
        // OriginalNickname = findViewById(R.id.originalnickname);
        // OriginalPSW = findViewById(R.id.originalpsw);
        // OriginalPhone = findViewById(R.id.originalphone);

        FinishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg1 = ModifyNickname.getText().toString();
                String msg2 = ModifyPSW.getText().toString();
                String msg3 = ModifyPhone.getText().toString();

                //변경된 정보 띄우기
                Toast.makeText(ModifyInfo.this, msg1+"\n"+msg2+"\n"+msg3, Toast.LENGTH_LONG).show();
            }
        });
    }
    //https://velog.io/@continue_deve/%ED%94%84%EB%A1%9C%ED%95%84-%ED%99%94%EB%A9%B4-%EB%9D%84%EC%9A%B0%EA%B8%B0-Toast-EditText
}
