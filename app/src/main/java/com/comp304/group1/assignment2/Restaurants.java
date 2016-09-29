package com.comp304.group1.assignment2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Restaurants extends AppCompatActivity {

    String foodType;
    ArrayAdapter restaurantAdapter;
    Spinner restaurantSpinner;
    List<String> restaurantArray = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant);

        // Get food preference from previous activity
        foodType = getIntent().getStringExtra("foodType");
    }

    @Override
    protected void onStart(){
        super.onStart();
        loadUI();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.restaurant_menu, menu);
        return true;
    }

    public void onClickBtnNext3(View v){
        String selectedRestaurant = restaurantSpinner.getSelectedItem().toString();
        Intent i = new Intent(Restaurants.this, AddOrder.class);
        i.putExtra("restaurant", selectedRestaurant);
        i.putExtra("foodType", foodType);
        startActivity(i);
    }

    public void loadUI(){
        restaurantSpinner = (Spinner)findViewById(R.id.restaurantSpinner);

        // Set spinner based on food type selected in previous activity
        switch (foodType){
            case "American":
                restaurantArray = Arrays.asList(getResources().getStringArray(R.array.a_restaurant_array));
                break;
            case "Italian":
                restaurantArray = Arrays.asList(getResources().getStringArray(R.array.i_restaurant_array));
                break;
            case "Chinese":
                restaurantArray = Arrays.asList(getResources().getStringArray(R.array.c_restaurant_array));
                break;
            default:
                break;
        }

        // Create Array adapter for restaurant spinner
        restaurantAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, restaurantArray);

        // Attach the array adapter to the spinner
        restaurantSpinner.setAdapter(restaurantAdapter);
    }

}
