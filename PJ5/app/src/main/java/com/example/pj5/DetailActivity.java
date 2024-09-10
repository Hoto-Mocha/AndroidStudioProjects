package com.example.pj5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    private EditText editTextDetail;
    private Button btnEdit;
    private Button btnDelete;
    private Button btnReturn;
    private int index;

    private MyAdapter adapter;

    private void returnToMain() {
        Intent intent = new Intent(DetailActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        editTextDetail = findViewById(R.id.editTextDetail);
        btnEdit = findViewById(R.id.btnEdit);
        btnDelete = findViewById(R.id.btnDelete);
        btnReturn = findViewById(R.id.btnReturn);
        index = getIntent().getIntExtra("index", 0);

        adapter = new MyAdapter(MainActivity.itemList);

        String todoTitle = getIntent().getStringExtra("todoTitle");
        editTextDetail.setText(todoTitle);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.changeItem(index, editTextDetail.getText().toString());
                returnToMain();
                Toast.makeText(v.getContext(), "변경 완료", Toast.LENGTH_SHORT).show();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.removeItem(index);
                returnToMain();
                Toast.makeText(v.getContext(), "삭제 완료", Toast.LENGTH_SHORT).show();
            }
        });

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnToMain();
            }
        });
    }
}