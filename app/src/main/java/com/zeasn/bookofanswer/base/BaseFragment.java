package com.zeasn.bookofanswer.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

/**
 * @Author: Miracle.Lin
 * @Date:2021/11/3
 * @Desc:
 */
public abstract class BaseFragment extends Fragment {
    public View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = setContent(inflater);

//        initView(view);
//        requestDataAction();
        return view;
    }

    /**
     *
     * @param inflater
     * @return
     * @describe 设置布局
     *
     *
     */
    public abstract View setContent(LayoutInflater inflater);

}


