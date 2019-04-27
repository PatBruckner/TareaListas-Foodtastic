package com.asiesinc.foodtastic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.List;

public class ListActivity extends AppCompatActivity {

    private ListView listview;
    private Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initViews();

        final List<Food> foodList = FoodUtils.getFood();
        FoodListViewAdapter adapter = new FoodListViewAdapter(this, foodList);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Food food = foodList.get(position);
                Intent intent = new Intent(ListActivity.this, FoodDetailsActivity.class);
                intent.putExtra(Constants.FOOD_SELECTED, gson.toJson(food));
                startActivity(intent);
            }
        });

        listview.setAdapter(adapter);
    }

    private void initViews() {
        listview =  findViewById(R.id.listViewFoods);
    }

}
