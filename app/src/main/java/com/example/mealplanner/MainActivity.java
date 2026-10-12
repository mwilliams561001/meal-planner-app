package com.example.mealplanner;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.widget.EditText;
import android.content.SharedPreferences;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addMealButton = findViewById(R.id.addMealButton);
        Button groceryListButton = findViewById(R.id.groceryListButton);

        addMealButton.setOnClickListener(v -> {
            EditText mealInput = new EditText(this);
            mealInput.setHint("Enter a meal");

            new AlertDialog.Builder(this)
                    .setTitle("Add Meal")
                    .setView(mealInput)
                    .setPositiveButton("Save", (dialog, which) -> {
                        String meal = mealInput.getText().toString().trim();

                        if (!meal.isEmpty()) {
                            SharedPreferences prefs =
                                    getSharedPreferences("MealPlanner", MODE_PRIVATE);

                            String previousMeals = prefs.getString("savedMeal", "");
                            prefs.edit().putString("savedMeal", previousMeals + "\n" + meal).apply();

                            Toast.makeText(this,
                                    "Meal saved: " + meal,
                                    Toast.LENGTH_SHORT).show();
                        }
                    })
                    .setNegativeButton("Cancel", null)
                    .show();
        });

        groceryListButton.setOnClickListener(v -> {
            SharedPreferences prefs =
                    getSharedPreferences("MealPlanner", MODE_PRIVATE);

            String meals = prefs.getString("savedMeal", "");

            new AlertDialog.Builder(this)
                    .setTitle("Saved Meals")
                    .setMessage(meals.isEmpty() ? "No meals added yet." : meals)
                    .setPositiveButton("OK", null)
                    .show();
        });
    }

}

