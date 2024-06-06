package com.gachon.apptest3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private HomeFragment homeFragment = new HomeFragment();
    private SaleFragment saleFragment = new SaleFragment();
    private ChatFragment chatFragment = new ChatFragment();
    private MyPageFragment myPageFragment = new MyPageFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.menu_frame_layout, homeFragment).commitAllowingStateLoss();

        BottomNavigationView bottomNavigationView = findViewById(R.id.menu_bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new ItemSelectedListener());


    }

    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener{
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem){
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch (menuItem.getItemId()){
                case  R.id.page_home:
                    transaction.replace(R.id.menu_frame_layout, homeFragment).commitAllowingStateLoss();
                    break;
                case R.id.page_sale:
                    transaction.replace(R.id.menu_frame_layout, saleFragment).commitAllowingStateLoss();
                    break;
                case R.id.page_chat:
                    transaction.replace(R.id.menu_frame_layout, chatFragment).commitAllowingStateLoss();
                    break;
                case R.id.page_myPage:
                    transaction.replace(R.id.menu_frame_layout, myPageFragment).commitAllowingStateLoss();
                    break;
            }
            return true;
        }
    }
}