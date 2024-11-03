package com.example.hw6;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hw6.databinding.FragmentGameBinding;
import com.example.hw6.databinding.FragmentWinBinding;


public class WinFragment extends Fragment {
    private FragmentWinBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentWinBinding.inflate(inflater, container, false);
        View view = binding.getRoot();


        TextView output = binding.output;
        int moves = WinFragmentArgs.fromBundle(requireArguments()).getMoves();

        output.setText(String.valueOf(moves));

        return view;
    }
}