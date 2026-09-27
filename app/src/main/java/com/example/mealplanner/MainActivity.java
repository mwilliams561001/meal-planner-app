package com.example.mealplanner;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addMealButton = findViewById(R.id.addMealButton);
        Button groceryListButton = findViewById(R.id.groceryListButton);

        addMealButton.setOnClickListener(v ->
                Toast.makeText(MainActivity.this,
                        "Add Meal selected",
                        Toast.LENGTH_SHORT).show());

        groceryListButton.setOnClickListener(v ->
                Toast.makeText(MainActivity.this,
                        "Grocery List selected",
                        Toast.LENGTH_SHORT).show());
    }
}