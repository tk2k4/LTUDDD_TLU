package com.example.spfood.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.spfood.Domain.FoodDomain;
import com.example.spfood.Helper.ManagementCart;
import com.example.spfood.R;

public class ShowDetailActivity extends AppCompatActivity {
private TextView addToCartBtn;
private TextView titleTxt, feeTxt, descriptionTxt, numberOrderTxt, totalPriceTxt, starTxt, caloTxt, timeTxt;
private ImageView plusBtn, minusBtn, picFood;
private FoodDomain object;
private int numberOrder = 1;
private ManagementCart managementCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        managementCart = new ManagementCart(this);

        iniView();
        getBundle();
    }

    private void getBundle() {
        object = (FoodDomain) getIntent().getSerializableExtra("object");
        int drawbleResourceId = this.getResources().getIdentifier(object.getPic(), "drawable",this.getPackageName());
        Glide.with(this).
                load(drawbleResourceId).
                into(picFood);

        titleTxt.setText(object.getTitle());
        feeTxt.setText("$" + object.getFee());
        descriptionTxt.setText(object.getDescription());
        numberOrderTxt.setText(String.valueOf(numberOrder));
        caloTxt.setText(object.getCalories() + "Calories");
        /*starTxt.setText(object.getStar() + "");*/
        timeTxt.setText(object.getTime() + "minutes");
        totalPriceTxt.setText("$" + numberOrder * object.getFee());

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOrder = numberOrder + 1;
                numberOrderTxt.setText(String.valueOf(numberOrder));
                totalPriceTxt.setText("$" + numberOrder * object.getFee());

            }
        });

        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numberOrder > 1) {
                    numberOrder = numberOrder - 1;
                }
                numberOrderTxt.setText(String.valueOf(numberOrder));
                totalPriceTxt.setText("$" + numberOrder * object.getFee());
            }
        });
        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                object.setNumberInCart(numberOrder);
                managementCart.insertFood(object);
            }
        });
    }

    private void iniView() {
        addToCartBtn = findViewById(R.id.addToCartBtn);
        titleTxt = findViewById(R.id.titleTxt);
        feeTxt = findViewById(R.id.priceTxt);
        descriptionTxt = findViewById(R.id.descriptionTxt);
        numberOrderTxt = findViewById(R.id.numberItemTxt);
        plusBtn = findViewById(R.id.plusCartBtn);
        minusBtn = findViewById(R.id.minusCardBtn);
        picFood = findViewById(R.id.foodPic);
        totalPriceTxt = findViewById(R.id.totalPriceTxt);
        starTxt = findViewById(R.id.startBtn);
        caloTxt = findViewById(R.id.caloTxt);
        timeTxt = findViewById(R.id.timeTxt);

    }
}