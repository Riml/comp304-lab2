package com.comp304.group1.assignment2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class FoodTypes extends AppCompatActivity {

    RadioGroup rg;
    String selectedValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food_types);
    }

    @Override
    protected void onStart(){
        super.onStart();
        loadUI();
    }

    public void onClickBtnNext2(View v){
        // Get selected radio button value
        selectedValue = ((RadioButton)findViewById(rg.getCheckedRadioButtonId())).getText().toString();

        // Create new intent
        Intent i = new Intent(FoodTypes.this, Restaurants.class);

        // Add radio button value and pass it to the next activity
        i.putExtra("foodType", selectedValue);

        startActivity(i);
    }

    public void loadUI(){
        rg = (RadioGroup) findViewById(R.id.foodTypeRadio);
    }
}
