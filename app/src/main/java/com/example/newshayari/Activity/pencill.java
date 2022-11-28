package com.example.newshayari.Activity;

import static android.graphics.Bitmap.*;
import static android.graphics.Bitmap.CompressFormat.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.newshayari.Apdter.BackgraoundAdpter;
import com.example.newshayari.Apdter.EmojiAdpter;
import com.example.newshayari.Apdter.FontAdpter;
import com.example.newshayari.Apdter.expandAdpter;
import com.example.newshayari.R;
import com.example.newshayari.config;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class pencill extends AppCompatActivity {

            TextView textView,hello;
            String text;
            Button backround,textcolor,font,emoji,share,textsize  ;
            GridView gridView;
            LinearLayout linearLayout;
            ListView listView,list_emoji;
            ImageView expand,reload,download;
            SeekBar seekBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pencil);

            textView = findViewById(R.id.hello);
            backround = findViewById(R.id.backround);
            textcolor = findViewById(R.id.textcolor);
            linearLayout = findViewById(R.id.linearlayout);
            font = findViewById(R.id.font);
            emoji = findViewById(R.id.emoji);
            share = findViewById(R.id.share1);
            expand = findViewById(R.id.expand);
            reload = findViewById(R.id.reload);
            textsize = findViewById(R.id.textsize);
            download  = findViewById(R.id.dawnload);
            hello = findViewById(R.id.hello);


            text=getIntent().getStringExtra("shayari");
            textView.setText(text);

            backround.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(pencill.this);

                    view = LayoutInflater.from(pencill.this).inflate(R.layout.backgraound_layout,null);
                    gridView = view.findViewById(R.id.gridview);

                    BackgraoundAdpter backgraoundAdpter = new BackgraoundAdpter(pencill.this);
                        gridView.setAdapter(backgraoundAdpter);

                        bottomSheetDialog.setContentView(view);
                        bottomSheetDialog.show();

                        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                linearLayout.setBackgroundColor(getResources().getColor(config.colors[i]));
                                bottomSheetDialog.setCancelable(true);
                            }
                        });
                }
            });
            textsize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(pencill.this);

                view = LayoutInflater.from(pencill.this).inflate(R.layout.textsize_layout,null);
                seekBar = view.findViewById(R.id.seekBar);
                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar s, int i, boolean b) {
                        textView.setTextSize(s.getProgress());
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
                bottomSheetDialog.setContentView(view);
                bottomSheetDialog.show();
            }
        });
            textcolor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog bottomSheetDialog1 = new BottomSheetDialog(pencill.this);
                bottomSheetDialog1.setCancelable(false);
                view = LayoutInflater.from(pencill.this).inflate(R.layout.backgraound_layout,null);
                BackgraoundAdpter backgraoundAdpter = new BackgraoundAdpter(pencill.this);
                gridView = view.findViewById(R.id.gridview);
                gridView.setAdapter(backgraoundAdpter);

                bottomSheetDialog1.setContentView(view);
                bottomSheetDialog1.show();

                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        textView.setTextColor(getResources().getColor(config.colors[i]));
                        bottomSheetDialog1.setCancelable(true);
                    }
                });
            }
        });
            font.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(pencill.this);
                    view = LayoutInflater.from(pencill.this).inflate(R.layout.font_layout,null);
                    listView =view.findViewById(R.id.list12);
                    FontAdpter fontAdpter = new FontAdpter(pencill.this);
                    listView.setAdapter(fontAdpter);


                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            Typeface typeface = Typeface.createFromAsset(getAssets(), config.fonts[i]);
                            textView.setTypeface(typeface);
                            bottomSheetDialog.dismiss();

                        }
                    });

                   bottomSheetDialog.setContentView(view);
                    bottomSheetDialog.show();
                    bottomSheetDialog.setCancelable(true);
                }
            });
            emoji.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(pencill.this);
                    bottomSheetDialog.setCancelable(false);

                        view = LayoutInflater.from(pencill.this).inflate(R.layout.emoji_layout,null);
                            listView = view.findViewById(R.id.list_emoji);

                    EmojiAdpter emojiAdpter = new EmojiAdpter(pencill.this);
                    listView.setAdapter(emojiAdpter);

                    bottomSheetDialog.setContentView(view);
                    bottomSheetDialog.show();
                        bottomSheetDialog.setCancelable(true);

                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                textView.setText(config.emoji[i]+"\n"+text+"\n"+config.emoji[i]);
                                bottomSheetDialog.dismiss();
                            }
                        });
                }
            });
            expand.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    BottomSheetDialog bottomSheetDialog1 = new BottomSheetDialog(pencill.this);

                    view = LayoutInflater.from(pencill.this).inflate(R.layout.expand_layout,null);
                    gridView = view.findViewById(R.id.grid_expand);

                    expandAdpter expandAdpter = new expandAdpter(pencill.this);
                    gridView.setAdapter(expandAdpter);

                    bottomSheetDialog1.setContentView(view);
                    bottomSheetDialog1.show();

                    gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            linearLayout.setBackgroundResource(config.gradients[i]);
                            bottomSheetDialog1.dismiss();
                        }
                    });
                }
            });
            reload.setOnClickListener(view -> {
                int min=0;
                int max=config.gradients.length;
                int random = new Random().nextInt(max-min) + min;
                linearLayout.setBackgroundResource(config.gradients[random]);
            });

            download.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Bitmap icon = getBitmapFromView(hello);
                    System.out.println("bitmap======>"+icon);

                    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                    icon.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                    int num=new Random().nextInt(2000);
                    File f = new File(config.file.getAbsolutePath()  + "/temporary_file"+num+"jpg");
                    try {
                        f.createNewFile();
                        FileOutputStream fo = new FileOutputStream(f);
                        fo.write(bytes.toByteArray());
                        Toast.makeText(pencill.this, "file downloaded", Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            });

        Bitmap mBitmap;
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap icon = getBitmapFromView(hello);
                System.out.println("bitmap======>"+icon);
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("image/jpeg");
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                icon.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                int num=new Random().nextInt(2000);
                File f = new File(config.file.getAbsolutePath()  + "/temporary_file"+num+"jpg");
                try {
                    f.createNewFile();
                    FileOutputStream fo = new FileOutputStream(f);
                    fo.write(bytes.toByteArray());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                share.putExtra(Intent.EXTRA_STREAM, Uri.parse(f.getAbsolutePath()));
                startActivity(Intent.createChooser(share, "Share Image"));
         }
        });
    }

    public static Bitmap getBitmapFromView(View view) {
        Bitmap returnedBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(returnedBitmap);
        Drawable bgDrawable =view.getBackground();
        if (bgDrawable!=null)
            bgDrawable.draw(canvas);
        else
            canvas.drawColor(Color.WHITE);
        view.draw(canvas);
        return returnedBitmap;


}
}