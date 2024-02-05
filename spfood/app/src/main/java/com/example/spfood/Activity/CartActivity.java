package com.example.spfood.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spfood.Adapter.CartListAdapter;
import com.example.spfood.Helper.ManagementCart;
import com.example.spfood.Interface.ChangeNumberItemsListener;
import com.example.spfood.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CartActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    private ManagementCart managementCart;
    private TextView totalFeeTxt, taxTxT, deliveryTxT, totalTxT, emptyTxT;
    private double tax;
    private ScrollView scrollView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        managementCart = new ManagementCart(this);
        initView();
        initList();
        bottomNavigation();
    }

    private void bottomNavigation() {
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        FloatingActionButton cartBtn = findViewById(R.id.cartBtn);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartActivity.this, MainActivity.class));
            }
        });
        cartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartActivity.this, CartActivity.class));
            }
        });
    }

    private void initList() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewList.setLayoutManager(linearLayoutManager);
        adapter = new CartListAdapter(managementCart.getListCart(), this, new ChangeNumberItemsListener() {
            @Override
            public void changed() {
                calculateCard();
            }
        });

        recyclerViewList.setAdapter(adapter);
        if(managementCart.getListCart().isEmpty()) {
            emptyTxT.setVisibility(View.VISIBLE);
            scrollView2.setVisibility(View.GONE);
        }
        else {
            emptyTxT.setVisibility(View.GONE);
            scrollView2.setVisibility(View.VISIBLE);
        }
    }

    private void calculateCard() {
        double percentTax = 0.02;
        double delivery = 10;

        tax = Math.round((managementCart.getTotalFee() * percentTax) * 100.0) / 100.0;
        double total = Math.round((managementCart.getTotalFee() + tax + delivery) * 100.0) / 100;
        double itemTotal = Math.round(managementCart.getTotalFee() * 100.0) / 100.0;

        totalFeeTxt.setText("$" + itemTotal);
        taxTxT.setText("$" + tax);
        deliveryTxT.setText("$" + delivery);
        totalTxT.setText("$" + total);
    }

    private void initView() {
        totalFeeTxt = findViewById(R.id.totalFeeTxt);
        taxTxT = findViewById(R.id.taxTxT);
        deliveryTxT = findViewById(R.id.deliveryTxT);
        totalTxT =findViewById(R.id.totalTxT);
        recyclerViewList = findViewById(R.id.view);
        scrollView2 = findViewById(R.id.scrollView2);
        emptyTxT = findViewById(R.id.emptyTxT);
    }
}
