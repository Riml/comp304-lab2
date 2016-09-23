package com.comp304.group1.assignment2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FoodTypes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_types);
    }
    public void onClickBtnNext2(View v){

        Intent i = new Intent(FoodTypes.this, Restaurants.class);
        startActivity(i);

    }
}
