package com.zeasn.bookofanswer.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.zeasn.bookofanswer.ui.fragments.BookOfAnswerFragment;
import com.zeasn.bookofanswer.ui.fragments.EatWhatFragment;
import com.zeasn.bookofanswer.ui.fragments.SimulateLifeFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: Miracle.Lin
 * @Date:2021/11/4
 * @Desc:
 */
public class MyFragmentStateAdapter extends FragmentStateAdapter {

    final static ArrayList<Fragment> fragmentsList = new ArrayList<Fragment>();

    public MyFragmentStateAdapter(@NonNull FragmentActivity fragmentActivity , List<Fragment> fragmentList ) {
        super(fragmentActivity);
    }

    public MyFragmentStateAdapter(@NonNull FragmentActivity fragmentActivity ) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
//        fragmentsList.add(new BookOfAnswerFragment());
//        fragmentsList.add(new EatWhatFragment());
//        fragmentsList.add(new BookOfAnswerFragment());
//        fragmentsList.add(new EatWhatFragment());
//        return fragmentsList.get(position);
        return FragmentFactory.getFragment(position);
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public static class FragmentFactory {
        private static HashMap<Integer, Fragment> savedFragment = new HashMap<Integer, Fragment>();
        public static Fragment getFragment(int position) {
            Fragment fragment = savedFragment.get(position);
            if (fragment == null) {
                switch (position) {
                    case 0:
                        fragment = new BookOfAnswerFragment();
                        break;
                    case 1:
                        fragment = new EatWhatFragment();
                        break;
                    case 2:
                        fragment = new BookOfAnswerFragment();
                        break;
                    case 3:
                        fragment = new SimulateLifeFragment();
                        break;
                    default:break;
                }
                savedFragment.put(position, fragment);
            }
            return fragment;
        }
    }

}