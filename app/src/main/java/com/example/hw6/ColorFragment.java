package com.example.hw6;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.example.hw6.databinding.FragmentColorBinding;


public class ColorFragment extends Fragment {
private FragmentColorBinding binding;
int color;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentColorBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        Spinner colors = binding.spinner;
        color = R.color.beige;


        colors.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (colors.getSelectedItem().toString()) {
                    case "Beige":
                        color = R.color.beige;
                        break;
                    case "Red":
                        color = R.color.red;
                        break;
                    case "Purple":
                        color = R.color.purple;
                        break;
                }
                SharedPreferences sharedPreferences = requireActivity().getSharedPreferences("game_prefs", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt("selected_color", color);
                editor.apply(); // Save the color preference
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}