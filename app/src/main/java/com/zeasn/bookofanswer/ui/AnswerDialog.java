package com.zeasn.bookofanswer.ui;

import static com.zeasn.bookofanswer.Constant.EVENT_TYPE_DIALOG_DISMISS;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import com.jeremyliao.liveeventbus.LiveEventBus;
import com.zeasn.bookofanswer.R;
import com.zeasn.bookofanswer.bean.Answer;
import com.zeasn.bookofanswer.databinding.DialogAnswerBinding;

import java.util.Random;

/**
 * @author Administrator
 */
public class AnswerDialog extends Dialog {

    View view;
    Context mContext;
    LayoutInflater inflater;
    Random random;
    private DialogAnswerBinding dialogAnswerBinding;
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
        dialogAnswerBinding.tvAnswer.setText(Answer.ANSWER[random.nextInt(Answer.ANSWER.length)]);
        dialogAnswerBinding.btnOk.setOnClickListener(v->{
            dismiss();
            dialogAnswerBinding.tvAnswer.setText(Answer.ANSWER[random.nextInt(Answer.ANSWER.length)]);
            LiveEventBus.get(EVENT_TYPE_DIALOG_DISMISS).post(EVENT_TYPE_DIALOG_DISMISS);
        });
    }

    /**
     * 非全屏时约束布局设定的宽高比无法生效,会无法显示
     */
    protected void setFullScreen() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setGravity(Gravity.CENTER);
        Display display = getWindow().getWindowManager().getDefaultDisplay();
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        //设置宽度
        lp.height = (display.getHeight());
        //设置宽度
        lp.width = (display.getWidth());
        getWindow().setAttributes(lp);
    }

}
