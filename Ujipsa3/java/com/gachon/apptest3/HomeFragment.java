package com.gachon.apptest3;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;


public class HomeFragment extends Fragment {
    ListView listView;
    ArrayList<String> list = new ArrayList<String>();
    Button btnAdd;
    Button btnDel;
    ArrayAdapter<String> adapter;
    TextView datePickerText;
    DatePickerDialog datePickerDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);

        listView=(ListView) rootView.findViewById(R.id.listview);
        btnAdd = (Button) rootView.findViewById(R.id.btnAdd);
        btnDel = (Button) rootView.findViewById(R.id.btnDel);

        //adapter 객체 생성
        adapter = new ArrayAdapter<String>(getActivity(),
                //보여질 레이아웃 형태
                android.R.layout.simple_list_item_multiple_choice,
                //보여질 데이터를 담고있는 배열
                list);

        //항목을 선택할 수 있는 모드 설정
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        //어댑터와 리스트뷰 연결하기
        listView.setAdapter(adapter);

        //항목을 선택했을 때 수행할 동작 처리(이벤트 처리)
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                String item = list.get(position);
                //Toast.makeText(getActivity(),"선택항목:"+item,Toast.LENGTH_SHORT).show();
            }
        });

        datePickerText = rootView.findViewById(R.id.dateText);
        ImageView datePickerBtn = rootView.findViewById(R.id.dateBtn);

        datePickerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int pYear = calendar.get(Calendar.YEAR);
                int pMonth = calendar.get(Calendar.MONTH);
                int pDay = calendar.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month + 1;
                        String date = year + "/" + month + "/" + dayOfMonth;
                        datePickerText.setText(date);
                    }
                }, pYear, pMonth, pDay);
                datePickerDialog.show();
            }
        });

        final EditText edt = (EditText) rootView.findViewById(R.id.object_name);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //입력된 문자열 얻어오기
                String ed = edt.getText().toString();
                //입력된 유통기한 가져오기
                String date = datePickerText.getText().toString();

                String str = ed + "\n유통기한 : " + date;
                //입력된 값을 ArrayList에 추가하기
                list.add(str);
                //모델 객체가 변경되었음을 adapterview에 알리기
                adapter.notifyDataSetChanged();
                edt.setText("");
                datePickerText.setText("");
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SparseBooleanArray sbArray = listView.getCheckedItemPositions();
                Log.d("MainActivity", sbArray.toString());

                if (sbArray.size() != 0) {
                    //목록의 역순으로 순화하면서 항목 제거
                    for (int i = listView.getCount() - 1; i >= 0; i--) {
                        if (sbArray.get(i)) {
                            list.remove(i);
                        }
                    }
                    listView.clearChoices();
                    adapter.notifyDataSetChanged();
                }
            }
        });


        return rootView;
    }

}

