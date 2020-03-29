package com.example.restaurantguide;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder> {
    private ArrayList<Restaurant> mRestaurants;
    private RecyclerViewClickListener mListener;

    public RestaurantAdapter(ArrayList<Restaurant> restaurants, RecyclerViewClickListener listener) {
        mRestaurants = restaurants;
        mListener = listener;
    }
    public interface RecyclerViewClickListener {
        void onClick(View view, int position);
    }
    public static class RestaurantViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name;
        public TextView cuisine;
        public TextView location;
        public TextView rating;
        private RecyclerViewClickListener mListener;

        public RestaurantViewHolder(View v, RecyclerViewClickListener listener){
            super(v);
            mListener = listener;
            v.setOnClickListener(this);
            name = v.findViewById(R.id.ListName);
            cuisine = v.findViewById(R.id.ListCuisine);
            location = v.findViewById(R.id.ListLocation);
            rating = v.findViewById(R.id.ListRating);
        }

        @Override
        public void onClick(View view) {
            mListener.onClick(view, getAdapterPosition());
        }
    }
    @Override
    public RestaurantAdapter.RestaurantViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant_list, parent, false);
        return new RestaurantViewHolder(v, mListener);
    }
    @Override
    public void onBindViewHolder(RestaurantViewHolder holder, int position){
        Restaurant restaurant = mRestaurants.get(position);
        holder.name.setText(restaurant.getName());
        holder.cuisine.setText(restaurant.getCuisine());
        holder.location.setText(restaurant.getLocation());
        holder.rating.setText(String.valueOf(restaurant.getRating()));
    }
    @Override
    public int getItemCount(){
        return mRestaurants.size();
    }
}
