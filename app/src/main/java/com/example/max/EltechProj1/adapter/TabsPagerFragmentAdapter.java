package com.example.max.EltechProj1.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.max.EltechProj1.fragment.ExampleFragment;

import java.util.Calendar;

public class TabsPagerFragmentAdapter extends FragmentStatePagerAdapter{

    private String [] tabs;
    private int week = (Calendar.getInstance().getWeekYear()%2);

    public void setWeek(int week) {
        this.week = week;
    }

    public int getWeek() {
        return week;
    }

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
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }

    public Fragment getItem(int position) {
       return ExampleFragment.newInstance(position,week);
    }

    public void updateData(int week){
        this.week = week;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return tabs.length;
    }
}
