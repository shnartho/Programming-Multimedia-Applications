package com.example.galleryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PackageManagerCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.Slide;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    GalleryAdapter galleryAdapter;
    List<String> images;
    TextView gallery_number;

    private static final int My_READ_PERMISSION_CODE = 101;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gallery_number = findViewById(R.id.gallery_number);
        recyclerView = findViewById(R.id.recyclerview_gallery_images);

        //
        if(ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, My_READ_PERMISSION_CODE );
        } else {
            loadImages();
        }
    }


    private void loadImages(){
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        images = ImageGallery.listOfImages(this);
        galleryAdapter = new GalleryAdapter(this, images, new GalleryAdapter.PhotoListener() {
            @Override
            public void onPhotoClick(String path, int position) {
                File f = new File(path);
                Uri imageUri = Uri.fromFile(f);

                Toast.makeText(MainActivity.this, ""+position, Toast.LENGTH_SHORT).show();
                Intent fullScreenIntent =new Intent(MainActivity.this , FullScreen.class);
                fullScreenIntent.putExtra("imageLocation", path);
                fullScreenIntent.putExtra("pos", position);


                fullScreenIntent.setData(imageUri);
                startActivity(fullScreenIntent);

            }
        });

        recyclerView.setAdapter(galleryAdapter);
        gallery_number.setText("Photos ("+images.size()+")");


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == My_READ_PERMISSION_CODE){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Welcome to GalleryApp", Toast.LENGTH_SHORT).show();
                loadImages();
            } else {
                Toast.makeText(this, "Sorry! Permission is required", Toast.LENGTH_SHORT).show();
            }
        }

    }
}