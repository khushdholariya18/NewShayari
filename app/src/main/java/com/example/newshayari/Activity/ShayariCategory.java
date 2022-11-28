package com.example.newshayari.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.newshayari.Apdter.categoryAdpter;
import com.example.newshayari.R;
import com.example.newshayari.config;

import java.io.File;

public class ShayariCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView;
        listView =  findViewById(R.id.list);

        ActivityCompat.requestPermissions(ShayariCategory.this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE},1);

            categoryAdpter ca = new categoryAdpter(this);
            listView.setAdapter(ca);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(ShayariCategory.this,ShayriList.class);
                    intent.putExtra("pos",i);
                    startActivity(intent);
                }
            });
                }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    config.file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM)+"/cdmi");
                    if (config.file.exists()){
                        System.out.println("folder available");
                    }else {
                        System.out.println("folder not available!!");
                        if (config.file.mkdir()){
                            System.out.println("folder created");
                        }else
                        {
                            System.out.println("folder not created!!");
                        }
                    }
                }else {
                    ActivityCompat.requestPermissions(ShayariCategory.this,
                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE},1);
                    Toast.makeText(ShayariCategory.this, "Permission denied to read your External storage", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }
}