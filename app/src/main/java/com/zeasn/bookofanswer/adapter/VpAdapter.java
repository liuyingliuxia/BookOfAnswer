package com.zeasn.bookofanswer.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zeasn.bookofanswer.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Miracle.Lin
 * @Date:2021/11/3
 * @Desc:
 */
public class VpAdapter extends RecyclerView.Adapter<PagerViewHolder> {
    List<String> list= new ArrayList<>();
    String[] colors = {"#FF00CC","#41F1E5","#8D41F1","#FF99CC"};
    public VpAdapter() {
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
    }

    @NonNull
    @Override
    public PagerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_page, parent, false);
        return new PagerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PagerViewHolder holder, int position) {
        holder.tv.setText(list.get(position));
        holder.tv.setBackgroundColor(Color.parseColor(colors[position]));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
class PagerViewHolder extends RecyclerView.ViewHolder{

    public TextView tv;
    public PagerViewHolder(@NonNull View itemView) {
        super(itemView);
        tv=itemView.findViewById(R.id.tv_text);
    }
}