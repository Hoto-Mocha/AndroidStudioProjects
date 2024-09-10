package com.example.pj5;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// MyAdapter.MyViewHolder - MyAdapter의 내부 클래스 참조.
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<String> itemList;

    public MyAdapter(List<String> itemList) {
        this.itemList = itemList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String item = itemList.get(position);
        holder.itemText.setText(item);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


    // 외부에 생성 했던 MyViewHolder 클래스를 편의상 내부 클래스로 전환.
    // 외부의 MyViewHolder 클래싀 이름은 MyViewHolderEx로 변경.
    // MyAdapter에 선언 된 itemList 변수를 바로 사용 가능.
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView itemText;

        public MyViewHolder(View view) {
            super(view);
            itemText = view.findViewById(R.id.item_text);

            // 아이템을 클릭 했을때 반응하는 이벤트 핸들러.
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), DetailActivity.class);
                    int position = getAbsoluteAdapterPosition();
                    intent.putExtra("index", position);
                    intent.putExtra("todoTitle", itemText.getText().toString());
                    v.getContext().startActivity(intent);
                }
            });

            // 아이템을 길게 눌렀을때 반응하는 이벤트 핸들러.
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int position = getAbsoluteAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        String longClickedItem = itemList.get(position);
                        Toast.makeText(v.getContext(), "Long Clicked: " + longClickedItem, Toast.LENGTH_SHORT).show();
                        return true; // 다른 이벤트 실행 차단
                    }
                    return false;
                }
            });
        }
    } // End of ViewHoder

    // 아이템 등록
    public void addItem(String newItem) {
        itemList.add(newItem);
        // 리스트에 새 요소가 추가 된것을 Adapter에  통보한다.
        notifyItemInserted(itemList.size() - 1);
    }

    // 아이템 삭제
    public void removeItem(int position) {
        itemList.remove(position);
        // 리스트에서 요소가 제거 된 것을 Adapter에 통보한다.
        notifyItemRemoved(position);
    }

    public void changeItem(int position, String newText) {
        itemList.set(position, newText);
        notifyItemChanged(position);
    }
}