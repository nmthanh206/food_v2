package hcmute.G7.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.ArrayList;
import java.util.List;

import hcmute.G7.Adapter.ShopAdapter;
import hcmute.G7.Model.Shop;
import hcmute.G7.R;

public class Home extends AppCompatActivity {
    RecyclerView shopItemRecycler;
    EditText etSearch;
    ShopAdapter shopAdapter;
    List<Shop> shopList;
    List<Shop> initialShopList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        etSearch = (EditText) findViewById(R.id.etSearch);
        etSearch.setOnKeyListener(new View.OnKeyListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    shopList = new ArrayList<Shop>(initialShopList);;
                    shopList.removeIf(p -> !p.getShopName().toLowerCase().contains(etSearch.getText().toString().toLowerCase()));
                    setShopItemRecycler(shopList);
                    return true;
                }
                return false;
            }
        });



        shopList= new ArrayList<Shop>();
        String[] shopName = {"Hệ Thống Hanuri - Món Ăn Hàn Quốc", "Hệ Thống Mì Ý Double B", "Ford", "Sakura Việt Nam - Sushi Nhật Bản",
                "Hệ Thống Busan Korean Food",
                "Hệ Thống Làng Nướng Nam Bộ",
                "Hệ Thống No.96 - Lẩu & Nướng",
                "Bún Đậu Cô Khàn - Món Bắc Bình Dân",
                "Hệ Thống Sushi Ba Con Sóc",
                "Bami Cô Bống - Bánh Mì Chảo",
                "Hệ Thống Ốc Đào - Nguyễn Trãi",
                "Con Gà Nướng - Thành Thái",
                "Hệ Thống Sủi Cảo Thiên Thiên",
                "Hệ Thống San San - Mì Gà Quay"};

        for (int i = 1; i <= 59; i++) {
            shopList.add(new Shop(i,shopName[i%13], getResources().getIdentifier("h"+String.valueOf(i), "drawable", getPackageName()),"Ngon"));
        }
        initialShopList=new ArrayList<Shop>(shopList);

        setShopItemRecycler(shopList);
    }

    private void setShopItemRecycler(List<Shop> shopList) {

        shopItemRecycler = (RecyclerView) findViewById(R.id.shop_recycler);
        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(this);
//        layoutManager.setAlignContent(AlignContent.FLEX_START);
        layoutManager.setFlexWrap(FlexWrap.WRAP);
        layoutManager.setJustifyContent(JustifyContent.SPACE_AROUND);
        layoutManager.setAlignItems(AlignItems.FLEX_START);
        shopItemRecycler.setLayoutManager(layoutManager);
        shopAdapter = new ShopAdapter(this, shopList);
        shopItemRecycler.setAdapter(shopAdapter);

    }
}