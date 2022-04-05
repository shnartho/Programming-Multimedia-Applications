package com.example.galleryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FullScreen extends AppCompatActivity {

    FloatingActionButton prebuttonfab,nextbutton;
    int positionn;
    String pathh;
    List<String> myImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);

        ImageView fullScreenImageView = (ImageView) findViewById(R.id.fullScreenView);
        prebuttonfab=findViewById(R.id.previoursfabId);
        nextbutton=findViewById(R.id.nextfabId);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            positionn = bundle.getInt("pos", 0);
            pathh = bundle.getString("imageLocation");

        }

        Intent callingActivityIntent = getIntent();
        if(callingActivityIntent != null) {
            Uri imageUri = callingActivityIntent.getData();
            if (imageUri != null && fullScreenImageView != null){
                Glide.with(this).load(imageUri).into(fullScreenImageView);
            }
        }

        prebuttonfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                positionn = positionn - 1;
                if (positionn>=0) {
                    myImages = ImageGallery.listOfImages(FullScreen.this);

                    String prePath = myImages.get(positionn);
                    File f = new File(prePath);
                    Uri imageUri = Uri.fromFile(f);
                    Toast toast = Toast.makeText(FullScreen.this, "Position:"+positionn+ "   |  Path:"+prePath, Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP | Gravity.LEFT, 0,0);
                    toast.show();

                    Glide.with(FullScreen.this).load(imageUri).into(fullScreenImageView);

                }else{
                    Toast.makeText(FullScreen.this, "No previous images are available", Toast.LENGTH_SHORT).show();
                }


            }
        });


        nextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                positionn = positionn+1;

                myImages = ImageGallery.listOfImages(FullScreen.this);

                String prePath = myImages.get(positionn);
                File f = new File(prePath);
                Uri imageUri = Uri.fromFile(f);
                Toast toast = Toast.makeText(FullScreen.this, "Position:"+positionn+ "   |  Path:"+prePath, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER | Gravity.RIGHT, 0,0);
                toast.show();
                Glide.with(FullScreen.this).load(imageUri).into(fullScreenImageView);


            }
        });
    }
}