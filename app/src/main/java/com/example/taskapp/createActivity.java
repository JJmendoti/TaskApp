package com.example.taskapp;

import android.os.Bundle;

import com.example.taskapp.models.TasksModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.DocumentReference;

import androidx.annotation.NonNull;
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

        fab_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToList();
            }
        });
        fab_clear.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View view) { clear(); }});

        fab_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title, descripcion;
                boolean active;

                title = et_create_title.getText().toString();
                descripcion = et_create_description.getText().toString();

                if (title.isEmpty() || descripcion.isEmpty()){
                    makeSimpleAlertDialog("Info", "Por favor debe llenar todos los campos");
                }else{
                    model = new TasksModel();
                    model.setActive(true);
                    model.setDescripcion(descripcion);
                    model.setTitulo(title);

                    save(model);
                }
            }
        });
    }

    private void save(TasksModel model) {
        if (collectionReference !=null){
            collectionReference.add(model)
            .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                @Override
                public void onComplete(@NonNull Task<DocumentReference> task) {
                    if (task.isSuccessful()){
                        if (task.getResult() !=null){
                            makeSimpleAlertDialog("Success", "Taks Guardada");
                            clear();
                        }else {
                            makeSimpleAlertDialog("Warning", "Taks no guardada");
                        }

                    }else{
                        makeSimpleAlertDialog("Error", task.getException().getMessage());
                    }
                }
            });
        }else {
            makeSimpleAlertDialog("Error", "No hay conexión con la DB");
        }
    }

    protected void init(){
        fab_back = findViewById(R.id.fab_back);
        fab_clear = findViewById(R.id.fab_clear);
        fab_create = findViewById(R.id.fab_create);
        et_create_title = findViewById(R.id.et_create_title);
        et_create_description = findViewById(R.id.et_create_description);
    }

    private  void clear(){
   et_create_description.setText("");
   et_create_title.setText("");

   et_create_title.requestFocus();
        
    }
}