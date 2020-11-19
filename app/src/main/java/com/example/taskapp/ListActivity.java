package com.example.taskapp;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ListView;

public class ListActivity extends BaseActivity {
    private  FloatingActionButton fab_list_create;
    private ListView lv_list_taks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        super.init();
        init();
        fab_list_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToCreate();
            }
        });
    }
    protected void init(){
        fab_list_create = findViewById(R.id.fab_list_create);
        lv_list_taks = findViewById(R.id.lv_list_taks);
    }
}