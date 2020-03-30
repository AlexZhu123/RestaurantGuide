package com.example.restaurantguide;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    private Restaurant mRestaurant;
    private TextView name;
    private TextView cuisine;
    private TextView location;
    private ImageView rating;
    private TextView price;
    private TextView recommendation;
    private TextView rating2;
    private ImageView photo;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        name = findViewById(R.id.Name);
        cuisine = findViewById(R.id.Cuisine);
        location = findViewById(R.id.Location);
        rating2 = findViewById(R.id.RatingNo);
        price = findViewById(R.id.Price);
        recommendation = findViewById(R.id.Recommendation);
        photo = findViewById(R.id.Photo);
        rating = findViewById(R.id.Rating);

        Intent intent = getIntent();
        int position = intent.getIntExtra(MainActivity.EXTRA_MESSAGE,0);

        mRestaurant = Restaurant.getRestaurant().get(position);
        name.setText(mRestaurant.getName());
        rating2.setText(String.valueOf(mRestaurant.getRating()));
        if(mRestaurant.getRating() > 3.5 && mRestaurant.getRating() <= 4.0) {
            rating.setImageResource(R.drawable.fostar);
        }
        if(mRestaurant.getRating() > 4.0 && mRestaurant.getRating() <= 4.5) {
            rating.setImageResource(R.drawable.fhstar);
        }
        if(mRestaurant.getRating() > 4.5 && mRestaurant.getRating() <= 5.0) {
            rating.setImageResource(R.drawable.fstar);
        }
        cuisine.setText(mRestaurant.getCuisine());
        location.setText(mRestaurant.getLocation());
        price.setText(mRestaurant.getPrice());
        recommendation.setText(mRestaurant.getRecommendation());
        photo.setImageResource(mRestaurant.getPicture());


    }

}
