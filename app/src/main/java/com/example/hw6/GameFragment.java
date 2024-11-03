package com.example.hw6;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import game.LightGame;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.hw6.databinding.FragmentGameBinding;


public class GameFragment extends Fragment {
    private FragmentGameBinding binding;
    private Button one,two,three,four,five,six,seven,eight,nine;
    private LightGame board;
    private int color = R.color.beige;
    private TextView output;

    public void onResume() {
        super.onResume();

        // Retrieve color from SharedPreferences
        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences("game_prefs", Context.MODE_PRIVATE);
        color = sharedPreferences.getInt("selected_color", R.color.beige);

        // Apply this color to your buttons or other UI elements
        updateButtonColors(color);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentGameBinding.inflate(inflater, container, false);
        View view = binding.getRoot();


        board = new LightGame();
        one = binding.topLeft;
        two = binding.topMiddle;
        three = binding.topRight;
        four = binding.midLeft;
        five = binding.mid;
        six = binding.right;
        seven = binding.bottomLeft;
        eight = binding.bottomMid;
        nine = binding.bottomRight;
        output = binding.output;



        updateButtonColors(color);


            binding.startGame.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("GameFragment", "Button clicked - updating color");
                    board.setGameBoard();
                    output.setText(String.valueOf(board.getMove_counter()));
                    binding.startGame.setText("RESTART");

                    one.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                board.moveMade(0,0);
                                updateButtonColors(color);
                                if (board.checkWin()) {
                                    GameFragmentDirections.ActionGameFragmentToWinFragment action = GameFragmentDirections.actionGameFragmentToWinFragment(board.getMove_counter());
                                    Navigation.findNavController(v).navigate(action);
                                }
                                output.setText(String.valueOf(board.getMove_counter()));
                            }
                        });
                        two.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                board.moveMade(0,1);
                                updateButtonColors(color);
                                if (board.checkWin()) {
                                    GameFragmentDirections.ActionGameFragmentToWinFragment action = GameFragmentDirections.actionGameFragmentToWinFragment(board.getMove_counter());
                                    Navigation.findNavController(v).navigate(action);
                                }
                                output.setText(String.valueOf(board.getMove_counter()));
                            }
                        });
                        three.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                board.moveMade(0,2);
                                updateButtonColors(color);
                                if (board.checkWin()) {
                                    GameFragmentDirections.ActionGameFragmentToWinFragment action = GameFragmentDirections.actionGameFragmentToWinFragment(board.getMove_counter());
                                    Navigation.findNavController(v).navigate(action);
                                }
                                output.setText(String.valueOf(board.getMove_counter()));
                            }
                        });
                        four.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                board.moveMade(1,0);
                                updateButtonColors(color);
                                if (board.checkWin()) {
                                    GameFragmentDirections.ActionGameFragmentToWinFragment action = GameFragmentDirections.actionGameFragmentToWinFragment(board.getMove_counter());
                                    Navigation.findNavController(v).navigate(action);
                                }
                                output.setText(String.valueOf(board.getMove_counter()));
                            }
                        });
                        five.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                board.moveMade(1,1);
                                updateButtonColors(color);
                                if (board.checkWin()) {
                                    GameFragmentDirections.ActionGameFragmentToWinFragment action = GameFragmentDirections.actionGameFragmentToWinFragment(board.getMove_counter());
                                    Navigation.findNavController(v).navigate(action);
                                }
                                output.setText(String.valueOf(board.getMove_counter()));
                            }
                        });
                        six.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                board.moveMade(1,2);
                                updateButtonColors(color);
                                if (board.checkWin()) {
                                    GameFragmentDirections.ActionGameFragmentToWinFragment action = GameFragmentDirections.actionGameFragmentToWinFragment(board.getMove_counter());
                                    Navigation.findNavController(v).navigate(action);
                                }
                                output.setText(String.valueOf(board.getMove_counter()));
                            }
                        });
                        seven.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                board.moveMade(2,0);
                                updateButtonColors(color);
                                if (board.checkWin()) {
                                    GameFragmentDirections.ActionGameFragmentToWinFragment action = GameFragmentDirections.actionGameFragmentToWinFragment(board.getMove_counter());
                                    Navigation.findNavController(v).navigate(action);
                                }
                                output.setText(String.valueOf(board.getMove_counter()));
                            }
                        });
                        eight.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                board.moveMade(2,1);
                                updateButtonColors(color);
                                if (board.checkWin()) {
                                    GameFragmentDirections.ActionGameFragmentToWinFragment action = GameFragmentDirections.actionGameFragmentToWinFragment(board.getMove_counter());
                                    Navigation.findNavController(v).navigate(action);
                                }
                                output.setText(String.valueOf(board.getMove_counter()));
                            }
                        });
                        nine.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                board.moveMade(2,2);
                                updateButtonColors(color);
                                if (board.checkWin()) {
                                    GameFragmentDirections.ActionGameFragmentToWinFragment action = GameFragmentDirections.actionGameFragmentToWinFragment(board.getMove_counter());
                                    Navigation.findNavController(v).navigate(action);
                                }
                                output.setText(String.valueOf(board.getMove_counter()));
                            }
                        });
                    updateButtonColors(color);

                }
            });


        // Inflate the layout for this fragment
        return view;
    }

    private void updateButtonColors(int color) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button button = null;
                switch (i * 3 + j) { // Corrected calculation for button indexing
                    case 0:
                        button = one;
                        break;
                    case 1:
                        button = two;
                        break;
                    case 2:
                        button = three;
                        break;
                    case 3:
                        button = four;
                        break;
                    case 4:
                        button = five;
                        break;
                    case 5:
                        button = six;
                        break;
                    case 6:
                        button = seven;
                        break;
                    case 7:
                        button = eight;
                        break;
                    case 8:
                        button = nine;
                        break;
                }
                Log.d("updateBoard", "i: " + i + " j: " + j);

                if (button != null) {
                    if (board.getGame()[i][j]) {
                        button.setBackgroundTintList(ContextCompat.getColorStateList(requireContext(), color));
                    } else {
                        button.setBackgroundTintList(ContextCompat.getColorStateList(requireContext(), R.color.primary));
                    }
                }
                else {
                    Log.d("NullButton", "i: " + i + " j: " + j);

                }
            }
        }
        Log.d("GameFragment",board.getGame()[0][2]?"true":"false" );

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Set binding to null to avoid memory leaks
        binding = null;
    }
}