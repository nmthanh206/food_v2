package hcmute.G7.Adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import hcmute.G7.R;

import java.util.List;

import hcmute.G7.Model.Shop;
import hcmute.G7.View.ShopDetail;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ShopViewHolder> {
    Context context;
    List<Shop> shopList;

    public ShopAdapter(Context context, List<Shop> shopList) {
        this.context = context;
        this.shopList = shopList;
    }

    @NonNull
    @Override
    public ShopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.shop, parent, false);
        return new ShopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopViewHolder holder, int position) {
        String name=shopList.get(position).getShopName();
        String description=shopList.get(position).getDescription();
        String id=String.valueOf(shopList.get(position).getId());
        int img=shopList.get(position).getImageUrl();
        holder.shopImage.setImageResource(img);
        holder.shopName.setText(name);
        holder.shopDescription.setText(description);
        holder.shopId.setText(id);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, ShopDetail.class);
                i.putExtra("id", id);
                i.putExtra("img", img);
                i.putExtra("name", name);
                i.putExtra("description", description);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return shopList.size();
    }

    public static final class ShopViewHolder extends RecyclerView.ViewHolder {

        ImageView shopImage;
        TextView shopName;
        TextView shopDescription;
        TextView shopId;

        public ShopViewHolder(@NonNull View itemView) {
            super(itemView);
            shopImage = itemView.findViewById(R.id.shop_image);

            shopName = itemView.findViewById(R.id.shop_name);
            shopDescription = itemView.findViewById(R.id.shop_description);
            shopId = itemView.findViewById(R.id.shop_id);


        }


    }


}
