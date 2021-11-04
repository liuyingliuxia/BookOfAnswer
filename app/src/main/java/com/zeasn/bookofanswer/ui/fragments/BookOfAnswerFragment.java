package com.zeasn.bookofanswer.ui.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.zeasn.bookofanswer.R;
import com.zeasn.bookofanswer.base.BaseFragment;

/**
 * @Author: Miracle.Lin
 * @Date:2021/11/3
 * @Desc: 答案之书
 */
public class BookOfAnswerFragment extends Fragment {


//    Handler handler = new Handler(Looper.myLooper()) {
//        @Override
//        public void handleMessage(@NonNull Message msg) {
//            super.handleMessage(msg);
//            if (msg.what == 0) {
//                //加载动画
//                binding.btnClick.setVisibility(View.INVISIBLE);
//                binding.lottieLoading.setVisibility(View.VISIBLE);
//                binding.lottieLoading.playAnimation();
//            } else if (msg.what == 1) {
//                //停止动画，还原按钮 reset
//                binding.btnClick.setVisibility(View.VISIBLE);
//                binding.lottieLoading.cancelAnimation();
//                binding.lottieLoading.setVisibility(View.INVISIBLE);
//            } else if (msg.what == 2) {
//                //结果弹窗
//                binding.btnClick.setVisibility(View.INVISIBLE);
//                binding.lottieLoading.cancelAnimation();
//                binding.lottieLoading.setVisibility(View.INVISIBLE);
//                if (!answerDialog.isShowing()) {
//                    answerDialog.show();
//                }
//            }
//        }
//    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView tv  =  new TextView(getContext());
        tv.setText("Home1Fragment");
        tv.setBackgroundColor(Color.RED);
        return tv;
    }
}
