package com.example.sportinate.group_search_and_select;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sportinate.MainActivity;
import com.example.sportinate.R;
import com.example.sportinate.bottom_nav_ui.groups.GroupsFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class GroupInfoActivity extends AppCompatActivity {

    public Boolean showGroup1 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_info);

        Button join_button = findViewById(R.id.join_button);
        join_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //To-do change to go to feedback screen (Sruthi)
                Intent intent = new Intent (GroupInfoActivity.this, BrowseActivity.class);
                intent.putExtra("fragmentNumber", true);
                startActivity(intent);
            }
        });
    }
}