package com.example.newshayari.Apdter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

import com.example.newshayari.Activity.Shayari;
import com.example.newshayari.Activity.pencill;
import com.example.newshayari.R;
import com.example.newshayari.config;

public class expandAdpter extends BaseAdapter
{
    pencill pencill;
    public expandAdpter(pencill pencill) {
        this.pencill = pencill;
    }


    @Override
    public int getCount() {
        return config.gradients.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(pencill).inflate(R.layout.extra_expand_item,viewGroup,false);
        LinearLayout linearLayout = view.findViewById(R.id.view12);
        linearLayout.setBackgroundResource(config.gradients[i]);
        return view;
    }
}
