package com.example.android.recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private GridLayoutManager ILayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<ItemObject> rowListItem = getAllItemList();
        ILayout = new GridLayoutManager(MainActivity.this, 1);
        RecyclerView rView = (RecyclerView) findViewById(R.id.recycler_view);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(ILayout);
        RecyclerViewAdapter rcAdapter = new RecyclerViewAdapter(MainActivity.this, rowListItem);
        rView.setAdapter(rcAdapter);
    }

    private List<ItemObject> getAllItemList() {
        List<ItemObject> allItems = new ArrayList<ItemObject>();
        allItems.add(new ItemObject("United States", R.drawable.three));
        allItems.add(new ItemObject("United States", R.drawable.three));
        allItems.add(new ItemObject("United States", R.drawable.nigeria));
        allItems.add(new ItemObject("United States", R.drawable.nigeria));
        allItems.add(new ItemObject("United States", R.drawable.nigeria));
        allItems.add(new ItemObject("United States", R.drawable.nigeria));
        allItems.add(new ItemObject("United States", R.drawable.nigeria));
        return allItems;
    }
}
