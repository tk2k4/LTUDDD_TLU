package com.example.spfood.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spfood.Adapter.CartListAdapter;
import com.example.spfood.Helper.ManagementCart;
import com.example.spfood.Interface.ChangeNumberItemsListener;
import com.example.spfood.R;

public class CartCheckoutMainActivity extends AppCompatActivity {

    private boolean paymentSelected = false;
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewList;
    private ManagementCart managementCart;
    private ImageView backCartActivityBtn;
    private TextView payBtn, payBtn1, payBtn2, total1TxT;
    private double tax;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_checkout_main);

        managementCart = new ManagementCart(this);
        initView();
        initList();
        backCartActivityBtn();
        payBtn();
    }

    private void showOrderSuccessMessage() {
        if (!paymentSelected) {
            Toast.makeText(this, "Hãy chọn phương thức thanh toán", Toast.LENGTH_SHORT).show();
            return;
        }

        Toast.makeText(this, "Đặt hàng thành công", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(CartCheckoutMainActivity.this, MainActivity.class));
    }

    private void backCartActivityBtn() {
        ImageView backCartActivityBtn = findViewById(R.id.backCartActivityBtn);

        backCartActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CartCheckoutMainActivity.this, CartActivity.class));
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
        calculateCard();
    }

    private void calculateCard() {
        double percentTax = 0.02;
        double delivery = 10;

        tax = Math.round((managementCart.getTotalFee() * percentTax) * 100.0) / 100.0;
        double total = Math.round((managementCart.getTotalFee() + tax + delivery) * 100.0) / 100.0;

        total1TxT.setText("Đặt Hàng - $" + total);

    }

    private void payBtn() {
        final TextView payBtn1 = findViewById(R.id.payBtn1);
        final TextView payBtn2 = findViewById(R.id.payBtn2);
        TextView total1TxT =findViewById(R.id.total1TxT);
        payBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paymentSelected = true;
                payBtn1.setBackgroundColor(Color.GRAY);
                payBtn1.setTextColor(Color.WHITE);
                payBtn2.setBackgroundColor(Color.TRANSPARENT);
                payBtn2.setTextColor(Color.BLACK);
            }
        });

        payBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paymentSelected = true;
                payBtn2.setBackgroundColor(Color.GRAY);
                payBtn2.setTextColor(Color.WHITE);
                payBtn1.setBackgroundColor(Color.TRANSPARENT);
                payBtn1.setTextColor(Color.BLACK);
            }
        });

        total1TxT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOrderSuccessMessage();
            }
        });

    }


    private void initView() {
        recyclerViewList = findViewById(R.id.view3);
        backCartActivityBtn = findViewById(R.id.backCartActivityBtn);
        payBtn1 = findViewById(R.id.payBtn1);
        payBtn2 = findViewById(R.id.payBtn2);
        total1TxT = findViewById(R.id.total1TxT);
    }

}
