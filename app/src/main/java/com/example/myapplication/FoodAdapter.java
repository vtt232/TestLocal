package com.example.myapplication;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.crashlytics.buildtools.reloc.javax.annotation.Nonnull;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import android.os.Handler;



public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Food> foods;
    private OnItemListener mOnItemListener;
    public FoodAdapter(Context _context, ArrayList<Food> _foods, OnItemListener onItemListener)
    {
        context = _context;
        foods = _foods;
        mOnItemListener=onItemListener;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View foodView;
        foodView = inflater.inflate(R.layout.food_thumbnail2, parent, false);
        ViewHolder viewHolder = new ViewHolder(foodView, mOnItemListener);
        return viewHolder;
    }

    public void filterList(ArrayList<Food> filterllist) {
        // below line is to add our filtered
        // list in our course array list.
        foods = filterllist;
        // below line is to notify our adapter
        // as change in recycler view data.
        notifyDataSetChanged();
    }



    @Override
    public int getItemViewType(int position) {
        return position%2;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Food food = foods.get(position);

        holder.name.setText(food.getMealName());
        holder.country.setText(food.getMealArea());
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    public interface OnItemListener{
        void onItemClick(int position);
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public TextView name;
        public TextView country;
        OnItemListener onItemListener;
        public ViewHolder(@NonNull View itemView, OnItemListener onItemListener) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            country = itemView.findViewById(R.id.country);
            this.onItemListener=onItemListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onItemListener.onItemClick(getAdapterPosition());

        }
    }

}
