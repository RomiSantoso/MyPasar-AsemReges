package com.example.regesapp.peralatan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import com.example.regesapp.MainActivity;
import com.example.regesapp.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class PeralatanActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    TabItem t_all, t_kerusakan, t_progress, t_riwayat;
    PagerController pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peralatan);

        //BACK TO MAIN
        findViewById(R.id.back_to_main).setOnClickListener(view -> startActivity(new Intent(this, MainActivity.class)));

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        t_all = findViewById(R.id.all);
        t_kerusakan = findViewById(R.id.kerusakan);
        t_progress = findViewById(R.id.progress);
        t_riwayat = findViewById(R.id.riwayat);

        //MAKE PAGER
        pagerAdapter = new PagerController(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition() == 0){
                    pagerAdapter.notifyDataSetChanged();
                }

                if(tab.getPosition() == 1){
                    pagerAdapter.notifyDataSetChanged();
                }

                if(tab.getPosition() == 2){
                    pagerAdapter.notifyDataSetChanged();
                }

                if(tab.getPosition() == 3){
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

}