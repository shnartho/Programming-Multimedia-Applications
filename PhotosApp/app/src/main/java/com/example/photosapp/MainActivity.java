package com.example.photosapp;

import android.os.Environment;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    CollapsingToolbarLayout toolbarLayout;
    GridView gridView;

    private File[] files;
    private String[] filesPaths;
    private String[] filesNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Check for SD Card
        if (!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            Toast.makeText(this, "Error! No SDCARD Found!", Toast.LENGTH_LONG).show();
        } else {
            File dirDownload = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            if (dirDownload.isDirectory()) {
                files = dirDownload.listFiles();
                filesPaths = new String[files.length];
                filesNames = new String[files.length];

                for (int i = 0; i < files.length; i++) {
                    filesPaths[i] = files[i].getAbsolutePath();
                    filesNames[i] = files[i].getName();
                }
            }
        }

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_android_layout);
        toolbarLayout.setTitle("Photo gallery");

        gridView = (GridView) findViewById(R.id.grid);
        gridView.setAdapter(new PhotoAdapter(this, filesNames, filesPaths));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), filesNames[position], Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_email:
                Toast.makeText(this, "EMail", Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
        return true;
    }
}