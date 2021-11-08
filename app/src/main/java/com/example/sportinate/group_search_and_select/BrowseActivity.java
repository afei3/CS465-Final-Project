package com.example.sportinate.group_search_and_select;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.LinearLayout;

import com.example.sportinate.bottom_nav_ui.groups.GroupsFragment;
import com.example.sportinate.bottom_nav_ui.home.HomeFragment;
import com.example.sportinate.bottom_nav_ui.profile.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.sportinate.group_search_and_select.GroupInfoActivity;

import com.example.sportinate.R;

public class BrowseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);

        BottomNavigationView navView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_groups, R.id.navigation_profile)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_browse);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        Bundle bundle = getIntent().getExtras();

        if (bundle != null && bundle.getInt("fragmentNumber") == 1) {
            navView.setSelectedItemId(R.id.navigation_profile);
        } else if (bundle != null && bundle.getInt("fragmentNumber") == 2) {
            navView.setSelectedItemId(R.id.navigation_home);
        } else {
            navView.setSelectedItemId(R.id.navigation_groups);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("fragmentNumber", 1);
            GroupsFragment group = new GroupsFragment();
            group.setArguments(bundle2);
        }

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

    }


}