package com.example.sportinate.profile_creation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sportinate.GroupInfo;
import com.example.sportinate.R;
import com.example.sportinate.profile_creation.profile_creation;
import com.example.sportinate.group_search_and_select.BrowseActivity;



public class profile_creation_comfirm extends AppCompatActivity {
    public GroupInfo group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_feedback);
        group = (GroupInfo) getIntent().getSerializableExtra("group");
        //TODO: send group information to group list

        Button create_another_group_button = findViewById(R.id.add_new_sport);
        create_another_group_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.sportinate.profile_creation.profile_creation_comfirm.this, profile_creation.class);
                startActivity(intent);
            }
        });


        Button browse_groups_button = findViewById(R.id.browse_groups);
        browse_groups_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(com.example.sportinate.profile_creation.profile_creation_comfirm.this, BrowseActivity.class);
                intent.putExtra("fragmentNumber", 1);
                startActivity(intent);
            }
        });

    }
}