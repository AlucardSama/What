package com.zheng.what.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.zheng.what.fragment.BaseFragment;

import java.util.List;

/**
 * Created by zheng on 2016/9/1.
 */
public class MyPagerAdapter extends FragmentPagerAdapter {

    //private Context mContext;
    private String[] mTitles;
    private List<BaseFragment> mFragmentList;


    public MyPagerAdapter(FragmentManager fm, String[] mTitles, List<BaseFragment> mFragmentList) {
        super(fm);
        //this.mContext=context;
        this.mTitles = mTitles;
        this.mFragmentList = mFragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
}
