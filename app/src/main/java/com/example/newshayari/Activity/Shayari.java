package com.example.newshayari.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.newshayari.Apdter.expand1Adpter;
import com.example.newshayari.Apdter.expandAdpter;
import com.example.newshayari.R;
import com.example.newshayari.config;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.Random;

public class Shayari extends AppCompatActivity {

        ImageView pencil,pre,next,copy,share,expand1,reload1;
        TextView textView,title;
        String[] arr;
        int shayripos;
        GridView gridView;
        LinearLayout linearLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shayari);

        pencil = findViewById(R.id.pencil1);
        textView = findViewById(R.id.text);
        title = findViewById(R.id.title);
        pre = findViewById(R.id.previous_btn);
        next = findViewById(R.id.next_btn);
        copy = findViewById(R.id.copy);
        share = findViewById(R.id.share);
        expand1 = findViewById(R.id.expand1);
        reload1 = findViewById(R.id.reload1);
        linearLayout = findViewById(R.id.linearlayout1);

        pencil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Shayari.this, pencill.class);
                textView.setText(arr[shayripos]);
                intent.putExtra("shayari",textView.getText().toString());
                startActivity(intent);
            }
        });

        shayripos = getIntent().getIntExtra("pos",0);
        arr =  getIntent().getStringArrayExtra("arr");


        textView.setText(arr[shayripos]);
        title.setText((shayripos+1)+"/"+arr.length);


        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                       if(shayripos>0){
                           shayripos--;
                           textView.setText(arr[shayripos]);
                           title.setText((shayripos+1)+"/"+arr.length);
                       }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             if (shayripos< arr.length-1){
                 shayripos++;
                 textView.setText(arr[shayripos]);
                 title.setText((shayripos+1)+"/"+arr.length);
             }
            }
        });

            copy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                    ClipData clip = ClipData.newPlainText("label", arr[shayripos]);
                    clipboard.setPrimaryClip(clip);
                    Toast.makeText(Shayari.this, "copied", Toast.LENGTH_SHORT).show();
                }
            });

            share.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    String shareSubText = "WhatsApp - The Great Chat App";
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubText);
                    startActivity(Intent.createChooser(shareIntent, "Share"));
                }
            });

            expand1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(Shayari.this);
                    view = LayoutInflater.from(Shayari.this).inflate(R.layout.expand_layout,null);
                     gridView = view.findViewById(R.id.grid_expand);

                    expand1Adpter e1 = new expand1Adpter(Shayari.this);
                    gridView.setAdapter(e1);

                    bottomSheetDialog.setContentView(view);
                    bottomSheetDialog.show();

                    gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                linearLayout.setBackgroundResource(config.gradients[i]);
                                bottomSheetDialog.dismiss();
                        }
                    });

                }
            });

        reload1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int min = 0;
                int max = config.gradients.length;
                int random = new Random().nextInt(max-min) + min;
                linearLayout.setBackgroundResource(config.gradients[random]);
            }
        });


    }
    }
