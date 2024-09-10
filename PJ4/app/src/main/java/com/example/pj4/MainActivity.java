package com.example.pj4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private List<Post> posts;

    // RecyclerView의 설정과 데이터 바인딩을 관리.
    private RecyclerView recyclerView;
    // RecyclerView에 표시될 아이템 데이터와 뷰를 연결.
    private MyAdapter adapter;
    // RecyclerView에 표시될 아이템의 데이터가 저장.
    private List<String> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        Call<List<Post>> call = apiService.getAllPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful()) {
                    posts = response.body();
                    for (Post post : posts) {
                        Log.d("RetrofitExample", "Title: " + post.getTitle());
                    }

                    // RecyclerView 관련
                    // activity_main.xml에 정의한 RecyclerView
                    recyclerView = findViewById(R.id.recyclerView);

                    // itemList 필드에 RecyclerView에 표시될 아이템 데이터를 초기화
                    // 나중에 실제로 ArrayList 객체를 new 연산자로 생성 해야 함.
                    itemList = Arrays.asList("Item 1", "Item 2", "Item 3", "Item 4");

                    // MyAdapter 생성자에 itemList를 전달하여 어댑터가 사용할 데이터를 설정
                    adapter = new MyAdapter(posts);
                    // RecyclerView의 레이아웃을 선형으로 설정
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                    // setLayoutManager 메서드를 사용하여 RecyclerView에 레이아웃 매니저를 설정.
                    recyclerView.setLayoutManager(layoutManager);
                    // setAdapter 메서드를 사용하여 RecyclerView에 어댑터를 설정.
                    // 이로써 RecyclerView는 itemList 데이터를 사용하여 아이템을 표시하게 됨.
                    recyclerView.setAdapter(adapter);
                }
            }
            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.e("RetrofitExample", "Error: " + t.getMessage());
            }
        });


    }
}