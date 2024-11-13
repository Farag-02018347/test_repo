/***********************************************
 Author: <Theodor Farag>
 Date: <11/3/24>
 Purpose: <The purpose of the program is to utulizage fragments and the usage of a top and bottom menu
 as well as implementing a game in the main screen where the user can change the color of the on switches>
 What Learned: <I learned how to use SharedPreferences where the user can save data that isn't done through args
 which makes the movement of data easier to move around >
 Sources of Help: <android website, class slides>
 Time Spent: <14-15 hours>
 Extra Points Explanation: <I added a scroll naviagation view on the instructions page
 I made the start button into a restart button onces its been clicked once
 I changed the color of the topbar to be the off color of the boxs to make it more visually pleasing
 used HTML styling in the help fragment to make the instructions better to look at
 Did a spinner that once a new color is selected it automatically changes the color despite using the back button>
 ***********************************************/
package com.example.hw6;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.hw6.databinding.ActivityMainBinding;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        NavController navController =
                Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.onNavDestinationSelected(item,
                navController) || super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        //initialize binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot(); // getting the root layout of main activity and setting the content
        setContentView(view);



        //set up the toolbar;
        MaterialToolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);

        //get a reference to the navigation controller from navigation host
        NavHostFragment navHostFragment = (NavHostFragment) binding.navHostFragment.getFragment();
        NavController navController = navHostFragment.getNavController();
//create an “AppBarConfiguration” object
        AppBarConfiguration.Builder builder = new
                AppBarConfiguration.Builder(navController.getGraph());
        AppBarConfiguration appBarConfiguration = builder.build();

//link “AppBarConfigtureation” to the toolbar
        NavigationUI.setupWithNavController(toolbar, navController,
                appBarConfiguration);
        BottomNavigationView bottomNavigationView = binding.bottomNav;
        NavigationUI.setupWithNavController(bottomNavigationView,
                navController);

        ViewCompat.setOnApplyWindowInsetsListener(binding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}

/*
Mobile App Development I -- COMP.4630 Honor Statement
The practice of good ethical behavior is essential for maintaining
good order in the classroom, providing an enriching learning
experience for students, and training as a practicing computing
professional upon graduation. This practice is manifested in the
University's Academic Integrity policy. Students are expected to
strictly avoid academic dishonesty and adhere to the Academic
Integrity policy as outlined in the course catalog. Violations will be
dealt with as outlined therein. All programming assignments in this
class are to be done by the student alone unless otherwise specified.
No outside help is permitted except the instructor and approved tutors.
I certify that the work submitted with this assignment is mine and was
generated in a manner consistent with this document, the course
academic policy on the course website on Blackboard, and the UMass
Lowell academic code.
Date: 11/3/24
Name: Theodor Farag
*/
