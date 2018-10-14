package com.example.max.EltechProj1;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.max.EltechProj1.adapter.TabsPagerFragmentAdapter;

public class MainActivity extends AppCompatActivity {
    private static final int LAYOUT = R.layout.activity_main;
    private TabsPagerFragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppDefault);
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);

        initToolbar();
        initNavigationView();
        InitTabs();

    }

    private void initToolbar() {

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                return false;
            }
        });

        toolbar.inflateMenu(R.menu.menu);
    }



    private void InitTabs() {
        ViewPager viewPager = findViewById(R.id.viewPager);

        adapter = new TabsPagerFragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void initNavigationView(){
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);

    }

    public void onSettingsMenuClick(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.unused_button:
                adapter.updateData(0);
                /*
                adapter.setWeek(0);
                adapter.getItem(0);*/
                break;
            case R.id.unused_button1:
                adapter.updateData(1);
                /*adapter.setWeek(1);
                adapter.getItem(0);
                */break;
        }

    }
}

