package com.example.taskapp;

import android.os.Bundle;

import com.example.taskapp.models.TasksModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class DetailActivity extends BaseActivity {

    private FloatingActionButton fab_detail_list;

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
            makeSimpleAlertDialog("Succcess", "Model : " + model.getTitulo());
            Bundle bundle = new Bundle();
            bundle.putSerializable("model", model);
            DetailFragmentTask.receptionData(bundle);

        }else{
            makeSimpleAlertDialog("Error", "Modelo Vacio" );
        }
        fab_detail_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToList();
            }
        });
    }
    protected void init(){
     fab_detail_list= findViewById(R.id.fab_detail_list);

    }
}