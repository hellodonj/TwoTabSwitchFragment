package com.example.twotabswitchfragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.twotabswitchfragment.bean.MarkParams;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 描述: 加载的tabFragment
 * 作者|时间: djj on 2019/6/20 0020 下午 3:43
 * 博客地址: http://www.jianshu.com/u/dfbde65a03fc
 */
public class TabCommonFragment extends Fragment {

    @BindView(R.id.tv_show)
    TextView tvShow;
    Unbinder unbinder;
    private MarkParams markParams;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab, container, false);
        unbinder = ButterKnife.bind(this, view);
        initArgs();
        initView();
        return view;
    }

    private void initArgs() {
        Bundle bundle = getArguments();
        if (bundle.containsKey("fragment_bundle")) {
            markParams = (MarkParams) bundle.getSerializable("fragment_bundle");
        }
    }

    private void initView() {
        if (markParams.getMarkType() == 0) {
            tvShow.setText("我是未批阅界面！");
        } else if (markParams.getMarkType() == 1) {
            tvShow.setText("已批阅界面，胜利！！！");
        }
    }


    public static Fragment newInstance(MarkParams markParams) {
        Fragment fragment = new TabCommonFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("fragment_bundle", markParams);
        fragment.setArguments(bundle);
        return fragment;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
