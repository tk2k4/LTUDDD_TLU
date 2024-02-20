package com.example.spfood.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.spfood.Adapter.CategoryAdapter;
import com.example.spfood.Adapter.RecommendedAdapter;
import com.example.spfood.Domain.CategoryDomain;
import com.example.spfood.Domain.FoodDomain;
import com.example.spfood.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerViewCategoryList, recyclerViewPopularList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategoryList();
        recyclerViewPopularList();
        bottomNavigation();

    }

    private void bottomNavigation() {
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout cartBtn = findViewById(R.id.cartBtn);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });
        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CartActivity.class));
            }
        });
    }

    private void recyclerViewPopularList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList = findViewById(R.id.view2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodList = new ArrayList<>();
        foodList.add(new FoodDomain("Bánh mỳ kẹp thịt", "banhmi", "Chiếc bánh mỳ nóng hổi, lớp vỏ bên ngoài giòn tan khiến bạn không thể chờ đợi để cắn vào. Ruột bánh mềm mịn và đỉnh của sự hòa quyện này là lớp thịt nướng đậm đà, thơm phức. Đó chính là hương vị của sự hài hòa, kết hợp, tạo nên một trải nghiệm ẩm thực độc đáo.", 20.000, 5, 15, 500));
        foodList.add(new FoodDomain("Phở bò", "pho", "Phở là một món ăn truyền thống của Việt Nam. Nước của phở bò được nấu bằng xương bò trong nhiều giờ, nước dùng trong và ngọt. Bánh dẻo mà không nát, gia vị của phở là hành lá, hạt tiêu, giấm ớt, lát chanh thái cùng với đó là những miếng thịt bò. ", 15.20, 4, 10, 483));
        foodList.add(new FoodDomain("Bún đậu mắm tôm", "bun_dau_mam_tom", "Bún đậu mắm tôm gồm có bún tươi, đậu hũ chiên vàng, chả cốm, thịt luộc, nem chua,dồi chó, mắm tôm pha chanh, ớt và ăn kèm với các loại rau thơm như tía tô, kinh giới, rau húng, xà lách. Chỉ cần thưởng thức một phần bún như vậy, đây sẽ là một bữa ăn ngon, rẻ và trọn vẹn", 14.0, 3, 16, 465));

        adapter2 = new RecommendedAdapter(foodList);
        recyclerViewPopularList.setAdapter(adapter2);
    }

    private void recyclerViewCategoryList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList = findViewById(R.id.view1);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList = new ArrayList<>();
        categoryList.add(new CategoryDomain("Pizza", "cat_1"));
        categoryList.add(new CategoryDomain("Burger", "cat_2"));
        categoryList.add(new CategoryDomain("Hotdog", "cat_3"));
        categoryList.add(new CategoryDomain("Drink", "cat_4"));
        categoryList.add(new CategoryDomain("Donut", "cat_5"));

        adapter = new CategoryAdapter(categoryList);
        recyclerViewCategoryList.setAdapter(adapter);
    }
}
