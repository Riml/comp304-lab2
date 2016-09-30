package com.comp304.group1.assignment2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //activity to display logo screen
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickBtnNext1(View v){
        Intent i = new Intent(MainActivity.this, FoodTypes.class);
        //launch next activity
        startActivity(i);

    }
}
