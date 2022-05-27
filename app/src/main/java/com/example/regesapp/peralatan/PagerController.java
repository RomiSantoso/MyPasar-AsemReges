package com.example.regesapp.peralatan;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.regesapp.peralatan.fragment.AllFragment;
import com.example.regesapp.peralatan.fragment.KerusakanFragment;
import com.example.regesapp.peralatan.fragment.ProgressFragment;
import com.example.regesapp.peralatan.fragment.RiwayatFragment;

public class PagerController extends FragmentPagerAdapter {
    int no_tabs;

    public PagerController(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.no_tabs = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new AllFragment();
            case 1:
                return new KerusakanFragment();
            case 2:
                return  new ProgressFragment();
            case 3:
                return  new RiwayatFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return no_tabs;
    }
}
