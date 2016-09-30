package com.comp304.group1.assignment2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddOrder extends AppCompatActivity {

    //Instantiate our values
    List<String> foodArray = new ArrayList<String>();
    String restaurantSelected, foodType;
    TextView restaurantLabel;
    CheckBox chk1, chk2, chk3;
    Button nextBtn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Setting the content to display once the activity loads.
        setContentView(R.layout.add_product);

        // Get food preference and restaurant from previous activity
        restaurantSelected = getIntent().getStringExtra("restaurant");
        foodType = getIntent().getStringExtra("foodType");
    }

    @Override
    protected  void onStart(){
        super.onStart();
        loadUI();
    }


    public void onClickBtnNext4(View v){
        Intent i = new Intent(AddOrder.this, CustDetail.class);
        //Pass values to next activity
        i.putExtra("restaurant", restaurantSelected);
        i.putExtra("foodType", foodType);
        //retrieve data from checkboxes
        setExtrasFromCheckBoxes(i);
        startActivity(i);
    }

    private void loadUI() {
        //links variables to view components
        restaurantLabel = (TextView) findViewById(R.id.restaurant_name);
        chk1 = (CheckBox) findViewById(R.id.chk1);
        chk2 = (CheckBox) findViewById(R.id.chk2);
        chk3 = (CheckBox) findViewById(R.id.chk3);
        nextBtn4 = (Button) findViewById(R.id.btnNext4);

        // Set restaurant label text
        restaurantLabel.setText(restaurantSelected);

        // Set array to use based on restaurant selected in previous activity
        switch (restaurantSelected) {
            case "Ilmir's Spicy Hot Dogs":
                foodArray = Arrays.asList(getResources().getStringArray(R.array.rest_1));
                break;
            case "Josh's American BBQ":
                foodArray = Arrays.asList(getResources().getStringArray(R.array.rest_2));
                break;
            case "Tori's Fresh Buns":
                foodArray = Arrays.asList(getResources().getStringArray(R.array.rest_3));
                break;
            case "Ilmir's Spicy Pasta":
                foodArray = Arrays.asList(getResources().getStringArray(R.array.rest_4));
                break;
            case "Josh's Italian Lasagna":
                foodArray = Arrays.asList(getResources().getStringArray(R.array.rest_5));
                break;
            case "Josh's Chinese Duck Roast":
                foodArray = Arrays.asList(getResources().getStringArray(R.array.rest_6));
                break;
            case "Tori's Fresh Rolls":
                foodArray = Arrays.asList(getResources().getStringArray(R.array.rest_7));
                break;
            default:
                break;
        }
        // Set checkbox text based on switch case
        chk1.setText(foodArray.get(0));
        chk2.setText(foodArray.get(1));
        chk3.setText(foodArray.get(2));
    }


    private void setExtrasFromCheckBoxes(Intent intent){
        // Pass all values that are checked to the next activity
        if (chk1.isChecked()){
            intent.putExtra("item1", chk1.getText().toString());
        } if (chk2.isChecked()){
            intent.putExtra("item2", chk2.getText().toString());
        } if (chk3.isChecked()){
            intent.putExtra("item3", chk3.getText().toString());
        }
    }
}
