package com.zheng.what.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.zheng.what.BaseFragment;

/**
 * Created by zheng on 2016/9/1.
 */
public class MyPagerAdapter extends FragmentPagerAdapter {

    //private Context mContext;
    private String [] mTitles;

    public MyPagerAdapter(FragmentManager fm,String [] mTitles) {
        super(fm);
       //this.mContext=context;
        this.mTitles=mTitles;
    }

    @Override
    public Fragment getItem(int position) {
        return BaseFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
