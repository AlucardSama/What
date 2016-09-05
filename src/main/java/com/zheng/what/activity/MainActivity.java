package com.zheng.what.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.zheng.what.R;
import com.zheng.what.adapter.MyPagerAdapter;
import com.zheng.what.fragment.BaseFragment;
import com.zheng.what.fragment.CaijingNewsFragment;
import com.zheng.what.fragment.GuojiNewsFragment;
import com.zheng.what.fragment.GuoneiNewsFragment;
import com.zheng.what.fragment.JunshiNewsFragment;
import com.zheng.what.fragment.KejiNewsFragment;
import com.zheng.what.fragment.ShehuiNewsFragment;
import com.zheng.what.fragment.ShishangNewsFragment;
import com.zheng.what.fragment.TiyuNewsFragment;
import com.zheng.what.fragment.TopNewsFragment;
import com.zheng.what.fragment.YuleNewsFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TabLayout tlMain;
    private ViewPager vpMain;
    private String [] mTitles={"头条","社会","国内","国际","娱乐","体育","军事","科技","财经","时尚"};
    private List<BaseFragment> mFragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //indicator
        tlMain= (TabLayout) findViewById(R.id.tl_main);

        //viewpager
        vpMain= (ViewPager) findViewById(R.id.vp_main);

        //初始化fragment
        mFragmentList=new ArrayList<>();

        BaseFragment topNewsFragment= TopNewsFragment.newInstance();
        mFragmentList.add(topNewsFragment);

        BaseFragment shehuiNewsFragment= ShehuiNewsFragment.newInstance();
        mFragmentList.add(shehuiNewsFragment);

        BaseFragment guineiNewsFragment= GuoneiNewsFragment.newInstance();
        mFragmentList.add(guineiNewsFragment);

        BaseFragment guojiNewsFragment= GuojiNewsFragment.newInstance();
        mFragmentList.add(guojiNewsFragment);

        BaseFragment yuleNewsFragment= YuleNewsFragment.newInstance();
        mFragmentList.add(yuleNewsFragment);

        BaseFragment tiyuNewsFragment= TiyuNewsFragment.newInstance();
        mFragmentList.add(tiyuNewsFragment);

        BaseFragment junshiNewsFragment= JunshiNewsFragment.newInstance();
        mFragmentList.add(junshiNewsFragment);

        BaseFragment kejiNewsFragment= KejiNewsFragment.newInstance();
        mFragmentList.add(kejiNewsFragment);

        BaseFragment caijingNewsFragment= CaijingNewsFragment.newInstance();
        mFragmentList.add(caijingNewsFragment);

        BaseFragment shishangNewsFragment= ShishangNewsFragment.newInstance();
        mFragmentList.add(shishangNewsFragment);

        MyPagerAdapter myPagerAdapter=new MyPagerAdapter(getSupportFragmentManager(),mTitles,mFragmentList);
        vpMain.setAdapter(myPagerAdapter);

        tlMain.setupWithViewPager(vpMain);


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("What");
            builder.setMessage("Material Dialog");
            builder.setPositiveButton("确定", null);
            builder.setNegativeButton("取消", null);
            builder.show();
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }





}
