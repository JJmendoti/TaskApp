package com.example.taskapp;

import android.os.Bundle;

import com.example.taskapp.models.TasksModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class DetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        super.init();
        init();


        model = (TasksModel) getIntent().getSerializableExtra("model");
        if (model!=null){
            makeSimpleAlertDialog("Succcess", "Model: " + model.getTitulo());

        }else{
            makeSimpleAlertDialog("Error", "Modelo Vacio" );
        }

    }
    protected void init(){

    }
}