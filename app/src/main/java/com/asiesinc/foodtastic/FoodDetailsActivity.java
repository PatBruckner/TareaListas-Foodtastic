package com.asiesinc.foodtastic;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

public class FoodDetailsActivity extends AppCompatActivity {

    private ImageView foodImage;
    private TextView nameTextView;
    private TextView idTextView;
    private TextView typeTextView;

    private Gson gson = new Gson();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);
        initViews();

        Food food = this.gson.fromJson(getIntent().getStringExtra(Constants.FOOD_SELECTED), Food.class);

        fillFoodData(food);
    }

    private void initViews() {
        this.foodImage = findViewById(R.id.foodImage);
        this.nameTextView = findViewById(R.id.nameTextView);
        this.idTextView = findViewById(R.id.idTextView);
        this.typeTextView = findViewById(R.id.typeTextView);
    }

    private void fillFoodData(Food food) {
        this.foodImage.setImageResource(food.getImage());
        this.nameTextView.setText(food.getName());
        this.idTextView.setText(String.valueOf(food.getId()));
        this.typeTextView.setText(food.getType());
    }
}
