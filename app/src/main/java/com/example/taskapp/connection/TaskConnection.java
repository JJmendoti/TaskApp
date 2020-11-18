package com.example.taskapp.connection;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class TaskConnection {
    private static FirebaseAuth mAuth;

    private static FirebaseFirestore db;


    public  static FirebaseAuth connectionAuth(){
        // Initialize Firebase Auth
       return mAuth = FirebaseAuth.getInstance();
    }

    public  static FirebaseFirestore connectionFirestore(){
        // Initialize Firebase Auth
        return  db = FirebaseFirestore.getInstance();
    }
}
