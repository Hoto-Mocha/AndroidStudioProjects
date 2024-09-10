package com.example.pj5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    public static List<String> itemList = new ArrayList<>();

    // 아이템 등록/삭제 버튼
    private Button addButton, removeButton;
    private EditText editText;

    static {
        itemList.add("자바 공부하기0");
        itemList.add("운동하고 놀기0");
        itemList.add("산책하기0");
        itemList.add("밥하고 빨리하고 청소하기02");
        itemList.add("자바 공부하기02");
        itemList.add("운동하고 놀기02");
        itemList.add("산책하기02");
        itemList.add("밥하고 빨리하고 청소하기02");
        itemList.add("자바 공부하기03");
        itemList.add("운동하고 놀기03");
        itemList.add("산책하기03");
        itemList.add("밥하고 빨리하고 청소하기03");
        itemList.add("자바 공부하기1");
        itemList.add("운동하고 놀기1");
        itemList.add("산책하기1");
        itemList.add("밥하고 빨리하고 청소하기12");
        itemList.add("자바 공부하기12");
        itemList.add("운동하고 놀기12");
        itemList.add("산책하기12");
        itemList.add("밥하고 빨리하고 청소하기12");
        itemList.add("자바 공부하기13");
        itemList.add("운동하고 놀기13");
        itemList.add("산책하기13");
        itemList.add("밥하고 빨리하고 청소하기13");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        // 등록/제거 기능 구현 시 실제 ArrayList 객체로 변경.
        //itemList = Arrays.asList("Item 1", "Item 2", "Item 3", "Item 4");

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        adapter = new MyAdapter(itemList);
        recyclerView.setAdapter(adapter);

        addButton = findViewById(R.id.addButton);
        removeButton = findViewById(R.id.removeButton);

        editText = findViewById(R.id.editText);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.addItem(editText.getText().toString());
            }
        });

        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!itemList.isEmpty()) {
                    adapter.removeItem(0);
                }
            }
        });
    }
}
