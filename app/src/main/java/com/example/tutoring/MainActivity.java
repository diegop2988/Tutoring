package com.example.tutoring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText Edit_Name = findViewById(R.id.Edit_Name);
        final EditText Edit_Position = findViewById(R.id.Edit_Position);

        Button btn = findViewById(R.id.Submit_Button);
        DAOemployee dao = new DAOemployee();
        btn.setOnClickListener(v->
        {
           Employee emp = new Employee(Edit_Name.getText().toString(),Edit_Position.getText().toString());
            dao.add(emp).addOnSuccessListener(suc->
            {
                Toast.makeText(this, "Record is inserted", Toast.LENGTH_SHORT).show();

            }).addOnFailureListener(er ->
            {
                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
            });

            HashMap<String,Object> hashMap = new HashMap<>();
            hashMap.put("name",Edit_Name.getText().toString());
            hashMap.put("position",Edit_Position.getText().toString());
            dao.update("-NHloWZqZPKPO89BxDfA", hashMap).addOnSuccessListener(suc->
            {
                Toast.makeText(this, "Record is updated", Toast.LENGTH_SHORT).show();

            }).addOnFailureListener(er ->
            {
                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
            });
            dao.remove("-NHloWZqZPKPO89BxDfA").addOnSuccessListener(suc->
            {
                Toast.makeText(this, "Record is removed", Toast.LENGTH_SHORT).show();

            }).addOnFailureListener(er ->
            {
                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
            });





         });

        Button btn_open = findViewById(R.id.Open_Button);
        btn_open.setOnClickListener(v->
        {
            Intent intent = new Intent( MainActivity.this, RVActivity.class);
            startActivity(intent);

        });






    }
}