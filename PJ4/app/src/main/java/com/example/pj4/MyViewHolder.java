package com.example.pj4;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder  extends RecyclerView.ViewHolder {
    // RecyclerView의 각 아이템에 표시될 텍스트를 담당하는 TextView.
    public TextView itemText;

    public MyViewHolder(View view) {
        // View 객체 인자는 RecyclerView의 각 아이템 뷰
        // super(view)를 통해 부모 클래스인 RecyclerView.ViewHolder의 생성자를 호출.
        // 이렇게 해서 ViewHolder가 해당 아이템 뷰를 관리할 수 있다.
        super(view);
        // view.findViewById(R.id.item_text)로 itemText 멤버 변수 초기화.
        // RecyclerView의 각 아이템에 표시될 TextView를 참조.
        itemText = view.findViewById(R.id.item_text);
    }
}
// RecyclerView의 각 아이템에 대한 뷰 홀더의 역할 수행.
// 이 뷰 홀더는 RecyclerView의 각 아이템에 표시되는 UI 컴포넌트 (TextView 등)를 관리,
// 데이터 바인딩을 수행하는 MyAdapter 클래스에서 사용 됨.