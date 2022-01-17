package com.example.a6_recyclerview_inside_nestedscrollview_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.a6_recyclerview_inside_nestedscrollview_java.adapter.CustomAdapter;
import com.example.a6_recyclerview_inside_nestedscrollview_java.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
        private Context context;
        private NestedScrollView nestedScrollView;
        private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

       List<Member> members = prepareMemberList();
       refreshAdapter(members);
    }

    private void initViews() {
        nestedScrollView = findViewById(R.id.nestedScrollView);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));
    }
    private void refreshAdapter(List<Member> members) {
        CustomAdapter adapter = new CustomAdapter(context,members);
        recyclerView.setAdapter(adapter);
//        recyclerView.setNestedScrollingEnabled(false);

    }

    private List<Member> prepareMemberList() {
        List<Member> members = new ArrayList<>();
        members.add(new Member());

        for(int i = 0; i<13; i++){
            members.add(new Member("Sarvarbek"+i,"Khalmatov"+i));
        }
        return members;
    }

}