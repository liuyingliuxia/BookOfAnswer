package com.zeasn.bookofanswer.ui;

import static com.zeasn.bookofanswer.Constant.EVENT_TYPE_DIALOG_DISMISS;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;

import com.jeremyliao.liveeventbus.LiveEventBus;
import com.youth.banner.transformer.ScaleInTransformer;
import com.zeasn.bookofanswer.R;
import com.zeasn.bookofanswer.adapter.MyFragmentStateAdapter;
import com.zeasn.bookofanswer.adapter.VpAdapter;
import com.zeasn.bookofanswer.databinding.ActivityMainBinding;
import com.zeasn.bookofanswer.utils.LogUtil;

/**
 * @author
 */
public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager2 = findViewById(R.id.main_vp2);
        btn = findViewById(R.id.btn);
//        MyAdapter myAdapter = new MyAdapter();
        //竖直滑动
//        viewPager2.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
//        viewPager2.setAdapter(myAdapter);
        // 页面滑动事件监听
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
               LogUtil.d("onPageScrolled" + +position);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                LogUtil.d("onPageSelected " + position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
                LogUtil.d("onPageScrollStateChanged  state-->" + +state);
            }
        });
        // 设置页面间距
        viewPager2.setPageTransformer(new MarginPageTransformer((int) getResources().getDimension(R.dimen.dp_10)));
        //按钮点击可以模拟用户滑动
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //禁止ViewPager2的滑动
                viewPager2.setUserInputEnabled(false);
                //拖拽,按钮点击可以模拟用户滑动
                viewPager2.beginFakeDrag();
                if (viewPager2.fakeDragBy(-310f))
                    viewPager2.endFakeDrag();
            }
        });
        // 设置页面切换动画
        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new ScaleInTransformer());
        compositePageTransformer.addTransformer(new MarginPageTransformer((int) getResources().getDimension(R.dimen.dp_10)));
        viewPager2.setPageTransformer(compositePageTransformer);
        //ViewPager2与Fragment 结合使用
        viewPager2.setAdapter(new MyFragmentStateAdapter(this));
        viewPager2.setOffscreenPageLimit(4);

    }
}