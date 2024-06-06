package com.gachon.apptest3;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


public class SaleFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_sale, container, false);

        ArrayList<String> testDataSet = new ArrayList<>();
        for (int i = 0; i<20; i++) {
            testDataSet.add("TEST DATA" + i);
        }

        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager((Context) getActivity().getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);  // LayoutManager 설정

        ViewAdapter viewAdapter = new ViewAdapter(testDataSet);
        viewAdapter.setOnItemClickListener(new ViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClicked(int position, String data) {
                Toast.makeText(getActivity().getApplicationContext(), "Open" + data, Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(viewAdapter); // 어댑터 설정

        /*toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("판매장터");
        */

        ArrayList<String> list = new ArrayList<>();

        //toolbar

        return rootView;
    }
}