package com.example.taskapp.adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.taskapp.R;
import com.example.taskapp.models.TasksModel;

import java.util.ArrayList;


public class TasksAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<TasksModel> modelArrayList;

    public TasksAdapter(Context context, ArrayList<TasksModel> modelArrayList) {
        this.context = context;
        this.modelArrayList = modelArrayList;
    }

    @Override
    public int getCount() {
        return modelArrayList.size();
    }

    @Override
    public TasksModel getItem(int position) {
        return modelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if (view == null){
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            view = layoutInflater.inflate(R.layout.tasks_list, viewGroup, false);
        }
        TextView tv_task_list_item_title = view.findViewById(R.id.tv_task_list_item_title);
        TextView tv_task_list_item_description = view.findViewById(R.id.tv_task_list_item_description);

        tv_task_list_item_title.setText(getItem(position).getTitulo());
        tv_task_list_item_description.setText(getItem(position).getDescripcion());
        return view;
    }
}
