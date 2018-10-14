package com.example.max.EltechProj1.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.max.EltechProj1.fragment.ExampleFragment;

public class TabsPagerFragmentAdapter extends FragmentPagerAdapter {

    private String [] tabs;

    public TabsPagerFragmentAdapter(FragmentManager fm) {
        super(fm);
        tabs = new String[] {
                "Пн",
                "Вт",
                "Ср",
                "Чт",
                "Пт",
                "Сб"

        };
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return ExampleFragment.getInstance(position);
            case 1:
                return ExampleFragment.getInstance(position);
            case 2:
                return ExampleFragment.getInstance(position);
            case 3:
                return ExampleFragment.getInstance(position);
            case 4:
                return ExampleFragment.getInstance(position);
            case 5:
                return ExampleFragment.getInstance(position);
        }
        return null;
    }


    @Override
    public int getCount() {
        return tabs.length;
    }
}
