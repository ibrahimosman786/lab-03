package com.example.listycity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class AddCityFragment extends DialogFragment {

    interface CityDialogListener {
        void onCitySaved(int position, City city);
    }

    private CityDialogListener listener;
    private int editPosition = -1;

    public static AddCityFragment newEditInstance(int position, City city) {
        AddCityFragment fragment = new AddCityFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        args.putString("name", city.getName());
        args.putString("province", city.getProvince());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (CityDialogListener) context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View view = LayoutInflater.from(requireContext())
                .inflate(R.layout.fragment_add_city, null);

        EditText cityInput = view.findViewById(R.id.edit_city);
        EditText provinceInput = view.findViewById(R.id.edit_province);

        boolean isEdit = getArguments() != null;

        if (isEdit) {
            editPosition = getArguments().getInt("position");
            cityInput.setText(getArguments().getString("name"));
            provinceInput.setText(getArguments().getString("province"));
        }

        return new MaterialAlertDialogBuilder(requireContext())
                .setTitle(isEdit ? "Edit City" : "Add City")
                .setView(view)
                .setPositiveButton("Save", (d, w) -> {
                    City city = new City(
                            cityInput.getText().toString(),
                            provinceInput.getText().toString()
                    );
                    listener.onCitySaved(editPosition, city);
                })
                .setNegativeButton("Cancel", null)
                .create();
    }
}
