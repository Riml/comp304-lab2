package com.comp304.group1.assignment2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OrderInfo extends AppCompatActivity {

    // Previous bundle values
    String restaurantSelected, foodType, item1, item2, item3;
    String cName, cAddress;
    // UI views
    TextView customerName, customerAddress, foodTypeSelected, restaurantName, orderItems;
    Button newOrderBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_info);

        // Grab previously saved values
        Bundle extras = getIntent().getExtras();
        cName = extras.getString("customerName");
        cAddress = extras.getString("customerAddress");
        restaurantSelected = extras.getString("restaurant");
        foodType = extras.getString("foodType");
        // Grab order items
        if (extras.containsKey("item1")) {
            item1 = extras.getString("item1");
        } if (extras.containsKey("item2")) {
            item2 = extras.getString("item2");
        } if (extras.containsKey("item3")) {
            item3 = extras.getString("item3");
        }
    }

    @Override
    protected void onStart(){
        super.onStart();
        loadUI();
    }

    private void loadUI(){
        customerName = (TextView)findViewById(R.id.tvCustomerName);
        customerAddress = (TextView)findViewById(R.id.tvCustomerAddress);
        foodTypeSelected = (TextView)findViewById(R.id.tvFoodType);
        restaurantName = (TextView)findViewById(R.id.tvResName);
        orderItems = (TextView)findViewById(R.id.tvFoods);

        // Set UI Values from bundle
        customerName.setText(cName);
        customerAddress.setText(cAddress);
        foodTypeSelected.setText(foodType);
        restaurantName.setText(restaurantSelected);

        // Create custom string for order items
        String customerOder = "";
        if (item1 != null){
            customerOder += item1 + "\n";
        } if (item2 != null){
            customerOder += item2 + "\n";
        } if (item3 != null){
            customerOder += item3;
        }
        orderItems.setText(customerOder);
    }

    public void newOrderClick(View v){
        Intent i = new Intent(OrderInfo.this, MainActivity.class);
        startActivity(i);
    }
}
