package com.zeasn.bookofanswer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;

import com.jeremyliao.liveeventbus.LiveEventBus;
import com.zeasn.bookofanswer.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    AnswerDialog answerDialog;
    private Handler handler = new Handler(Looper.myLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                //加载动画
                binding.btnClick.setVisibility(View.INVISIBLE);
                binding.lottieLoading.setVisibility(View.VISIBLE);
                binding.lottieLoading.playAnimation();
            } else if (msg.what == 1) {
                //停止动画，还原按钮 reset
                binding.btnClick.setVisibility(View.VISIBLE);
                binding.lottieLoading.cancelAnimation();
                binding.lottieLoading.setVisibility(View.INVISIBLE);
            } else if (msg.what == 2) {
                //结果弹窗
                binding.btnClick.setVisibility(View.INVISIBLE);
                binding.lottieLoading.cancelAnimation();
                binding.lottieLoading.setVisibility(View.INVISIBLE);
                if (!answerDialog.isShowing())
                    answerDialog.show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.lottieBg.playAnimation();
        answerDialog = new AnswerDialog(this);
        binding.btnClick.requestFocus();
        binding.btnClick.setOnClickListener(v -> {
            LogUtil.d("YOU CLICK BUTTON ... ");
            handler.sendEmptyMessage(0);
            handler.sendEmptyMessageDelayed(2, 3000);
        });
        LiveEventBus.get(AnswerDialog.EVENT_TYPE_DIALOG_DISMISS, String.class).observe(this, string ->
                handler.sendEmptyMessage(1));
    }
}