package com.example.sportinate.group_search_and_select;

import android.os.Bundle;
import android.widget.TextView;
import com.example.sportinate.profile_creation.UserInfo;
import com.example.sportinate.bottom_nav_ui.groups.GroupsFragment;
import com.example.sportinate.profile_creation.UserDescriptionActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.example.sportinate.profile_creation.UserInfo;
import com.example.sportinate.bottom_nav_ui.profile.ProfileFragment;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.sportinate.R;

import java.io.Serializable;

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
        //Bundle bundle = getIntent().getBundleExtra("fragmentNumber");


        if (bundle != null && bundle.getInt("fragmentNumber") == 1) {
            ProfileFragment myFragment = new ProfileFragment();
            Bundle bundle3= new Bundle();
            Serializable se = getIntent().getSerializableExtra("key");
            if(se instanceof UserInfo){
                UserInfo db = (UserInfo) se;
                String name_user = db.getName();
                String descrip_user = db.getDescrip();
                bundle3.putString("name",name_user);
                bundle3.putString("descrip",descrip_user);
                myFragment.setArguments(bundle3);
            }

            navView.setSelectedItemId(R.id.navigation_profile);
        } else if (bundle != null && bundle.getInt("fragmentNumber") == 2) {
            navView.setSelectedItemId(R.id.navigation_home);
        }
        else if (bundle != null && bundle.getInt("fragmentNumber") == 3) {

            Bundle bundle2 = new Bundle();
            bundle2.putInt("fragmentNumber", 1);
            GroupsFragment group = new GroupsFragment();
            group.setArguments(bundle2);

            //TODO figure out how to display new instance of fragment every time bottom nav "My Groups" is clicked
            navController.navigate(R.id.navigation_groups);
        }
    }
    public String getTitles(){
        return "hello";
    }
}