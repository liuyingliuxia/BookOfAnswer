package com.zeasn.bookofanswer;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.jeremyliao.liveeventbus.LiveEventBus;
import com.zeasn.bookofanswer.databinding.ActivityMainBinding;
import com.zeasn.bookofanswer.databinding.DialogAnswerBinding;

import java.util.Random;

public class AnswerDialog extends Dialog {

    View view;
    Context mContext;
    LayoutInflater inflater;
    Random random;
    private DialogAnswerBinding dialogAnswerBinding;
    static final String EVENT_TYPE_DIALOG_DISMISS = "EVENT_TYPE_DIALOG_DISMISS";
    public AnswerDialog(@NonNull Context context) {
        super(context, R.style.custom_dialog);
        this.mContext = context;
        this.inflater = ((Activity) context).getLayoutInflater();
        initView();
    }

    private void initView() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogAnswerBinding = DialogAnswerBinding.inflate(inflater);
        view = dialogAnswerBinding.getRoot();
        setContentView(view);
        setFullScreen();
        random = new Random();
        dialogAnswerBinding.tvAnswer.setText(Answer.dazs[random.nextInt(Answer.dazs.length)]);
        dialogAnswerBinding.btnOk.setOnClickListener(v->{
            dismiss();
            dialogAnswerBinding.tvAnswer.setText(Answer.dazs[random.nextInt(Answer.dazs.length)]);
            LiveEventBus.get(EVENT_TYPE_DIALOG_DISMISS).post(EVENT_TYPE_DIALOG_DISMISS);
        });
    }

    /**
     * 非全屏时约束布局设定的宽高比无法生效,会无法显示
     */
    protected void setFullScreen() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        getWindow().setGravity(Gravity.CENTER);
        Display display = getWindow().getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.height = (display.getHeight()); //设置宽度
        lp.width = (display.getWidth()); //设置宽度
        getWindow().setAttributes(lp);
    }

}
