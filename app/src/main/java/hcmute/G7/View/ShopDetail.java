package hcmute.G7.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import hcmute.G7.Adapter.FoodAdapter;
import hcmute.G7.Adapter.ShopAdapter;
import hcmute.G7.Model.Food;
import hcmute.G7.Model.Shop;
import hcmute.G7.R;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShopDetail extends AppCompatActivity {

    RecyclerView foodItemRecycler;

    FoodAdapter foodAdapter;
    List<Food> foodList;
    ImageView shopImage;
    TextView shopName;
    TextView shopDescription;
    TextView shopId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_detail);
        foodList = new ArrayList<Food>();
        shopImage = findViewById(R.id.shop_image);

        shopName = findViewById(R.id.shop_name);
        shopId = findViewById(R.id.shop_id);
        shopDescription = findViewById(R.id.shop_description);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {

            String name = extras.getString("name");
            String id = extras.getString("id");
            String description = extras.getString("description");
            int img = extras.getInt("img");
            shopImage.setImageResource(img);
            shopName.setText(name);
            shopId.setText(id);
            shopDescription.setText(description);
        }
        String[] foodName = {"Cơm tấm thành", "Thịt đùi kho tiêu", "Canh rau dền thịt băm",
                "Trứng chiên nước mắm",
                "Sườn kho tiêu", "Cá lóc kho tộ", "Bầu luộc chấm trứng", "Khổ qua xào trứng", "Thịt kho trứng cút", "Khô cá lóc chiên giấm đường", "Trứng chiên hành tây", "Thịt kho gừng", "Cá mòi kho trứng ốp la"};

        for (int i = 1; i <= foodName.length; i++) {
            foodList.add(new Food(getResources().getIdentifier("h" + String.valueOf(i), "drawable", getPackageName()), foodName[i-1], getRandomNumber(27,552)));
        }


        setFoodItemRecycler(foodList);
    }

    private void setFoodItemRecycler(List<Food> foodList) {

        foodItemRecycler = (RecyclerView) findViewById(R.id.food_recycler);
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(this);
//        layoutManager.setAlignContent(AlignContent.FLEX_START);
//        layoutManager.setFlexDirection(FlexDirection.COLUMN);

        foodItemRecycler.setLayoutManager(layoutManager);
        foodAdapter = new FoodAdapter(this, foodList);
        foodItemRecycler.setAdapter(foodAdapter);

    }
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}