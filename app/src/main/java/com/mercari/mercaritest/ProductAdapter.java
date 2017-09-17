package com.mercari.mercaritest;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mercari.mercaritest.data.model.Response;
import com.squareup.picasso.Picasso;

/**
 * Created by girish on 09/16/2017.
 */

public class ProductAdapter extends RecyclerView.Adapter<ItemViewHolder>{

    Activity activity;
    Response responseData;
    ItemViewHolder itemViewHolder;

    public ProductAdapter(Activity activity,
                          Response responseData) {
        this.activity = activity;
        this.responseData = responseData;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout, parent, false);
        itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        if(responseData.getData().get(position).getStatus().equals("sold_out")){
            holder.soldOut.setVisibility(View.VISIBLE);
        }else {
            holder.soldOut.setVisibility(View.GONE);
        }

        Picasso.with(activity)
                .load(responseData.getData().get(position).getPhoto())
                .resize(50, 50)
                .error(activity.getResources().getDrawable(R.drawable.item_price_background))
                .into(holder.productImage);

        holder.priceValue.setText("$"+String.valueOf(responseData.getData().get(position).getPrice()));
        holder.productName.setText(responseData.getData().get(position).getName());

    }

    @Override
    public int getItemCount() {
        return responseData.getData().size();
    }

}
