package com.example.ourzone;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ourzone.Adapter.FriendAdapter;
import com.example.ourzone.Adapter.RequestFriendAdapter;
import com.example.ourzone.Models.Item;

import java.util.ArrayList;

public class FriendActivity extends AppCompatActivity {
    private ArrayList<Item> friendItems;
    private ArrayList<Item> requestItems;
    private FriendAdapter friendAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);

        // Friend list
        RecyclerView friendRecyclerView = findViewById(R.id.recyclerview);
        friendItems = new ArrayList<>();
        createFriendItemList();

        friendAdapter = new FriendAdapter(this, friendItems);
        friendRecyclerView.setAdapter(friendAdapter);
        friendRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Request Friend
        RecyclerView requestFriendRecyclerView = findViewById(R.id.recyclerview2);
        requestItems = new ArrayList<>();
        createRequestItemList();

        RequestFriendAdapter requestFriendAdapter = new RequestFriendAdapter(this, requestItems);
        requestFriendRecyclerView.setAdapter(requestFriendAdapter);
        requestFriendRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        requestFriendAdapter.setOnAcceptClickListener(item -> friendAdapter.addItem(item));
    }

    private void createRequestItemList() {
        requestItems.add(new Item("chot chot", R.drawable.avatar1));
        requestItems.add(new Item("di thui nafo", R.drawable.avatar2));
        requestItems.add(new Item("chiu", R.drawable.avatar3));
        requestItems.add(new Item("het van", R.drawable.avatar4));
        requestItems.add(new Item("cap ", R.drawable.avatar5));
        requestItems.add(new Item("hep pi niu dia", R.drawable.avatar6));
        requestItems.add(new Item("kin cha na", R.drawable.avatar7));
        requestItems.add(new Item("nu nu", R.drawable.avatar1));
        requestItems.add(new Item("ec", R.drawable.avatar2));
        requestItems.add(new Item("eo oi", R.drawable.avatar3));
        requestItems.add(new Item("dc goi", R.drawable.avatar4));
    }

    private void createFriendItemList() {
        friendItems.add(new Item("HBT", R.drawable.avatar1));
        friendItems.add(new Item("dậy mà đi", R.drawable.avatar2));
        friendItems.add(new Item("ngủ ngon nho", R.drawable.avatar3));
        friendItems.add(new Item("ft", R.drawable.avatar4));
        friendItems.add(new Item("hè tới", R.drawable.avatar5));
        friendItems.add(new Item("ngủ thoaai", R.drawable.avatar6));
        friendItems.add(new Item("ye ya", R.drawable.avatar7));
        friendItems.add(new Item("toi oi", R.drawable.avatar1));
        friendItems.add(new Item("kem thoi", R.drawable.avatar2));
        friendItems.add(new Item("chiu", R.drawable.avatar3));
        friendItems.add(new Item("cíu", R.drawable.avatar4));
    }
}