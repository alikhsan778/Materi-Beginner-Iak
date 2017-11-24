package com.example.android.recycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Axioo on 06/05/2017.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    private List<ItemObject> itemList;
    private Context context;
    /**TODO = constructor*/
    public RecyclerViewAdapter(Context context, List<ItemObject>itemList) {
       this.itemList = itemList;
        this.context = context;
    }
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_list, null);
        RecyclerViewHolder rcv = new RecyclerViewHolder(layoutView);
        return rcv;
    }
    /**TODO = method extend recyclerView*/
    @Override
    public void onBindViewHolder(RecyclerViewHolder holder,int position){
        holder.countryName.setText(itemList.get(position).getName());
        holder.countryPhoto.setImageResource(itemList.get(position).getPhoto());
    }
    @Override
    public int getItemCount(){
        return this.itemList.size();
    }


}
