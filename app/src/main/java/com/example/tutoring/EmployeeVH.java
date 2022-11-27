package com.example.tutoring;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EmployeeVH extends RecyclerView.ViewHolder
{
    public TextView txt_name,txt_position;
    public EmployeeVH(@NonNull View itemView)
    {
        super(itemView);
        txt_name= itemView.findViewById(R.id.name);
        txt_position = itemView.findViewById(R.id.txt_position);

    }
}
