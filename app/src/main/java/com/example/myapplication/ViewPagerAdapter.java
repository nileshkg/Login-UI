package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.myapplication.Fragments.SigninFragment;

import java.util.List;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    List<Fragment> fragmentList;

    public ViewPagerAdapter(@NonNull FragmentManager fm, List<Fragment> list) {
        super(fm);

        this.fragmentList = fragmentList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return 0;
    }
}
