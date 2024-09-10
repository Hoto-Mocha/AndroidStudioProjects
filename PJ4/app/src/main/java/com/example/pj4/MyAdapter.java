package com.example.pj4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    // RecyclerView에 표시될 데이터 리스트
    private List<Post> itemList;

    public MyAdapter(List<Post> itemList) {
        // 생성자에서는 itemList를 초기화
        // MyAdapter 객체 생성 시 데이터 목록 인자 전달 받음.
        this.itemList = itemList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //  메서드는 새로운 뷰 홀더 객체를 생성
        // LayoutInflater를 사용하여 item_layout.xml 레이아웃을 올립니다.
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
        // 인플레이트된 뷰를 이용하여 MyViewHolder 객체를 생성하고 반환
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // 뷰 홀더에 데이터를 바인딩
        // itemList에서 해당 포지션의 아이템을 가져와 MyViewHolder의 itemText에 설정.
        String item = itemList.get(position).getTitle();
        holder.itemText.setText(item);
    }

    @Override
    public int getItemCount() {
        // RecyclerView에 표시될 아이템의 총 개수를 반환.
        return itemList.size();
    }
}