package com.example.taskapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.taskapp.adapters.TasksAdapter;
import com.example.taskapp.connection.TaskConnection;
import com.example.taskapp.models.TasksModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;

public class BaseActivity extends AppCompatActivity {

    protected TasksModel model;
    protected ArrayList<TasksModel> modelArrayList;
    protected TasksAdapter adapter;

    protected FirebaseFirestore db;
    protected FirebaseAuth mAuth;

    protected Query query;
    protected CollectionReference collectionReference;
    protected CollectionReference fileReference;

    protected final String COLLECTION_NAME="taks";
    private TaskConnection FirebaseConnection;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected  void init(){
        model = new TasksModel();
        db = FirebaseConnection.connectionFirestore();
        mAuth = FirebaseConnection.connectionAuth();
        collectionReference = db.collection(COLLECTION_NAME);
    }

    protected  void makeSimpleToast(String message, int duration){
        Toast.makeText(this, message, duration).show();
    }

    protected  void makeSimpleAlertDialog(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setTitle(title);
        builder.setPositiveButton("Hecho", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    protected void goToList(){
        Intent intent = new Intent(this,ListActivity.class);
        startActivity(intent);
    }
    protected void goToCreate(){
        Intent intent = new Intent(this,createActivity.class);
        startActivity(intent);
    }
    protected void goToEdit(){
        Intent intent = new Intent(this,BaseActivity.class);
        startActivity(intent);
    }

    protected void goToSearc(){
        Intent intent = new Intent(this,BaseActivity.class);
        startActivity(intent);
    }
    protected void goToDetails(){
        Intent intent = new Intent(this,BaseActivity.class);
        startActivity(intent);
    }
}