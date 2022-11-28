package com.example.newshayari.Apdter;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.newshayari.Activity.pencill;
import com.example.newshayari.R;
import com.example.newshayari.config;

public class FontAdpter extends BaseAdapter {
    pencill pencill;
    public FontAdpter(pencill pencill) {
        this.pencill = pencill;
    }

    @Override
    public int getCount() {
        return config.fonts.length;
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

        view = LayoutInflater.from(pencill).inflate(R.layout.extra_font_item,viewGroup,false);
        TextView font_text = view.findViewById(R.id.font_text);

        Typeface typeface = Typeface.createFromAsset(pencill.getAssets(), config.fonts[i]);
        font_text.setTypeface(typeface);

//        font_text.setText(config.shayari_name[i]);
        return view;
    }
}
