package com.example.practice01;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        TextView radioResult = findViewById(R.id.radioResult);
        TextView checkBoxResult = findViewById(R.id.checkBoxResult);
        TextView editTextResult = findViewById(R.id.editTextResult);

        radioResult.setText(getIntent().getStringExtra("radioChecked"));
        checkBoxResult.setText(getIntent().getBooleanExtra("checkBoxChecked", false) ? "체크함" : "체크 안 함");
        editTextResult.setText(getIntent().getStringExtra("text"));
    }
}