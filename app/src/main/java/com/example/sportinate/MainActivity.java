package com.example.sportinate;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sportinate.group_search_and_select.BrowseActivity;

import java.security.acl.Group;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //TODO: Create dummy groups
        for (int i = 0; i < 5; i++) {
            GroupInfo.groups_create.add(new GroupInfo());
            GroupInfo.joined_groups.add(new GroupInfo());
        }
        setContentView(R.layout.activity_main);

        Button make_profile_button = findViewById(R.id.make_profile_button);
        make_profile_button.setOnClickListener(new View.OnClickListener() {
            //TODO change to go to profile activity
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, com.example.sportinate.profile_creation.LandingProfileActivity.class);
                startActivity(intent);
            }
        });

        Button skip_button = findViewById(R.id.skip_button);
        skip_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BrowseActivity.class);
                intent.putExtra("fragmentNumber",2); //for example
                startActivity(intent);
            }
        });
    } }
