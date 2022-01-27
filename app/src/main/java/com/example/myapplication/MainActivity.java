package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class MainActivity  extends AppCompatActivity implements FoodAdapter.OnItemListener {

    private ArrayList<Food> foods ;
    private RecyclerView recyclerView;
    private FoodAdapter foodAdapter ;
    private final static int TYPE_NAME = 1;
    private final static int TYPE_AREA = 2;
    private final static int TYPE_INGREDIENT = 3;
    private int typeSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rview);
        foods=new ArrayList<>();
        foods.add(new Food("Pho", "Viet Nam"));
        foods.add(new Food("Kem", "Italy"));
        foods.add(new Food("Hambuger", "American"));
        foods.add(new Food("Nuclear", "Japan"));
        foods.add(new Food("Vodka", "Russia"));
        foods.add(new Food("Do thai", "Germany"));
        foods.add(new Food("Dick", "china"));
        foods.add(new Food("Tasteless", "England"));
        foods.add(new Food("army", "korean"));
        foods.add(new Food("hopeless", "hcmus"));

        foodAdapter = new FoodAdapter(MainActivity.this, foods, this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(foodAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        typeSearch=1;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // below line is to get our inflater
        MenuInflater inflater = getMenuInflater();

        // inside inflater we are inflating our menu file.
        inflater.inflate(R.menu.menu, menu);

        // below line is to get our menu item.
        MenuItem searchItem = menu.findItem(R.id.action_bar);
        MenuItem filteIten =menu.findItem(R.id.menuType);

        // getting search view of our item.
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setQueryHint("Food name");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String newText) {
                filter(newText);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.menuType_Name:
                typeSearch=TYPE_NAME;
                Toast.makeText(this, "Name Type", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuType_Area:
                typeSearch=TYPE_AREA;
                Toast.makeText(this, "Area Type", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menuType_Ingredient:
                typeSearch=TYPE_INGREDIENT;
                Toast.makeText(this, "Ingredient Type", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    };


    private void filter(String newText) {
        // creating a new array list to filter our data.
        ArrayList<Food> searchedFood = new ArrayList<>();

        // running a for loop to compare elements.
        for (Food item : foods) {
            String itemAtri=item.getMealName();
            if(typeSearch==2)
                itemAtri= item.getMealArea();
            // checking if the entered string matched with any item of our recycler view.
            if (itemAtri.toLowerCase().contains(newText.toLowerCase())) {
                // if the item is matched we are
                // adding it to our filtered list.
                searchedFood.add(item);
            }
        }
        if (searchedFood.isEmpty()) {
            // if no item is added in filtered list we are
            // displaying a toast message as no data found.
            Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show();
        } else {
            // at last we are passing that filtered
            // list to our adapter class.
            foodAdapter.filterList(searchedFood);
        }


    }

    @Override
    public void onItemClick(int position) {
        foods.get(position);
        Intent intent = new Intent(this, clickActivity.class);
        startActivity(intent);
    }
}