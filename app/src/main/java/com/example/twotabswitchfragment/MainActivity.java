package com.example.twotabswitchfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckedTextView;

import com.example.twotabswitchfragment.adapter.TabPagerAdapter;
import com.example.twotabswitchfragment.bean.MarkParams;
import com.example.twotabswitchfragment.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 描述: 两个tab切换实例
 * 作者|时间: djj on 2019/6/20 0020 下午 3:08
 */
public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_un_mark)
    CheckedTextView tvUnMark;
    @BindView(R.id.tv_have_mark)
    CheckedTextView tvHaveMark;
    @BindView(R.id.view_pager)
    NoScrollViewPager viewPager;

    private List<Fragment> fragmentList;
    private TabPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        fragmentList = new ArrayList<>();
        //未批阅
        MarkParams noParams = new MarkParams();
        noParams.setMarkType(0);
        Fragment noFragment = TabCommonFragment.newInstance(noParams);
        //已批阅
        MarkParams haveParams = new MarkParams();
        haveParams.setMarkType(1);
        Fragment haveFragment = TabCommonFragment.newInstance(haveParams);

        fragmentList.add(noFragment);
        fragmentList.add(haveFragment);

        pagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(pagerAdapter);
    }

    //按钮监听操作
    @OnClick({R.id.btn_back, R.id.tv_un_mark, R.id.tv_have_mark})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                //返回
                this.finish();
                break;
            case R.id.tv_un_mark:
                tvUnMark.setChecked(true);
                tvHaveMark.setChecked(false);
                viewPager.setCurrentItem(0);
                break;
            case R.id.tv_have_mark:
                tvUnMark.setChecked(false);
                tvHaveMark.setChecked(true);
                viewPager.setCurrentItem(1);
                break;
        }
    }
}
