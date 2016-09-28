package com.comp304.group1.assignment2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AddOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_product);
    }

    public void onClickBtnNext4(View v){

        Intent i = new Intent(AddOrder.this, CustDetail.class);
        startActivity(i);

    }
}
