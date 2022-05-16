package hcmute.G7.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hcmute.G7.Model.Food;
import hcmute.G7.R;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {
    Context context;
    List<Food> foodList;
    public FoodAdapter(Context context, List<Food> foodList) {
        this.context = context;
        this.foodList = foodList;
    }



    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.food, parent, false);
        return new FoodAdapter.FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        String name = foodList.get(position).getName();
        int img = foodList.get(position).getImg();
        int price = foodList.get(position).getPrice();

        holder.foodImage.setImageResource(img);
        holder.foodName.setText(name);
        holder.foodPrice.setText(String.valueOf(price));

    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public static final class FoodViewHolder extends RecyclerView.ViewHolder {

        ImageView foodImage;
        TextView foodName;
        TextView foodPrice;


        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            foodImage = itemView.findViewById(R.id.food_image);
            foodName = itemView.findViewById(R.id.food_name);
            foodPrice = itemView.findViewById(R.id.food_price);


        }


    }
}
