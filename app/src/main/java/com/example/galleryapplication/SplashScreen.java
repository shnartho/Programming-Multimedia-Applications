package com.example.galleryapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.lang.reflect.Method;

public class SplashScreen extends AppCompatActivity {
    private File directory;
    private String[] allPath;
    @Override
    public void onCreate(Bundle saveInstaceState){
        super.onCreate(save0InstaceState);

        // load data here
        allPath = StorageUtil.getStorageDirectories(this);

        for(String path: allPath) {
            directory = new File(path);
            Method.load_Directory_Files(storage);
        }

        Intent intent = new Intent(SplashScreen.this, MainActivity.class);
        startActivity(intent);
    }
}
