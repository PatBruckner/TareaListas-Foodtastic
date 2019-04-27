package com.asiesinc.foodtastic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FoodListViewAdapter extends BaseAdapter {

    private Context context;
    private List<Food> foodList;

    public FoodListViewAdapter(Context context, List<Food> foodList) {
        this.context = context;
        this.foodList = foodList;
    }

    @Override
    public int getCount() {
        return this.foodList.size();
    }

    @Override
    public Food getItem(int position) {
        return this.foodList.get(position);
    }

    @Override
    public long getItemId(int position) { return this.foodList.get(position).getId();
    }

    @Override
    public View getView(int position, View vista, ViewGroup parent) {
        ViewHolder viewHolder;
        if (vista == null) { //No se puede reciclar
            viewHolder = new ViewHolder();


            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vista = inflater.inflate(R.layout.food_list_item_horizontal, null);


            viewHolder.textViewName = vista.findViewById(R.id.textViewName);
            viewHolder.textViewType = vista.findViewById(R.id.textViewType);
            vista.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) vista.getTag();
        }

        Food food = this.foodList.get(position);
        viewHolder.imageView.setImageResource(food.getImage());
        viewHolder.textViewName.setText(food.getName());
        viewHolder.textViewType.setText(food.getType());
        return vista;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView textViewName;
        TextView textViewType;
    }
}

