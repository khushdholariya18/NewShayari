package com.example.newshayari.Apdter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.newshayari.Activity.pencill;
import com.example.newshayari.R;
import com.example.newshayari.config;

public class EmojiAdpter extends BaseAdapter {
    pencill pencill;
    public EmojiAdpter(pencill pencill) {
    this.pencill = pencill;
    }

    @Override
    public int getCount() {
        return config.emoji.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(pencill).inflate(R.layout.extra_emoji_item,viewGroup,false);

        TextView emoji_text = view.findViewById(R.id.emoji_text);

        emoji_text.setText(config.emoji[i]);
        return view;
    }
}
