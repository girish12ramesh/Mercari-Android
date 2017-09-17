package com.mercari.mercaritest;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by girish on 09/16/2017.
 */

public class ItemViewHolder extends RecyclerView.ViewHolder {

    public ImageView productImage, soldOut;
    public TextView priceValue, productName;

    public ItemViewHolder(View itemView) {
        super(itemView);

        productImage = (ImageView) itemView.findViewById(R.id.image_view);
        priceValue = (TextView) itemView.findViewById(R.id.price_text);
        productName = (TextView) itemView.findViewById(R.id.product_name);
        soldOut = (ImageView) itemView.findViewById(R.id.sold);

    }

}
