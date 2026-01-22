package com.example.listycity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity
        implements AddCityFragment.CityDialogListener {

    private ArrayList<City> cities;
    private CityArrayAdapter adapter;
    private TextView emptyView;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cities = new ArrayList<>();
        cities.add(new City("Edmonton", "AB"));
        cities.add(new City("Vancouver", "BC"));
        cities.add(new City("Toronto", "ON"));

        listView = findViewById(R.id.city_list);
        emptyView = findViewById(R.id.empty_view);

        adapter = new CityArrayAdapter(this, cities);
        listView.setAdapter(adapter);

        updateEmpty();

        findViewById(R.id.button_add_city).setOnClickListener(v ->
                new AddCityFragment()
                        .show(getSupportFragmentManager(), "addCity")
        );

        listView.setOnItemClickListener((parent, view, position, id) -> {
            City city = cities.get(position);
            AddCityFragment.newEditInstance(position, city)
                    .show(getSupportFragmentManager(), "editCity");
        });

        findViewById(R.id.button_delete).setOnClickListener(v ->
                new AlertDialog.Builder(this)
                        .setTitle("Confirm delete")
                        .setMessage("Delete selected cities?")
                        .setPositiveButton("Delete", (d, w) -> deleteSelected())
                        .setNegativeButton("Cancel", null)
                        .show()
        );
    }

    @Override
    public void onCitySaved(int position, City city) {
        if (position >= 0) {
            cities.set(position, city);
        } else {
            if (isDuplicate(city)) {
                Toast.makeText(this,
                        "This city already exists",
                        Toast.LENGTH_SHORT).show();
                return;
            }
            cities.add(city);
        }

        adapter.notifyDataSetChanged();
        listView.invalidateViews();
        updateEmpty();
    }

    private boolean isDuplicate(City newCity) {
        for (City c : cities) {
            if (c.getName().equalsIgnoreCase(newCity.getName()) &&
                    c.getProvince().equalsIgnoreCase(newCity.getProvince())) {
                return true;
            }
        }
        return false;
    }

    private void deleteSelected() {
        Iterator<City> it = cities.iterator();
        while (it.hasNext()) {
            if (it.next().isSelected()) it.remove();
        }
        adapter.notifyDataSetChanged();
        listView.invalidateViews();
        updateEmpty();
    }

    private void updateEmpty() {
        emptyView.setVisibility(
                cities.isEmpty() ? TextView.VISIBLE : TextView.GONE
        );
    }
}
