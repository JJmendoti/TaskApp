package com.example.taskapp;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;

public class createActivity extends BaseActivity {

    FloatingActionButton fab_create, fab_clear, fab_back;
    EditText et_create_title , et_create_description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        super.init();
        init();
        fab_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToList();
            }
        });

        fab_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    protected void init(){
        fab_back = findViewById(R.id.fab_back);
        fab_clear = findViewById(R.id.fab_clear);
        fab_create = findViewById(R.id.fab_create);
        et_create_title = findViewById(R.id.et_create_title);
        et_create_description = findViewById(R.id.et_create_description);
    }
}