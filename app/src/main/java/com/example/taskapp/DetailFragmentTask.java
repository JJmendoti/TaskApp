package com.example.taskapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.taskapp.models.TasksModel;

public class DetailFragmentTask extends Fragment {

    private static String titulo, descripcion;
    private boolean active;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_task, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tv_detail_fragment_title, tv_detail_fragment_description;
        tv_detail_fragment_title = view.findViewById(R.id.tv_detail_fragment_title);
        tv_detail_fragment_description = view.findViewById(R.id.tv_detail_fragment_description);

        tv_detail_fragment_title.setText(titulo);
        tv_detail_fragment_description.setText(descripcion);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(DetailFragmentTask.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    static void  receptionData(Bundle bundle){
        TasksModel model = (TasksModel) bundle.getSerializable("model");
        if (model != null){
            titulo=model.getTitulo();
            descripcion=model.getDescripcion();
        }
    }
}