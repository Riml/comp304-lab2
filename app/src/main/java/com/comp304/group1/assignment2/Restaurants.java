package com.comp304.group1.assignment2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class Restaurants extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.restaurant);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.restaurant_menu, menu);
        return true;
    }

    public void onClickBtnNext3(View v){

        Intent i = new Intent(Restaurants.this, AddOrder.class);
        startActivity(i);

    }


}
