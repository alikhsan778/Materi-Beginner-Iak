package iak.example.alikhsan778.recyclerviewlist;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ASUS on 11/11/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    ItemObject mItemObject = new ItemObject();
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(rootView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mItemTitle.setText(mItemObject.mTitles[position]);
        holder.mItemDetail.setText(mItemObject.mDetails[position]);
        holder.mItemImage.setImageResource(mItemObject.mImage[position]);


    }

    @Override
    public int getItemCount() {
        return mItemObject.mTitles.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mItemImage;
        public TextView mItemTitle, mItemDetail;

        public ViewHolder(final View itemView) {
            super(itemView);
            mItemImage = itemView.findViewById(R.id.img_item);
            mItemTitle = itemView.findViewById(R.id.tv_tittle);
            mItemDetail = itemView.findViewById(R.id.tv_description);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    int customPosition = getAdapterPosition() + 1;
                    Snackbar.make(view, "Click Detected On Item : " + customPosition, Snackbar.LENGTH_LONG).show();
                }
            });
        }
    }
}
