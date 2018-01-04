package com.example.amrez.reportcard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);

    }


    public void historical_places(View view) {
        Intent historical_list = new Intent(this, historicalList.class);
        startActivity(historical_list);
    }

    public void hospitales(View view) {
        Intent hospital_list = new Intent(this, hospitales.class);
        startActivity(hospital_list);
    }

    public void restaurant(View view) {
        Intent restaurant_list = new Intent(this, restaurant.class);
        startActivity(restaurant_list);
    }

    public void cafes(View view) {
        Intent cafes_list = new Intent(this, cafes.class);
        startActivity(cafes_list);
    }
}
