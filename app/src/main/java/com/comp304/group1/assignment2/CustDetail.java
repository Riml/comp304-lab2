package com.comp304.group1.assignment2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CustDetail extends AppCompatActivity {

    // Previous bundle values
    String restaurantSelected, foodType, item1, item2, item3;
    // Strings to hold values from this view's EditTexts
    String cName, cAddress, cCard, cFavChef;
    EditText customerName, customerAddress, cardNo, favChef;
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cust_detail);

        // Grab previously saved values
        Bundle extras = getIntent().getExtras();
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

    //Links UI elements from previous activities data
    private void loadUI(){
        submitBtn = (Button)findViewById(R.id.btnSubmit);
        customerName = (EditText)findViewById(R.id.customer_name);
        customerAddress = (EditText)findViewById(R.id.customer_address);
        cardNo = (EditText)findViewById(R.id.card_number);
        favChef = (EditText)findViewById(R.id.favourite_chef);
    }

    public void submitBtnClicked(View v){
        cName = customerName.getText().toString();
        cAddress = customerAddress.getText().toString();
        cCard = cardNo.getText().toString();
        cFavChef = favChef.getText().toString();

        Intent i = new Intent(CustDetail.this, OrderInfo.class);
        // Add new values to bundle
        i.putExtra("customerName", cName);
        i.putExtra("customerAddress", cAddress);
        i.putExtra("cardNumber", cCard);
        i.putExtra("favouriteChef", cFavChef);
        // Pass previous values through to next activity
        i.putExtra("restaurantSelected", restaurantSelected);
        i.putExtra("foodType", foodType);
        setExtrasFoodItems(i);
        startActivity(i);
    }

    private void setExtrasFoodItems(Intent intent){
        // Pass all values that are checked to the next activity
        if (item1 != null){
            intent.putExtra("item1", item1);
        } if (item2 != null){
            intent.putExtra("item2", item2);
        } if (item3 != null){
            intent.putExtra("item3", item3);
        }
    }
}
