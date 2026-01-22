package com.example.listycity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CityArrayAdapter extends ArrayAdapter<City> {

    public CityArrayAdapter(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView,
                        @NonNull ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(getContext())
                    .inflate(R.layout.content, parent, false);
        }

        City city = getItem(position);

        TextView cityText = view.findViewById(R.id.city_text);
        TextView provinceText = view.findViewById(R.id.province_text);
        CheckBox checkBox = view.findViewById(R.id.city_checkbox);

        if (city != null) {
            cityText.setText(city.getName());
            provinceText.setText(city.getProvince());

            // The below code handles the "Checkbox handling"
            checkBox.setOnCheckedChangeListener(null);
            checkBox.setChecked(city.isSelected());
            checkBox.setOnCheckedChangeListener(
                    (buttonView, isChecked) -> city.setSelected(isChecked)
            );
        }

        return view;
    }
}
