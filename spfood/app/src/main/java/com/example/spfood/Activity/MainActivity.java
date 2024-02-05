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
private RecyclerView recyclerViewCategotyList, recyclerViewPupolarList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategotyList();
        recyclerViewPupolarList();
        bottomNavigation();

    }

    private void bottomNavigation() {
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        FloatingActionButton cartBtn = findViewById(R.id.cartBtn);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MainActivity.class));
            }
        });
        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CartActivity.class));
            }
        });
    }

    private void recyclerViewPupolarList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPupolarList = findViewById(R.id.view2);
        recyclerViewPupolarList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodlist = new ArrayList<>();
        foodlist.add(new FoodDomain("Pepperoni pizza", "pizza1", "slices peperoni, mozzarella cheese, fresh oregano,ground black pepper, pizza sauce", 13.0, 5, 20, 1000 ));
        foodlist.add(new FoodDomain("Cheese Burger", "burger", "beef, Gouda Cheese, Speccial, Lettuce, tomato", 15.20, 4, 10, 1100 ));
        foodlist.add(new FoodDomain("Vagetable pizza", "pizza3", "olve oil, Vegetablep oil, pitted Lalamata, cherry tomatoes, fresh oregano, basil", 14.0, 3, 16, 1200 ));

        adapter2 = new RecommendedAdapter(foodlist);
        recyclerViewPupolarList.setAdapter(adapter2);
    }

    private void recyclerViewCategotyList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false );
        recyclerViewCategotyList = findViewById(R.id.view1);
        recyclerViewCategotyList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList = new ArrayList<>();
        categoryList.add(new CategoryDomain("Pizza", "cat_1"));
        categoryList.add(new CategoryDomain("Burger", "cat_2"));
        categoryList.add(new CategoryDomain("Hotdog", "cat_3"));
        categoryList.add(new CategoryDomain("Drink", "cat_4"));
        categoryList.add(new CategoryDomain("Donut", "cat_5"));

        adapter = new CategoryAdapter(categoryList);
        recyclerViewCategotyList.setAdapter(adapter);
    }
}