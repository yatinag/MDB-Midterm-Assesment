package com.example.mdb_midway_instagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Adapter adapter;
    Button submitPic;
    HashMap<String, String> imageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        submitPic = findViewById(R.id.submitBtn);

        imageList = new HashMap<>();
        Intent intent = getIntent();
        String pic_path = intent.getStringExtra("pic_path");
        String pic_caption = intent.getStringExtra("pic_caption");
        imageList.put(pic_path, pic_caption);
        System.out.println(pic_path + ": " + pic_caption);
//            ImageView imageView = (ImageView) findViewById(R.id.imgView);
//            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));

        adapter = new Adapter(this, imageList);
        recyclerView.setAdapter(adapter);

        submitPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, UploadActivity.class);
                startActivity(i);
            }
        });
    }

//    private void loadImageFromStorage(String path)
//    {
//
//        try {
//            File f = new File(path, "profile.jpg");
//            Bitmap bitmap = BitmapFactory.decodeStream(new FileInputStream(f));
//            ImageView img=(ImageView)findViewById(R.id.imgPicker);
//            img.setImageBitmap(bitmap);
//        }
//        catch (FileNotFoundException e)
//        {
//            e.printStackTrace();
//        }
//
//    }
}
