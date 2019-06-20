package com.example.twotabswitchfragment.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 描述: fragment的adapter
 * 作者|时间: djj on 2019/6/20 0020 下午 2:43
 * 博客地址: http://www.jianshu.com/u/dfbde65a03fc
 */
public class TabPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;
    private String pageTitles[] = new String[]{"未批阅", "已批阅"};

    public TabPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

//    @Nullable
//    @Override
//    public CharSequence getPageTitle(int position) {
//        return pageTitles[position];
//    }
}
