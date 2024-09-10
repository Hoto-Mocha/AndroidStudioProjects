package com.example.practice01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup radioGroup = findViewById(R.id.radioGroup);
                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton selectedRadio = findViewById(selectedId);
                String radioValue = selectedRadio.getText().toString();
                CheckBox checkBox = findViewById(R.id.checkBox);
                EditText editText = findViewById(R.id.editText);

                Intent intent = new Intent(MainActivity.this, NewActivity.class);
                intent.putExtra("radioChecked", radioValue);
                intent.putExtra("checkBoxChecked", checkBox.isChecked());
                intent.putExtra("text", editText.getText().toString());
                startActivity(intent);
            }
        });
    }
}